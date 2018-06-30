package com.atguigu.atcrowdfunding.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.controller.BaseController;

@Controller
@RequestMapping(value="/cert")
public class CertController extends BaseController {
	
	@RequestMapping(value="/index.htm")
	public String index() {
		return "/cert/index";
	}
	
}	
