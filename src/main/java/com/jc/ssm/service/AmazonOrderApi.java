package com.jc.ssm.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Component;

import com.amazonservices.mws.client.MwsUtl;
import com.amazonservices.mws.orders._2013_09_01.MarketplaceWebServiceOrdersAsyncClient;
import com.amazonservices.mws.orders._2013_09_01.MarketplaceWebServiceOrdersConfig;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsByNextTokenRequest;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsByNextTokenResponse;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsRequest;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrderItemsResponse;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrdersByNextTokenRequest;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrdersByNextTokenResponse;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrdersRequest;
import com.amazonservices.mws.orders._2013_09_01.model.ListOrdersResponse;
import com.amazonservices.mws.orders._2013_09_01.model.Order;
import com.amazonservices.mws.orders._2013_09_01.model.OrderItem;
import com.jc.ssm.model.ConnectSet;
import com.jc.ssm.model.Shop;

@Component
public class AmazonOrderApi {
	private SaveOrderService saveOrderService;

	public int listAllOrder(long userId, ConnectSet connectSet, Shop shop, Date startTime, Date endTime) {
		int orderCount = 0;
		ListOrdersResponse listOrdersResponse = listOrder(connectSet, shop, startTime, endTime, 50);
		orderCount = listOrdersResponse.getListOrdersResult().getOrders().size();
		if (orderCount == 0) {
			return orderCount;
		}

		// 保存订单
		for (Order order : listOrdersResponse.getListOrdersResult().getOrders()) {
			List<OrderItem> orderItems = getOrderItems(connectSet, shop, order);
			saveOrderService.saveSalesOrder(userId, order, orderItems);
		}

		String token = listOrdersResponse.getListOrdersResult().getNextToken();
		while (token != null) {
			ListOrdersByNextTokenResponse listOrdersByNextTokenResponse = listOrderByNextToken(connectSet, shop, token);
			if (listOrdersByNextTokenResponse.getListOrdersByNextTokenResult().getOrders().size() == 0) {
				break;
			}
			token = listOrdersByNextTokenResponse.getListOrdersByNextTokenResult().getNextToken();
			orderCount += listOrdersByNextTokenResponse.getListOrdersByNextTokenResult().getOrders().size();
			// 保存订单
			for (Order order : listOrdersByNextTokenResponse.getListOrdersByNextTokenResult().getOrders()) {
				List<OrderItem> orderItems = getOrderItems(connectSet, shop, order);
				saveOrderService.saveSalesOrder(userId, order, orderItems);
			}
		}
		return orderCount;
	}

	/**
	 * 同步订单 @Title: syncOrderByUpdateTime @Description: TODO @param @param
	 * userId @param @param startTime @param @param endTime @return void @throws
	 */
	public ListOrdersResponse listOrder(ConnectSet connectSet, Shop shop, Date startTime, Date endTime,
			int maxResultsPerPage) {
		MarketplaceWebServiceOrdersConfig config = new MarketplaceWebServiceOrdersConfig();
		config.setServiceURL(shop.getUrl());
		MarketplaceWebServiceOrdersAsyncClient client = new MarketplaceWebServiceOrdersAsyncClient(
				connectSet.getAccessKey(), connectSet.getSecretKey(), "replaceWithAppName", "replaceWithAppVersion",
				config, null);
		ListOrdersRequest request = new ListOrdersRequest();
		String sellerId = connectSet.getSellerId();
		request.setSellerId(sellerId);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startTime);

