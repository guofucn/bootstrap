package com.jc.ssm.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amazonservices.mws.orders._2013_09_01.model.Order;
import com.amazonservices.mws.orders._2013_09_01.model.OrderItem;
import com.jc.ssm.dao.OrderDetailDao;
import com.jc.ssm.dao.SalesOrderDao;
import com.jc.ssm.model.OrderDetail;
import com.jc.ssm.model.SalesOrder;

@Component
public class SaveOrderService {
	private SalesOrderDao salesOrderDao;
	private OrderDetailDao orderDetailDao;

	public OrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}

	@Resource
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	public SalesOrderDao getSalesOrderDao() {
		return salesOrderDao;
	}

	@Resource
	public void setSalesOrderDao(SalesOrderDao salesOrderDao) {
		this.salesOrderDao = salesOrderDao;
	}


	@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)	
	public void saveSalesOrder(long userId, Order order, List<OrderItem> orderItems){
		SalesOrder salesOrder = null;
		salesOrder = salesOrderDao.findByAmazonOrderId(userId, order.getAmazonOrderId());
		if (salesOrder == null){
			salesOrder = new SalesOrder();
			salesOrder.setUserId(userId);
			amazoneOrderToSalesOrder(salesOrder, order);
			salesOrderDao.insert(salesOrder);
		} else{
			amazoneOrderToSalesOrder(salesOrder, order);
			salesOrderDao.update(salesOrder);
		}
		for(OrderItem orderItem: orderItems){
			saveOrderItem(salesOrder.getId(),orderItem);
		}
	}

	private void saveOrderItem(long salesOrderId, OrderItem orderItem){
		OrderDetail orderDetail = null;
		orderDetail = orderDetailDao.findByItemId(salesOrderId, orderItem.getOrderItemId());
		if (orderDetail == null){
			orderDetail = new OrderDetail();
			orderDetail.setSalesOrderId(salesOrderId);
			amazonOrderItemToOrderDetail(orderItem, orderDetail);
			orderDetailDao.insert(orderDetail);
		} else{
			amazonOrderItemToOrderDetail(orderItem, orderDetail);
			orderDetailDao.update(orderDetail);
		}
	}
	/**
	 * 亚马逊订单转本地订单
	* @Title: AmazoneOrderToSalesOrder  
	* @Description: TODO
	* @param @param salesOrder
	* @param @param order
	* @param @return
	* @return SalesOrder
	* @throws
	 */
	private void amazoneOrderToSalesOrder(SalesOrder salesOrder, Order order) {
		salesOrder.setAmazonOrderId(order.getAmazonOrderId());
		salesOrder.setSellerOrderId(order.getSellerOrderId());
		salesOrder.setPurchaseDate(order.getPurchaseDate().toGregorianCalendar().getTime());
		if(order.getLastUpdateDate() != null){
			salesOrder.setLastUpdateDate(order.getLastUpdateDate().toGregorianCalendar().getTime());
		}
		salesOrder.setOrderStatus(order.getOrderStatus());
		salesOrder.setFulfillmentChannel(order.getFulfillmentChannel());
		salesOrder.setSalesChannel(order.getSalesChannel());
		salesOrder.setOrderChannel(order.getOrderChannel());
		salesOrder.setShipServiceLevel(order.getShipServiceLevel());
		if(order.getShippingAddress() != null){
			salesOrder.setName(order.getShippingAddress().getName());
			salesOrder.setAddressLine1(order.getShippingAddress().getAddressLine1());
			salesOrder.setAddressLine2(order.getShippingAddress().getAddressLine2());
			salesOrder.setAddressLine3(order.getShippingAddress().getAddressLine3());
			salesOrder.setCity(order.getShippingAddress().getCity());
			salesOrder.setCounty(order.getShippingAddress().getCounty());
			salesOrder.setCountryCode(order.getShippingAddress().getCountryCode());
			salesOrder.setDistrict(order.getShippingAddress().getDistrict());
			salesOrder.setStateOrRegion(order.getShippingAddress().getStateOrRegion());
			salesOrder.setPostalCode(order.getShippingAddress().getPostalCode());
			salesOrder.setPhone(order.getShippingAddress().getPhone());
		}
		if (order.getOrderTotal() != null){
			salesOrder.setAmount(new BigDecimal(order.getOrderTotal().getAmount() == null? "0":order.getOrderTotal().getAmount()));
			salesOrder.setCurrencyCode(order.getOrderTotal().getCurrencyCode());
		}
		salesOrder.setNumberOfItemsShipped(order.getNumberOfItemsShipped());
		salesOrder.setNumberOfItemsUnshipped(order.getNumberOfItemsUnshipped());
		salesOrder.setPaymentMethod(order.getPaymentMethod());
		salesOrder.setMarketplaceId(order.getMarketplaceId());
		salesOrder.setBuyerEmail(order.getBuyerEmail());
		salesOrder.setBuyerName(order.getBuyerName());
		salesOrder.setShipmentServiceLevelCategory(order.getShipmentServiceLevelCategory());
		salesOrder.setShippedByAmazonTFM(order.getShippedByAmazonTFM() == null ? false: order.getShippedByAmazonTFM());
		salesOrder.setCbaDisplayableShippingLabel(order.getCbaDisplayableShippingLabel());
		salesOrder.setOrderType(order.getOrderType());
		if (order.getEarliestShipDate() != null){
			salesOrder.setEarliestShipDate(order.getEarliestShipDate().toGregorianCalendar().getTime());
		}
		if (order.getLatestShipDate() != null){
			salesOrder.setLatestShipDate(order.getLatestShipDate().toGregorianCalendar().getTime());
		}
		if (order.getEarliestDeliveryDate() != null){
			salesOrder.setEarliestDeliveryDate(order.getEarliestDeliveryDate().toGregorianCalendar().getTime());
		}
		if (order.getLatestDeliveryDate() != null){
			salesOrder.setLatestDeliveryDate(order.getLatestDeliveryDate().toGregorianCalendar().getTime());
		}
	}
	
	public void amazonOrderItemToOrderDetail(OrderItem orderItem, OrderDetail orderDetail){
		orderDetail.setAsin(orderItem.getASIN());
		orderDetail.setSellerSKU(orderItem.getSellerSKU());
		orderDetail.setOrderItemId(orderItem.getOrderItemId());
		orderDetail.setTitle(orderItem.getTitle());
		orderDetail.setQuantityOrdered(orderItem.getQuantityOrdered());
		orderDetail.setQuantityShipped(orderItem.getQuantityShipped());
		orderDetail.setGiftMessageText(orderItem.getGiftMessageText());
		orderDetail.setGiftWrapLevel(orderItem.getGiftWrapLevel());
		if (orderItem.getItemPrice() != null){
			orderDetail.setItemPrice(new BigDecimal(orderItem.getItemPrice().getAmount()));
			orderDetail.setItemPriceCurrencyCode(orderItem.getItemPrice().getCurrencyCode());
		}
		if (orderItem.getShippingPrice() != null){
			orderDetail.setShippingPrice(new BigDecimal(orderItem.getShippingPrice().getAmount()));
			orderDetail.setShippingPriceCurrencyCode(orderItem.getShippingPrice().getCurrencyCode());
		}
		if (orderItem.getGiftWrapPrice() != null){
			orderDetail.setGiftWrapPrice(new BigDecimal(orderItem.getGiftWrapPrice().getAmount()));
			orderDetail.setGiftWrapPriceCurrencyCode(orderItem.getShippingPrice().getCurrencyCode());
		}
		if (orderItem.getItemTax() != null){
			orderDetail.setItemTax(new BigDecimal(orderItem.getItemTax().getAmount()));
			orderDetail.setItemTaxCurrencyCode(orderItem.getItemTax().getCurrencyCode());
		}
		if (orderItem.getShippingTax() != null){
			orderDetail.setShippingTax(new BigDecimal(orderItem.getShippingTax().getAmount()));
			orderDetail.setShippingTaxCurrencyCode(orderItem.getShippingTax().getCurrencyCode());
		}
		if (orderItem.getGiftWrapTax() != null){
			orderDetail.setGiftWrapTax(new BigDecimal(orderItem.getGiftWrapTax().getAmount()));
			orderDetail.setGiftWrapTaxCurrencyCode(orderItem.getGiftWrapTax().getCurrencyCode());
		}
		if (orderItem.getShippingDiscount() != null){
			orderDetail.setShippingDiscount(new BigDecimal(orderItem.getShippingDiscount().getAmount()));
			orderDetail.setShippingDiscountCurrencyCode(orderItem.getShippingDiscount().getCurrencyCode());
		}
		if (orderItem.getPromotionDiscount() != null){
			orderDetail.setPromotionDiscount(new BigDecimal(orderItem.getPromotionDiscount().getAmount()));
			orderDetail.setPromotionDiscountCurrencyCode(orderItem.getPromotionDiscount().getCurrencyCode());
		}
		if (orderItem.getCODFee() != null){
			orderDetail.setCodFee(new BigDecimal(orderItem.getCODFee().getAmount()));
			orderDetail.setCodFeeCurrencyCode(orderItem.getCODFee().getCurrencyCode());
		}
		if (orderItem.getCODFeeDiscount() != null){
			orderDetail.setCodFeeDiscount(new BigDecimal(orderItem.getCODFeeDiscount().getAmount()));
			orderDetail.setCodFeeDiscountCurrencyCode(orderItem.getCODFeeDiscount().getCurrencyCode());
		}
	}
}
