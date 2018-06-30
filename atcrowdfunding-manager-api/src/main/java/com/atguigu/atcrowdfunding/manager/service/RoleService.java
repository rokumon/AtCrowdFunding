package com.atguigu.atcrowdfunding.manager.service;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.util.Page;

public interface RoleService {
	
	public Role queryRoleByName(Map<String,Object> paramMap);
	
	public void addRole(Map<String,Object> paramMap);

	public Page<Role> queryRoleByPage(Map<String, Object> paramMap);

	public Role queryRoleById(Integer id);

	public void deleteRole(Integer[] id);

	public void updateRole(Map<String, Object> paramMap);
	
	public List<Role> queryAll();
	
	public List<Role> queryAllByPrimaryKeys(Integer[] id);
	
}
