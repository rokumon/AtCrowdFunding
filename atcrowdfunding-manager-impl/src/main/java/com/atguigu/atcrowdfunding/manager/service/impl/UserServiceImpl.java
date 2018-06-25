package com.atguigu.atcrowdfunding.manager.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.exception.UserLoginException;
import com.atguigu.atcrowdfunding.manager.dao.UserDao;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User queryUserByLogin(Map<String, Object> paramMap) {
		
		//加密
		String userpswd = MD5Util.digest((String) paramMap.get("userpswd"));
		
		//调用DAO查询
		User user = userDao.queryUserByLogin(paramMap);
		
		//用户名不存在
		if(user == null) {
			throw new UserLoginException(Const.LOGIN_LOGINACCT_ERROR);
		}
		
		//用户密码错误
		if(!userpswd.equals(user.getUserpswd())) {
			throw new UserLoginException(Const.LOGIN_USERPSWD_ERROR);
		}
		
		return user;
	}
	
	
	
	
}
