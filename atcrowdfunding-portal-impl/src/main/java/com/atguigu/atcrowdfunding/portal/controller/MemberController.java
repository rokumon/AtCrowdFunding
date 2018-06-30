package com.atguigu.atcrowdfunding.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@RequestMapping(value="index")
	public String index() {
		return "member/index";
	}
	
	@RequestMapping(value="minecrowdfunding")
	public String minecrowdfunding() {
		return "member/minecrowdfunding";
	}
	
}
