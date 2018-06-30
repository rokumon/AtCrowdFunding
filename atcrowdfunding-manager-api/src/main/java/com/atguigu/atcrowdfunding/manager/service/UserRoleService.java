package com.atguigu.atcrowdfunding.manager.service;

import java.util.List;
import java.util.Map;

public interface UserRoleService {
	
    List<Integer> queryRoleIdsByUserId(Integer userId);
    
    List<Integer> queryUserIdsByRoleId(Integer roleId);

	void addRecoreds(Map<String, Object> paramMap);

	void removeRecoreds(Map<String, Object> paramMap);
	
}
