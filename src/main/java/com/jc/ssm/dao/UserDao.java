package com.jc.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.jc.ssm.model.User;

@Component
public interface UserDao {
	public User getById(int id);
	public User getByUserName(String userName);
	public int updatePassword(@Param("id")int id, @Param("password")String password);
}
