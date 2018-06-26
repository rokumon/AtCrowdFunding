package com.atguigu.atcrowdfunding.portal.service;

import java.util.Map;

import com.atguigu.atcrowdfunding.bean.Member;

public interface MemberService {
	
	Member queryMemberByLogin(Map<String, Object> paramMap);
	
	public void registMember(Map<String,Object> paramMap);
	
}
