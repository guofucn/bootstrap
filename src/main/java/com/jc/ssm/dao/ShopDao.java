package com.jc.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jc.ssm.model.Shop;

@Repository
public interface ShopDao {
	public Shop getById(long id);
	public int update(Shop shop);
	public int insert(Shop shop);
	public int delete(Shop shop);
	public int deleteById(long id);
	public List<Shop> listShop(long userId);
	public int delUserShop(@Param("userId")long userId, @Param("id")Long id);
}
