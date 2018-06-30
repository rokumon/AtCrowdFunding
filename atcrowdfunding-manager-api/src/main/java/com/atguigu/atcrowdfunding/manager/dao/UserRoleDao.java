package com.atguigu.atcrowdfunding.manager.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.UserRole;

public interface UserRoleDao {

    int deleteByPrimaryKey(Integer id);

    int insert(Map<String, Object> paramMap);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Map<String, Object> paramMap);

    List<UserRole> selectAll();
   
    List<UserRole> selectAllByUserId(Integer userId);
    
    List<UserRole> selectAllByRoleId(Integer roleId);

    List<Integer> selectRoleIdsByUserId(Integer userId);
    
    List<Integer> selectUserIdsByRoleId(Integer roleId);

	void insertRecoreds(Map<String, Object> paramMap);

	void deleteRecoreds(Map<String, Object> paramMap);
      
}
