package com.atguigu.atcrowdfunding.portal.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atcrowdfunding.bean.Member;

public interface MemberDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Map<String, Object> paramMap);

    Member selectByPrimaryKey(Integer id);

    List<Member> selectAll();

    int updateByPrimaryKey(Member record);

	Member queryMemberByLogin(Map<String, Object> paramMap);
}
