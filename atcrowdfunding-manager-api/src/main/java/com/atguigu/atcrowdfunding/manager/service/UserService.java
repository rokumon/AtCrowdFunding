package com.atguigu.atcrowdfunding.manager.service;

import java.util.Map;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.util.Page;

public interface UserService {
	
	public User queryUserByLogin(Map<String,Object> paramMap);
	
	public void addUser(Map<String,Object> paramMap);

	public Page<User> queryUserByPage(Map<String, Object> paramMap);

	public User queryUserById(Integer id);

	public void deleteUser(Integer[] id);
}
