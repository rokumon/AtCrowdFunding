package com.atguigu.atcrowdfunding.portal.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.exception.MemberRegistException;
import com.atguigu.atcrowdfunding.portal.dao.MemberDao;
import com.atguigu.atcrowdfunding.portal.service.MemberService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public void registMember(Map<String, Object> paramMap) {

		// 加密
		String userpswd = MD5Util.digest((String) paramMap.get("userpswd"));

		// 调用DAO查询
		Member member = memberDao.queryMemberByLogin(paramMap);
		
		// 用户名已存在
		if (member != null) {
			throw new MemberRegistException(Const.REGIST_REGISTACCT_ERROR);
		}

		paramMap.put("userpswd", userpswd);

		Integer changedRow = memberDao.insert(paramMap);
		
		System.out.println(paramMap);

		if (changedRow != 1) {
			throw new MemberRegistException(Const.REGIST_REGISTINSERT_ERROR);
		}

	}

	@Override
	public Member queryMemberByLogin(Map<String, Object> paramMap) {
		
		// 加密
		String userpswd = MD5Util.digest((String) paramMap.get("userpswd"));

		// 调用DAO查询
		Member member = memberDao.queryMemberByLogin(paramMap);

		// 用户名不存在
		if (member == null) {
			throw new MemberRegistException(Const.LOGIN_LOGINACCT_ERROR);
		}
		
		// 密码错误
		if (!userpswd.equals(member.getUserpswd())) {
			throw new MemberRegistException(Const.LOGIN_USERPSWD_ERROR);
		}
		
		return member;
	}

}
