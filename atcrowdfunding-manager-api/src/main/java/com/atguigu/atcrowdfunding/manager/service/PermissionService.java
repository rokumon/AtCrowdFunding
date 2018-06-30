package com.atguigu.atcrowdfunding.manager.service;

import java.util.Map;

import com.atguigu.atcrowdfunding.bean.Permission;

public interface PermissionService {

	Permission queryPermissionTree();

	void addPermission(Map<String, Object> paramMap);

	void removePermission(Integer id);

	void updatePermission(Map<String, Object> paramMap);

	Permission queryPermission(Integer id);

}
