package com.atguigu.atcrowdfunding.manager.service;

import java.util.Map;

import com.atguigu.atcrowdfunding.bean.User;

public interface UserService {
	
	public User queryUserByLogin(Map<String,Object> paramMap);

}
