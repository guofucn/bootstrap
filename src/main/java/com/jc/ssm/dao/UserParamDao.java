package com.jc.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.jc.ssm.model.UserParam;

@Component
public interface UserParamDao {
	public int insert(UserParam userParam);
	public int update(UserParam userParam);
	public int delete(UserParam userParam);
	public int deleteById(long id);
	public UserParam findById(long id);
	public UserParam getUserParam(@Param("userId")long userId, @Param("paramName")String paramName); 
}
