package com.atguigu.atcrowdfunding.manager.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.Permission;

public interface PermissionDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Map<String, Object> paramMap);

    Permission selectByPrimaryKey(Integer id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Map<String, Object> paramMap);
}
