package com.atguigu.atcrowdfunding.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.controller.BaseController;
import com.atguigu.atcrowdfunding.manager.service.RoleService;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.Page;

@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController{

	@Autowired
	RoleService roleService;
	
	@RequestMapping("/index.htm")
	public String index() {
		return "role/index";
	}
	
	@ResponseBody
	@RequestMapping("/queryRoleByPage")
	public Object queryRoleByPage(@RequestParam(value="pageno",required=false,defaultValue="1")Integer pageno, 
								  @RequestParam(value="pagesize",required=false,defaultValue="10")Integer pagesize,
								  @RequestParam(value="queryText",required=false)String queryText) {
		
		start();
		
		try {
			Map<String, Object> paramMap = new HashMap<>();
			
			paramMap.put("pageno", pageno);
			paramMap.put("pagesize", pagesize);
			paramMap.put("queryText", queryText);
			
			System.out.println(paramMap);
			
			Page<Role> page = roleService.queryRoleByPage(paramMap);
					
			data(page);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(Const.LOAD_DATA_ERROR);
		}
		return end();
	}
	
	@RequestMapping("/toAdd.htm")
	public String add() {
		return "role/add";
	}
	
	@ResponseBody
	@RequestMapping("/doAdd.do")
	public Object addRole(String name) {
		
		start();
		
		try {
			
			Map<String, Object> paramMap = new HashMap<>();

			paramMap.put("name", name);

			roleService.addRole(paramMap);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(e.getMessage());
		}
		return end();
	}
	
	@RequestMapping("/edit.do")
	public String edit(Integer id, HttpServletRequest request) {
		
		Role role = roleService.queryRoleById(id);
		
		if(role == null) {
			return "redirect:/role/index.htm";
		}
		
		request.setAttribute("role", role);
		
		return "role/edit";
	}
	
	@ResponseBody
	@RequestMapping("/delete.do")
	public Object delete(Integer[] id) {
		
		start();
		
		try {
			roleService.deleteRole(id);
			success(true);
		} catch (Exception e) {
			success(false);
			message(Const.DELETE_DATA_ERROR);
			e.printStackTrace();
		}
		return end();
	}
	
	@ResponseBody
	@RequestMapping("/doUpdate.do")
	public Object doUpdate(Integer id, String name) {
		
		start();
		
		try {
			
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("id", id);
			paramMap.put("name", name);
			
			roleService.updateRole(paramMap);
			
			success(true);
		} catch (Exception e) {
			success(false);
			message(Const.UPDATE_DATA_ERROR);
			e.printStackTrace();
		}
		
		return end();
	}
	
}