package com.jc.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jc.ssm.model.OrderDetail;

@Repository
public interface OrderDetailDao {
	public int insert(OrderDetail orderDetail);
	public int update(OrderDetail orderDetail);
	public int delete(OrderDetail orderDetail);
	public int deleteById(OrderDetail orderDetail);
	public OrderDetail findById(long id);
	public OrderDetail findByItemId(@Param("salesOrderId")long salesOrderId, @Param("orderItemId")String orderItemId);
	public List<OrderDetail> findBySalesOrderId(long salesOrderId);
}
