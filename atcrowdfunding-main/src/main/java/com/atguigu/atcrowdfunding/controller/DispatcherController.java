package com.atguigu.atcrowdfunding.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.spi.ThrowableRenderer;
import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.exception.UserRegistException;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;

@Controller
public class DispatcherController {
	
	@Autowired	
	private UserService userService;
	
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
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			
			paramMap.put("loginacct", loginacct);
			paramMap.put("userpswd", userpswd);
			paramMap.put("usertype", usertype);
			
			User user = userService.queryUserByLogin(paramMap);
			
			session.setAttribute(Const.LOGIN_USER, user);
			
			result.put("success", true);
			
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		
		return result;
	}
	
	@RequestMapping("/main.htm")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/reg")
	public String reg() {
		return "reg";
	}
	
	@ResponseBody
	@RequestMapping("/doReg.do")
	public Object doReg(String loginacct, String userpswd, String email, String usertype, HttpSession session) {
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					
			paramMap.put("loginacct", loginacct);
			paramMap.put("username", loginacct);
			paramMap.put("userpswd", userpswd);
			paramMap.put("email", email);
			paramMap.put("usertype", usertype);
			paramMap.put("createtime", simpleDateFormat.format(new Date()));
			
			userService.registUser(paramMap);
			
			paramMap.put("userpswd", userpswd);
			
			User user = userService.queryUserByLogin(paramMap);
			
			if(user == null) {
				throw new UserRegistException(Const.REGIST_REGISTINSERT_ERROR);
			}
			
			session.setAttribute(Const.LOGIN_USER, user);
			
			result.put("success", true);
		
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		
		return result;
	}
	
//	@RequestMapping("/logout")
//	public String logout() {
//		return "logout";
//	}
	
	@RequestMapping("/doLogout.do")
	public String doLogout(HttpSession session) {
		
		if(session != null) {
			session.removeAttribute("Const.LOGIN_USER");
		} 
		
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

