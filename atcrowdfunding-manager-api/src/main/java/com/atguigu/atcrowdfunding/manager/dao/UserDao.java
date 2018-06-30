package com.atguigu.atcrowdfunding.manager.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.User;

public interface UserDao {

    int insert(Map<String, Object> paramMap);
    
    User selectByLogin(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateUser(Map<String, Object> paramMap);

	User queryUserByLogin(Map<String, Object> paramMap);

	List<User> queryUserList(Map<String, Object> paramMap);

	Integer countUser();

	int deleteUsersByPrimaryKey(Integer[] id);
}
