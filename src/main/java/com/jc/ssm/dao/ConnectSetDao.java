package com.jc.ssm.dao;

import org.springframework.stereotype.Component;
import com.jc.ssm.model.ConnectSet;

@Component
public interface ConnectSetDao {
	public ConnectSet getById(int id);
	public ConnectSet getByUserId(long userId);
	public int update(ConnectSet connetSet);
	public int insert(ConnectSet connectSet);
	public int updateByUserId(ConnectSet connectSet);
}
