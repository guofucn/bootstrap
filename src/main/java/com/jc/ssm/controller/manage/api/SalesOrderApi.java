package com.jc.ssm.controller.manage.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jc.ssm.controller.base.JsonMap;
import com.jc.ssm.model.OrderDetail;
import com.jc.ssm.model.SalesOrder;
import com.jc.ssm.service.SalesOrderService;

@RestController
public class SalesOrderApi {
	private SalesOrderService salesOrderService;
	
	@RequestMapping("/manage/api/getOrderDetail")
	public Object getOrderDetail(@RequestParam(value = "salesOrderId", required=false)Long salesOrderId){
		JsonMap map = new JsonMap();
		if (salesOrderId != null){
			List<OrderDetail> orders = salesOrderService.getOrderDetail(salesOrderId);
			map.put("orderDetail", orders);
		}
		return map;
	}

	@RequestMapping("/manage/api/getOrderDetail2")
	public Object getJSON(@RequestParam(value = "salesOrderId", required=false)Long salesOrderId) {
		JsonMap map = new JsonMap();
		List<OrderDetail> orders = salesOrderService.getOrderDetail(salesOrderId);
		SalesOrder salesOrder = salesOrderService.findSalesOrder(salesOrderId);
		map.put("detail", orders);
		map.put("salesOrder", salesOrder);
		map.put("status", "成功");
		return map;
	}
	
	public SalesOrderService getSalesOrderService() {
		return salesOrderService;
	}

	@Resource
	public void setSalesOrderService(SalesOrderService salesOrderService) {
		this.salesOrderService = salesOrderService;
	}

}
