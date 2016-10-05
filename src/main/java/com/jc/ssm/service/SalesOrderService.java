package com.jc.ssm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amazonservices.mws.orders._2013_09_01.MarketplaceWebServiceOrdersException;
import com.jc.ssm.dao.ConnectSetDao;
import com.jc.ssm.dao.OrderDetailDao;
import com.jc.ssm.dao.SalesOrderDao;
import com.jc.ssm.dao.ShopDao;
import com.jc.ssm.dao.UserParamDao;
import com.jc.ssm.model.ConnectSet;
import com.jc.ssm.model.OrderDetail;
import com.jc.ssm.model.SalesOrder;
import com.jc.ssm.model.Shop;
import com.jc.ssm.model.UserParam;
import com.jc.ssm.util.DateTimeUtil;
import com.jc.ssm.util.Helper;

/**
 * 订单同步与处理服务
* @ClassName: SalesOrderService  
* @author guofu 81378536.qq.com  
* @date 2016年5月23日 下午4:11:41  
*
 */
@Service
public class SalesOrderService {
	private ShopDao shopDao;
	private ConnectSetDao connectSetDao;
	private SalesOrderDao salesOrderDao;
	private OrderDetailDao orderDetailDao;
	public OrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}
	
	@Resource
	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	private UserParamDao userParamDao;
	private AmazonOrderApi amazonOrderApi;
	
	public ShopDao getShopDao() {
		return shopDao;
	}

	@Resource
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	public String syncOrder(long userId) {
		ConnectSet connectSet = connectSetDao.getByUserId(userId);
		List<Shop> shops = shopDao.listShop(userId);
		Date currDate = new Date();
		Date start = currDate;
		Date end = new Date(currDate.getTime() - 1000 * 60 * 60 * 8 - 1000 * 60 * 3); //世界标准时间，订单时间延时3分钟
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		UserParam userParam = userParamDao.getUserParam(userId, "last_update");
		if (userParam == null){
			userParam = new UserParam();
			userParam.setUserId(userId);
			userParam.setParamName("last_update");
			userParam.setParamValue(sdf.format(new Date(currDate.getTime() - 3600 * 1000 * 24 * 6))); //从6天前开始
			userParamDao.insert(userParam);
		}
		
		try {
			start = sdf.parse(userParam.getParamValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//循环下载订单，每次下载一天
		while (start.getTime() < end.getTime()){
			Date next = new Date(start.getTime() + 1000 * 3600 * 24);
			if (next.getTime() > end.getTime()){
				next = end;
			}
				
			for (Shop shop : shops) {
				try{
					amazonOrderApi.listAllOrder(userId, connectSet, shop, start, next);
				}
				catch(MarketplaceWebServiceOrdersException e){
					Helper.logErr("订单同步次数受限,请稍后再试。");
					e.printStackTrace();
					if (e.getMessage() != null && e.getMessage().equals("Request is throttled")){
						return "订单同步次数受限,请稍后再试。";
					} else {
						e.printStackTrace();
						return "连接亚马逊服务器失败";
					}
				}
				catch (Exception e){
					Helper.logErr("订单同步次数受限,请稍后再试。");
					e.printStackTrace();
					if (e.getMessage() != null && e.getMessage().equals("Request is throttled")){
						return "订单同步次数受限,请稍后再试。";
					} else {
						e.printStackTrace();
						return "同步出错了";
					}
				}
			}
			userParam.setParamValue(sdf.format(next));
			userParamDao.update(userParam);
			start = next;
		}
		return null;
	}

	public ConnectSetDao getConnectSetDao() {
		return connectSetDao;
	}

	@Resource
	public void setConnectSetDao(ConnectSetDao connectSetDao) {
		this.connectSetDao = connectSetDao;
	}

	public SalesOrderDao getSalesOrderDao() {
		return salesOrderDao;
	}

	@Resource
	public void setSalesOrderDao(SalesOrderDao salesOrderDao) {
		this.salesOrderDao = salesOrderDao;
	}

	public UserParamDao getUserParamDao() {
		return userParamDao;
	}

	@Resource
	public void setUserParamDao(UserParamDao userParamDao) {
		this.userParamDao = userParamDao;
	}
	
	public List<SalesOrder> search(long userId, Date start, Date end, String status, int pageNo, int pageSize){
		end = DateTimeUtil.addDay(end, 1);
		return salesOrderDao.search(userId, start, end, status, (pageNo - 1) * pageSize , pageSize);
	}
	public int searchCount(long userId, Date start, Date end, String status){
		end = DateTimeUtil.addDay(end, 1);
		return salesOrderDao.searchCount(userId, start, end, status);
	}

	public AmazonOrderApi getAmazonOrderApi() {
		return amazonOrderApi;
	}

	@Resource
	public void setAmazonOrderApi(AmazonOrderApi amazonOrderApi) {
		this.amazonOrderApi = amazonOrderApi;
	}

	public List<OrderDetail> getOrderDetail(long salesOrderId){
		return orderDetailDao.findBySalesOrderId(salesOrderId);
	}
	public SalesOrder findSalesOrder(long id){
		return salesOrderDao.findById(id);
	}
}
