package com.atguigu.atcrowdfunding.manager.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.Role;

public interface RoleDao {
	
	Role selectByPrimaryKey(Integer id);
	
	Role selectByName(Map<String, Object> paramMap);
	
	int insert(Map<String, Object> paramMap);

    List<Role> selectAll();

    int updateRole(Map<String, Object> paramMap);

	List<Role> queryRoleList(Map<String, Object> paramMap);

	Integer countRole(Map<String, Object> paramMap);

	int deleteRolesByPrimaryKey(Integer[] id);
}