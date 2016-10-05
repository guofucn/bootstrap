package com.jc.ssm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jc.ssm.dao.ConnectSetDao;
import com.jc.ssm.model.ConnectSet;

@Component
public class ConnectSetService {
	private ConnectSetDao connectSetDao;

	public ConnectSetDao getConnectSetDao() {
		return connectSetDao;
	}

	@Resource
	public void setConnectSetDao(ConnectSetDao connectSetDao) {
		this.connectSetDao = connectSetDao;
	}

	public ConnectSet getConnectSet(long userId){
		return connectSetDao.getByUserId(userId);
	}
	
	public int updateConnectSet(ConnectSet connectSet){
		if (connectSetDao.getByUserId(connectSet.getUserId()) == null){
			return connectSetDao.insert(connectSet);
		} else{
			return connectSetDao.updateByUserId(connectSet);
		}
	}
}
