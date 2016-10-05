package com.jc.ssm.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.jc.ssm.model.SalesOrder;

@Component
public interface SalesOrderDao {
	public int insert(SalesOrder salesOrder);
	public int update(SalesOrder salesOrder);
	public int delete(SalesOrder salesOrder);
	public int deleteById(long id);
	public SalesOrder findById(long id);
	public SalesOrder findByAmazonOrderId(@Param("userId")long userId, @Param("amazonOrderId")String amazonOrderId);
	public List<SalesOrder> search(@Param("userId")long userId, @Param("purchaseDateStart")Date purchaseDateStart, 
			@Param("purchaseDateEnd")Date purchaseDateEnd, @Param("orderStatus")String orderStatus, 
			@Param("rowNo") int rowNo, @Param("pageSize")int pageSize);
	public int searchCount(@Param("userId")long userId, @Param("purchaseDateStart")Date purchaseDateStart, 
			@Param("purchaseDateEnd")Date purchaseDateEnd, @Param("orderStatus")String orderStatus);
}
