package com.atguigu.atcrowdfunding.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.controller.BaseController;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.Page;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/index.htm")
	public String index() {
		return "user/index";
	}
	
	@ResponseBody
	@RequestMapping("/queryUserByPage")
	public Object queryUserByPage(@RequestParam(value="pageno",required=false,defaultValue="1")Integer pageno, 
								  @RequestParam(value="pagesize",required=false,defaultValue="10")Integer pagesize) {
		
		start();
		
		try {
			Map<String, Object> paramMap = new HashMap<>();
			
			paramMap.put("pageno", pageno);
			paramMap.put("pagesize", pagesize);
			
			Page<User> page = userService.queryUserByPage(paramMap);
					
			data(page);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(Const.LOAD_DATA_ERROR);
		}
		return end();
	}
	
	@RequestMapping("/add.htm")
	public String add() {
		return "user/add";
	}
	
	@ResponseBody
	@RequestMapping("/addUser.do")
	public Object addUser(String loginacct, String userpswd, String username, String email, HttpSession session) {
		
		if(session == null || session.getAttribute(Const.LOGIN_USER) == null) {
			return "redirect:/login.htm";
		}
		
		start();
		
		try {
			
			Map<String, Object> paramMap = new HashMap<>();
			
			paramMap.put("loginacct", loginacct);
			paramMap.put("userpswd", userpswd);
			paramMap.put("username", username);
			paramMap.put("email", email);
			
			userService.addUser(paramMap);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
		}
		return end();
	}
	
	@RequestMapping("/edit.do")
	public String edit(Integer id, HttpSession session, HttpServletRequest request) {
		
		if(session == null || session.getAttribute(Const.LOGIN_USER) == null) {
			return "redirect:/login.htm";
		}
		
		User user = userService.queryUserById(id);
		
		if(user == null) {
			return "redirect:/user/index.htm";
		}
		
		request.setAttribute("user", user);
		
		return "user/edit";
	}
	
//	@RequestMapping("/update.do")
//	public String aoedit(Integer id, HttpSession session) {
//		
//		if(session == null || session.getAttribute(Const.LOGIN_USER) == null) {
//			return "redirect:/login.htm";
//		}
//		
//		
//	}
	
}
