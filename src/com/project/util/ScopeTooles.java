package com.project.util;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author :wangjinbo
 * Date:   2015-1-14
 * Description: scope������
 */

public class ScopeTooles {
	
	/**
	 * request Parameterת��Ϊmap
	 * @return
	 */
	public static HashMap<String, Object> requestParameterToMap(){
		HttpServletRequest request = getRequest();
		HashMap<String, Object> map = new HashMap<String, Object>();
		Enumeration<String> em = request.getParameterNames();
		while (null != em && em.hasMoreElements()) {
			String key = em.nextElement();
			Object value = request.getParameter(key);
			if (null != value) {
				map.put(key, value);
				if (!value.equals("")) {
					map.put(key, value);
				}
			}
		}
		return map;
	}
	
	
	/**
	 * request attributeת��Ϊmap
	 * @return
	 */
	public static HashMap<String, Object> requestAttributeToMap(){
		HttpServletRequest request = getRequest();
		HashMap<String, Object> map = new HashMap<String, Object>();
		Enumeration<String> em = request.getAttributeNames();
		while (null != em && em.hasMoreElements()) {
			String key = em.nextElement();
			Object value = request.getAttribute(key);
			if (null != value) {
				map.put(key, value);
				if (!value.equals("")) {
					map.put(key, value);
				}
			}
		}
		return map;
	}
	
	/**
	 * ����session��Ϣ
	 * @return
	 * */
	public static void setSessionAttr(String key,Object val){
		if(StringUtils.isNotBlank(key) && null!=val){
			HttpServletRequest request = getRequest();
			request.getSession().setAttribute(StringUtils.trim(key),val);
		}else{
			throw new NullPointerException("key or val is null !...");
		}
	}
	
	/**
	 * �Ƴ�session��Ϣ
	 * @return
	 * */
	public static void removeSessionAttr(String key){
		if(StringUtils.isNotBlank(key)){
			HttpServletRequest request = getRequest();
			request.getSession().removeAttribute(key);
		}else{
			throw new NullPointerException("key is null !...");
		}
	}
	
	
	
	/**
	 * ��ȡrequest����
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
		return request;
	}
	
}
