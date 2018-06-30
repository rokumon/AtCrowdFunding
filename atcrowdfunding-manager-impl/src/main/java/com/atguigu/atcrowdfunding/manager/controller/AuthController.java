package com.atguigu.atcrowdfunding.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.controller.BaseController;

@Controller
public class AuthController extends BaseController {
	
	@RequestMapping(value="auth_cert/index.htm")
	public String cert_index() {
		return "/auth_cert/index";
	}
	
	@RequestMapping(value="auth_adv/index.htm")
	public String adv_index() {
		return "/auth_adv/index";
	}
	
	@RequestMapping(value="auth_project/index.htm")
	public String project_index() {
		return "/auth_project/index";
	}
}
