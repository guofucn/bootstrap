package com.jc.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jc.ssm.dao.ShopDao;
import com.jc.ssm.model.Shop;

@Component
public class ShopService {
	private ShopDao shopDao;

	public ShopDao getShopDao() {
		return shopDao;
	}

	@Resource
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}

	public int saveShop(Shop shop){
		if (shop.getId() == null ){
			return shopDao.insert(shop);
		} else{
			return shopDao.update(shop);
		}
	}

	public List<Shop> listShop(long userId) {
		return shopDao.listShop(userId);
	}
	public Shop getShopById(long id){
		return shopDao.getById(id);
	}

	public int delUserShop(long userId, Long id) {
		shopDao.delUserShop(userId, id);
		return 1;
	}
}
