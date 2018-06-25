package com.atguigu.atcrowdfunding.manager.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.User;

public interface UserDao {
	
	int deleteByPrimaryKey(Integer id);

    int insert(Map<String, Object> paramMap);
    
    User selectByLogin(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

	User queryUserByLogin(Map<String, Object> paramMap);
    
}
