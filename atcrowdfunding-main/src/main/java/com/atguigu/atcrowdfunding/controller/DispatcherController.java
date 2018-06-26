package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.Member;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.exception.MemberRegistException;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.portal.service.MemberService;
import com.atguigu.atcrowdfunding.util.Const;

@Controller
public class DispatcherController extends BaseController {
	
	@Autowired	
	private UserService userService;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@ResponseBody
	@RequestMapping("/doLogin")
	public Object doLogin(String loginacct, String userpswd, String usertype, HttpSession session) {
		start();
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("loginacct", loginacct);
			paramMap.put("userpswd", userpswd);
			paramMap.put("usertype", usertype);
			
			boolean action = false;
			
			if("user".equals(usertype)) {
				User user = userService.queryUserByLogin(paramMap);
				session.setAttribute(Const.LOGIN_USER, user);
				action = !action;
			}
			
			if("member".equals(usertype)) {
				Member member = memberService.queryMemberByLogin(paramMap);
				session.setAttribute(Const.LOGIN_USER, member);
				action = !action;
			}
			
			if(action) {
				success(true);
			} else {
				success(false);
			}
			
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
		}
		return end();
	}
	
	@RequestMapping("/main.htm")
	public String main(HttpSession session) {
		Object user = session.getAttribute(Const.LOGIN_USER);
		if(user != null) {
			return "main";
 		} else {
 			return "redirect:/login.htm";
 		}
	}
	
	@RequestMapping("/member.htm")
	public String member(HttpSession session) {
		Object user = session.getAttribute(Const.LOGIN_USER);
		if(user != null) {
			return "member";
 		} else {
 			return "redirect:/login.htm";
 		}
	}
	
	@RequestMapping("/reg")
	public String reg() {
		return "reg";
	}
	
	@ResponseBody
	@RequestMapping("/doReg.do")
	public Object doReg(String loginacct, String userpswd, String email, String usertype, HttpSession session) {
		start();
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			
			paramMap.put("loginacct", loginacct);
			paramMap.put("username", loginacct);
			paramMap.put("userpswd", userpswd);
			paramMap.put("authstatus", 0);
			paramMap.put("email", email);
			
			if("personal".equals(usertype)) {
				paramMap.put("usertype", 0);
			} else if ("company".equals(usertype)) {
				paramMap.put("usertype", 1);
			}
			
			System.out.println(paramMap);
			
			memberService.registMember(paramMap);
			
			paramMap.put("userpswd", userpswd);
			paramMap.put("usertype", "member");
			
			System.out.println(paramMap);
			
			Member member = memberService.queryMemberByLogin(paramMap);

			if (member == null) {
				throw new MemberRegistException(Const.REGIST_REGISTINSERT_ERROR);
			}
			session.setAttribute(Const.LOGIN_USER, member);
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
		}
		return end();
	}
	
//	@ResponseBody
//	@RequestMapping("/doReg.do")
//	public Object doReg(String loginacct, String userpswd, String email, String usertype, HttpSession session) {
//		start();
//		try {
//			Map<String, Object> paramMap = new HashMap<String, Object>();
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			paramMap.put("loginacct", loginacct);
//			paramMap.put("username", loginacct);
//			paramMap.put("userpswd", userpswd);
//			paramMap.put("email", email);
//			paramMap.put("usertype", usertype);
//			paramMap.put("createtime", simpleDateFormat.format(new Date()));
//			userService.registUser(paramMap);
//			paramMap.put("userpswd", userpswd);
//			User user = userService.queryUserByLogin(paramMap);
//			if (user == null) {
//				throw new UserRegistException(Const.REGIST_REGISTINSERT_ERROR);
//			}
//			session.setAttribute(Const.LOGIN_USER, user);
//			success(true);
//		} catch (Exception e) {
//			success(false);
//			message(e.getMessage());
//		}
//		return end();
//	}
//	@RequestMapping("/logout")
//	public String logout() {
//		return "logout";
//	}
	
	@RequestMapping("/doLogout.do")
	public String doLogout(HttpSession session) {
		
		if(session != null) {
			session.removeAttribute(Const.LOGIN_USER);
		} 
		
		session.invalidate();
		
		return "redirect:/index.jsp";
	}
	
//	@RequestMapping("/doLogin")
//	public String doLogin(String loginacct, String userpswd, String usertype, HttpSession session) {
//		Map<String,Object> paramMap = new HashMap<String,Object>();
//		paramMap.put("loginacct", loginacct);
//		paramMap.put("userpswd", userpswd);
//		paramMap.put("usertype", usertype);
//		//System.out.println("接受了请求，参数是" + loginacct + " " + userpswd + " " + usertype);
//		User user = userService.queryUserByLogin(paramMap);
//		session.setAttribute(Const.LOGIN_USER, user);
//		return "redirect:/main.htm";
//	}
}

