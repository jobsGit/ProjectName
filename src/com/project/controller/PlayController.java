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
 * @author :wangjinbo Date: 2015-1-13 Description: ����
 */

@RequestMapping("play")
@Controller
public class PlayController {

	@Autowired
	private PlayService playService;

	/**
	 * TO:��¼ҳ��
	 * */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "welcome";
	}

	/**
	 * TO:����ҳ��
	 * */
	@RequestMapping("toEdit")
	public String toEdit() {
		HashMap<String, Object> params = null;
		try {
			params = ScopeTooles.requestParameterToMap();
			List<Test> testList = playService.queryAll(params);   //����ID��ѯ��Ӧ������
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
	 * TO:���ҳ��
	 * */
	@RequestMapping("toAdd")
	public String toAdd() {
		return "play/add";
	}

	
	/**
	 * �û���¼
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
				params.put("message", "����ɹ�!");
			} else {
				params.put("success", false);
				params.put("message", "�û������������!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("success", false);
			params.put("message", "����ʧ��!");
		}
		return params;
	}

	/**
	 * �û��ǳ�
	 * */
	@RequestMapping("exitSys")
	public String exitSys() {
		ScopeTooles.removeSessionAttr(Constants.USER_SESSION_KEY);
		return "welcome";
	}

	
	/**
	 * չʾ����
	 * */
	@RequestMapping("show")
	public String testFilter() {
		HashMap<String, Object> params = new HashMap<String, Object>();
		try {
			params.put("id", ""); // idΪ�� ��ѯȫ����Ϣ
			List<Test> testList = playService.queryAll(params);
			ScopeTooles.getRequest().setAttribute("testList", testList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "play/show";
	}

	
	/**
	 * ɾ���û���Ϣ
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
				params.put("message", "ɾ���ɹ�!");
			} else {
				params.put("success", false);
				params.put("message", "ɾ��ʧ��!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("success", false);
			params.put("message", "ɾ������!");
		}
		return params;
	}

	
	/**
	 * ����û�����
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
				params.put("message", "��ӳɹ�!");
			} else {
				params.put("success", false);
				params.put("message", "���ʧ��!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("success", false);
			params.put("message", "��ӳ���!");
		}
		return params;
	}

	
	/**
	 * �����û�����
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
				params.put("message", "���³ɹ�!");
			} else {
				params.put("success", false);
				params.put("message", "����ʧ��!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			params.put("success", false);
			params.put("message", "���³���!");
		}
		return params;
	}

}
