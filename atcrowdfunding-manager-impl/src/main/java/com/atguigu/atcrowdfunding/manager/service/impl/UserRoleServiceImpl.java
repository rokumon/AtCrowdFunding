package com.atguigu.atcrowdfunding.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.manager.dao.UserRoleDao;
import com.atguigu.atcrowdfunding.manager.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	UserRoleDao userRoleDao; 

	@Override
	public List<Integer> queryRoleIdsByUserId(Integer userId) {
		return userRoleDao.selectRoleIdsByUserId(userId);
	}

	@Override
	public List<Integer> queryUserIdsByRoleId(Integer roleId) {
		return userRoleDao.selectUserIdsByRoleId(roleId);
	}

	@Override
	public void addRecoreds(Map<String, Object> paramMap) {
		userRoleDao.insertRecoreds(paramMap);
		
	}

	@Override
	public void removeRecoreds(Map<String, Object> paramMap) {
		userRoleDao.deleteRecoreds(paramMap);
	}

}
