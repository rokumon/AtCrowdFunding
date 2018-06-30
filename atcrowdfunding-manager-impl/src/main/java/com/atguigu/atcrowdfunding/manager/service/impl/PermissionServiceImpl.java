package com.atguigu.atcrowdfunding.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.manager.dao.PermissionDao;
import com.atguigu.atcrowdfunding.manager.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionDao permissionDao;
	
	@Override
	public Permission queryPermissionTree() {
		
		Permission root = new Permission();
		
		List<Permission> permissions = permissionDao.selectAll();
		
		Map<Integer, Permission> result = new HashMap<>();
		
		if(permissions != null) {
			
			for (Permission permission : permissions) {
				result.put(permission.getId(), permission);
			}
			
			for (Permission permission : permissions) {
				//父节点
				if(permission.getPid() == null) {
					root = permission;
				} else {
					(result.get(permission.getPid())).getChildren().add(permission);
				}
			}
			
		}
		
		return root;
	}

	@Override
	public void addPermission(Map<String, Object> paramMap) {

		permissionDao.insert(paramMap);
	}

	@Override
	public void removePermission(Integer id) {

		permissionDao.deleteByPrimaryKey(id);
	}

	@Override
	public void updatePermission(Map<String, Object> paramMap) {
		permissionDao.updateByPrimaryKey(paramMap);
		
	}

	@Override
	public Permission queryPermission(Integer id) {
		return permissionDao.selectByPrimaryKey(id);
	}

}
