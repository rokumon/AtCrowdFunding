package com.atguigu.atcrowdfunding.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.exception.UserLoginException;
import com.atguigu.atcrowdfunding.exception.UserRegistException;
import com.atguigu.atcrowdfunding.manager.dao.RoleDao;
import com.atguigu.atcrowdfunding.manager.service.RoleService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.Page;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Role queryRoleByName(Map<String, Object> paramMap) {
		
		Role role = roleDao.selectByName(paramMap);
		
		//用户名不存在
		if(role == null) {
			throw new UserLoginException(Const.LOGIN_LOGINACCT_ERROR);
		}
		
		return role;
	}

	@Override
	public void addRole(Map<String, Object> paramMap) {
		
		
		// 调用DAO查询
		Role role = roleDao.selectByName(paramMap);

		// 用户名已存在
		if (role != null) {
			throw new UserRegistException(Const.REGIST_REGISTACCT_ERROR);
		}
		
		int changedRow = roleDao.insert(paramMap);
		
		if(changedRow != 1) {
			throw new UserRegistException(Const.REGIST_REGISTINSERT_ERROR);
		}
		
	}

	@Override
	public Page<Role> queryRoleByPage(Map<String, Object> paramMap) {
		
		Integer pageno = (Integer) paramMap.get("pageno");
		Integer pagesize = (Integer) paramMap.get("pagesize");
		
		Page<Role> page = new Page<Role>(pageno, pagesize); 
		
		Integer startIndex = page.getStartindex();
		paramMap.put("startIndex", startIndex);

		List<Role> dates = roleDao.queryRoleList(paramMap);
		
		Integer totalsize = roleDao.countRole(paramMap);
		
		page.setDatas(dates);
		page.setTotalsize(totalsize);
		
		return page;
	}

	@Override
	public Role queryRoleById(Integer id) {
		return roleDao.selectByPrimaryKey(id);
	}

	@Override
	public void deleteRole(Integer[] id) {
		roleDao.deleteRolesByPrimaryKey(id);
	}

	@Override
	public void updateRole(Map<String, Object> paramMap) {
		roleDao.updateRole(paramMap);
	}

}
