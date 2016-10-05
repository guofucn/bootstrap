package com.jc.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jc.ssm.dao.MarketPlaceDao;
import com.jc.ssm.model.MarketPlace;

@Component
public class MarketPlaceService {
	private MarketPlaceDao marketPlaceDao;

	public MarketPlaceDao getMarketPlaceDao() {
		return marketPlaceDao;
	}

	@Resource
	public void setMarketPlaceDao(MarketPlaceDao marketPlaceDao) {
		this.marketPlaceDao = marketPlaceDao;
	}
	
	public List<MarketPlace> listAll(){
		return marketPlaceDao.listAll();
	}
}
