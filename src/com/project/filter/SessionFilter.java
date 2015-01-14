package com.project.filter;

/**
 * @author :wangjinbo
 * Date:   2015-1-14
 * Description: SESSION 过虑
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.util.Constants;

public class SessionFilter implements Filter{

	//不过滤的请求集合
	private String noFilterReqStr [];
	//登录页面请求
	private String toLoginReq;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest  request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String reqPath = request.getServletPath();  //当前请求的路径
		String url=String.valueOf(request.getRequestURL());   //当前请求的全路径
        String uri = request.getRequestURI();    //项目名称+当前请求路径
        String contextPath =request.getContextPath();   //项目名称
        
        if(!isNoFilter_path(noFilterReqStr,reqPath)){
        	url = url.replace(uri,"");
			//SESSION为空
			if(null==request.getSession().getAttribute(Constants.USER_SESSION_KEY)){
				response.sendRedirect(url+contextPath+toLoginReq);
			}else{
				arg2.doFilter(arg0, arg1);
			}
        }else{
        	arg2.doFilter(arg0, arg1);
        }
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		String ignorePathStr = arg0.getInitParameter("noFilterReq");
		toLoginReq = arg0.getInitParameter("toLoginReq");
		if(null!=ignorePathStr){
			noFilterReqStr = ignorePathStr.split(";");
		}
	}

	
	/**
	 * 路径是否不过虑
	 * return boolean
	 * true 不过虑      false 过滤
	 * */
	private boolean isNoFilter_path(String ignorePath[],String reqPath){
		boolean flag = false;
		if(null!=ignorePath && ignorePath.length>0){
			for(int i=0;i<ignorePath.length;i++){
				//如果当前请求路径包含不过滤的路径
				if(reqPath.indexOf(ignorePath[i])!=-1){
					flag = true;
					break;
				}
			}
		}
		return flag;
	} 
	
}
