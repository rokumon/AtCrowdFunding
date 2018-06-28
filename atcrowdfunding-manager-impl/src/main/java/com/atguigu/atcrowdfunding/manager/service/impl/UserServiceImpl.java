package com.atguigu.atcrowdfunding.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.exception.UserLoginException;
import com.atguigu.atcrowdfunding.exception.UserRegistException;
import com.atguigu.atcrowdfunding.manager.dao.UserDao;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;
import com.atguigu.atcrowdfunding.util.Page;

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

	@Override
	public void addUser(Map<String, Object> paramMap) {
		
		//加密
		String userpswd = MD5Util.digest((String) paramMap.get("userpswd"));
		
		//调用DAO查询
		User user = userDao.queryUserByLogin(paramMap);
		
		//用户名已存在
		if (user != null) {
			throw new UserRegistException(Const.REGIST_REGISTACCT_ERROR);
		}
		
		paramMap.put("userpswd", userpswd);
		
		Integer changedRow = userDao.insert(paramMap);
		
		if(changedRow != 1) {
			throw new UserRegistException(Const.REGIST_REGISTINSERT_ERROR);
		}
	}

	@Override
	public Page<User> queryUserByPage(Map<String, Object> paramMap) {

		Integer pageno = (Integer) paramMap.get("pageno");
		Integer pagesize = (Integer) paramMap.get("pagesize");
		
		Page<User> page = new Page<>(pageno, pagesize);
		
		Integer startIndex = page.getStartindex();
		paramMap.put("startIndex", startIndex);
		
		List<User> dates = userDao.queryUserList(paramMap);
		
		Integer totalsize = userDao.countUser();
		
		page.setDatas(dates);
		page.setTotalsize(totalsize);
		
		return page;
	}

	@Override
	public User queryUserById(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public void deleteUser(Integer[] id) {
		userDao.deleteUsersByPrimaryKey(id);
	}

	@Override
	public void updateUser(Map<String, Object> paramMap) {
		userDao.updateUser(paramMap);
	}
	
}