		XMLGregorianCalendar start = MwsUtl.getDTF().newXMLGregorianCalendar();
		try {
			start = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
					calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), 0, 0, 0);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		request.setLastUpdatedAfter(start); // 开始时间

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(endTime);
		XMLGregorianCalendar end = MwsUtl.getDTF().newXMLGregorianCalendar();

		try {
			end = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar2.get(Calendar.YEAR),
					calendar2.get(Calendar.MONTH) + 1, calendar2.get(Calendar.DAY_OF_MONTH),
					calendar2.get(Calendar.HOUR_OF_DAY), calendar2.get(Calendar.MINUTE), 0, 0, 0);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		request.setLastUpdatedBefore(end); // 结束时间

		List<String> marketplaceId = new ArrayList<String>();
		marketplaceId.add(shop.getMarketPlaceId());
		request.setMarketplaceId(marketplaceId);
		request.setMaxResultsPerPage(maxResultsPerPage);
		ListOrdersResponse response = client.listOrders(request); // 发出请求
		return response;
	}

	public ListOrdersByNextTokenResponse listOrderByNextToken(ConnectSet connectSet, Shop shop, String nextToken) {
		MarketplaceWebServiceOrdersConfig config = new MarketplaceWebServiceOrdersConfig();
		config.setServiceURL(shop.getUrl());
		MarketplaceWebServiceOrdersAsyncClient client = new MarketplaceWebServiceOrdersAsyncClient(
				connectSet.getAccessKey(), connectSet.getSecretKey(), "replaceWithAppName", "replaceWithAppVersion",
				config, null);
		ListOrdersByNextTokenRequest request = new ListOrdersByNextTokenRequest();
		String sellerId = connectSet.getSellerId();
		request.setSellerId(sellerId);
		request.setNextToken(nextToken);

		List<String> marketplaceId = new ArrayList<String>();
		marketplaceId.add(shop.getMarketPlaceId());
		ListOrdersByNextTokenResponse response = client.listOrdersByNextToken(request); // 发出请求
		return response;
	}

	public SaveOrderService getSaveOrderService() {
		return saveOrderService;
	}

	@Resource
	public void setSaveOrderService(SaveOrderService saveOrderService) {
		this.saveOrderService = saveOrderService;
	}

	public ListOrderItemsResponse listOrderItems(ConnectSet connectSet, Shop shop, Order order) {
		MarketplaceWebServiceOrdersConfig config = new MarketplaceWebServiceOrdersConfig();
		config.setServiceURL(shop.getUrl());
		MarketplaceWebServiceOrdersAsyncClient client = new MarketplaceWebServiceOrdersAsyncClient(
				connectSet.getAccessKey(), connectSet.getSecretKey(), "replaceWithAppName", "replaceWithAppVersion",
				config, null);
		ListOrderItemsRequest request = new ListOrderItemsRequest();
		request.setSellerId(connectSet.getSellerId());
		request.setAmazonOrderId(order.getAmazonOrderId());

		ListOrderItemsResponse response = client.listOrderItems(request);
		return response;
	}

	public List<OrderItem> getOrderItems(ConnectSet connectSet, Shop shop, Order order) {
		ListOrderItemsResponse listOrderItemsResponse = listOrderItems(connectSet, shop, order);
		List<OrderItem> orderItem = listOrderItemsResponse.getListOrderItemsResult().getOrderItems();
		String nextToken = listOrderItemsResponse.getListOrderItemsResult().getNextToken();
		while (nextToken != null) {
			ListOrderItemsByNextTokenResponse listOrderItemsByNextTokenResponse = listOrderItemsByNextToken(connectSet,
					order, shop, nextToken);
			orderItem.addAll(listOrderItemsByNextTokenResponse.getListOrderItemsByNextTokenResult().getOrderItems());

			nextToken = listOrderItemsByNextTokenResponse.getListOrderItemsByNextTokenResult().getNextToken();
		}
		return orderItem;
	}

	private ListOrderItemsByNextTokenResponse listOrderItemsByNextToken(ConnectSet connectSet, Order order, Shop shop,
			String nextToken) {
		MarketplaceWebServiceOrdersConfig config = new MarketplaceWebServiceOrdersConfig();
		config.setServiceURL(shop.getUrl());
		MarketplaceWebServiceOrdersAsyncClient client = new MarketplaceWebServiceOrdersAsyncClient(
				connectSet.getAccessKey(), connectSet.getSecretKey(), "replaceWithAppName", "replaceWithAppVersion",
				config, null);
		ListOrderItemsByNextTokenRequest request = new ListOrderItemsByNextTokenRequest();
		request.setSellerId(connectSet.getSellerId());
		request.setNextToken(nextToken);

		request.setSellerId(connectSet.getSellerId());
		request.setNextToken(nextToken);

		ListOrderItemsByNextTokenResponse response = client.listOrderItemsByNextToken(request);
		return response;
	}
}
