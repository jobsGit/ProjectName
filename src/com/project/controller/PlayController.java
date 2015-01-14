package com.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.pojo.Test;
import com.project.service.PlayService;
import com.project.util.Constants;
import com.project.util.ScopeTooles;

/**
 * @author :wangjinbo Date: 2015-1-13 Description: 测试
 */

@RequestMapping("play")
@Controller
public class PlayController {

	@Autowired
	private PlayService playService;

	/**
	 * TO:登录页面
	 * */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "welcome";
	}

	/**
	 * TO:更新页面
	 * */
	@RequestMapping("toEdit")
	public String toEdit() {
		HashMap<String, Object> params = null;
		try {
			params = ScopeTooles.requestParameterToMap();
			List<Test> testList = playService.queryAll(params);   //根据ID查询相应的数据
			if (null != testList && testList.size() > 0) {
				ScopeTooles.getRequest().setAttribute("testObj",
						testList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "play/edit";
	}

	/**
	 * TO:添加页面
	 * */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "play/add";
	}

	
	/**
	 * 用户登录
	 * */
	@RequestMapping("userLogin")
	@ResponseBody
	public HashMap<String, Object> userLogin() {
		HashMap<String, Object> params = null;
		try {
			params = ScopeTooles.requestParameterToMap();
			Test test = playService.userLogin(params);
			params.clear();
			if (null != test) {
				ScopeTooles.setSessionAttr(Constants.USER_SESSION_KEY, test);
				params.put("success", true);
				params.put("message", "登入成功!");
			} else {
				params.put("success", false);
				params.put("message", "用户名或密码错误!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("success", false);
			params.put("message", "登入失败!");
		}
		return params;
	}

	/**
	 * 用户登出
	 * */
	@RequestMapping("exitSys")
	public String exitSys() {
		ScopeTooles.removeSessionAttr(Constants.USER_SESSION_KEY);
		return "welcome";
	}

	
	/**
	 * 展示数据
	 * */
	@RequestMapping("show")
	public String testFilter() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		try {
			params.put("id", ""); // id为空 查询全部信息
			List<Test> testList = playService.queryAll(params);
			ScopeTooles.getRequest().setAttribute("testList", testList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "play/show";
	}

	
	/**
	 * 删除用户信息
	 * */
	@RequestMapping("delUser")
	@ResponseBody
	public HashMap<String, Object> delUser() {
		HashMap<String, Object> params = null;
		try {
			params = ScopeTooles.requestParameterToMap();
			boolean flag = playService.delUser(params);
			params.clear();
			if (flag) {
				params.put("success", true);
				params.put("message", "删除成功!");
			} else {
				params.put("success", false);
				params.put("message", "删除失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("success", false);
			params.put("message", "删除出错!");
		}
		return params;
	}

	
	/**
	 * 添加用户数据
	 * */
	@RequestMapping("addUser")
	@ResponseBody
	public HashMap<String, Object> addUser() {
		HashMap<String, Object> params = null;
		try {
			params = ScopeTooles.requestParameterToMap();
			Integer rowKey = playService.addUser(params);
			if (rowKey > 0) {
				params.put("success", true);
				params.put("message", "添加成功!");
			} else {
				params.put("success", false);
				params.put("message", "添加失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("success", false);
			params.put("message", "添加出错!");
		}
		return params;
	}

	
	/**
	 * 更新用户数据
	 * */
	@RequestMapping("editUser")
	@ResponseBody
	public HashMap<String, Object> editUser() {
		HashMap<String, Object> params = null;
		try {
			params = ScopeTooles.requestParameterToMap();
			boolean flag = playService.updUser(params);
			if (flag) {
				params.put("success", true);
				params.put("message", "更新成功!");
			} else {
				params.put("success", false);
				params.put("message", "更新失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("success", false);
			params.put("message", "更新出错!");
		}
		return params;
	}

}
