package com.atguigu.atcrowdfunding.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.atcrowdfunding.controller.BaseController;

@Controller
@RequestMapping(value="/certtype")
public class CertTypeController extends BaseController {
	
	@RequestMapping(value="/index.htm")
	public String index() {
		return "/certtype/index";
	}
	
}
