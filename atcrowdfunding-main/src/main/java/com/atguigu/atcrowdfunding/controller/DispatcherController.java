package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.User;
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

