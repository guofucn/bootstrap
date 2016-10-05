package com.jc.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jc.ssm.model.MarketPlace;

@Component
public interface MarketPlaceDao {
	public int insert(MarketPlace marketPlace);
	public int update(MarketPlace matketPlace);
	public int delete(MarketPlace matketPlace);
	public int deleteById(long id);
	public List<MarketPlace> listAll();
	public MarketPlace getById(long id);
}
