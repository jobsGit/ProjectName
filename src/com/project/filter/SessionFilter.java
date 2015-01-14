package com.project.filter;

/**
 * @author :wangjinbo
 * Date:   2015-1-14
 * Description: SESSION ����
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

	//�����˵����󼯺�
	private String noFilterReqStr [];
	//��¼ҳ������
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
		String reqPath = request.getServletPath();  //��ǰ�����·��
		String url=String.valueOf(request.getRequestURL());   //��ǰ�����ȫ·��
        String uri = request.getRequestURI();    //��Ŀ����+��ǰ����·��
        String contextPath =request.getContextPath();   //��Ŀ����
        
        if(!isNoFilter_path(noFilterReqStr,reqPath)){
        	url = url.replace(uri,"");
			//SESSIONΪ��
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
	 * ·���Ƿ񲻹���
	 * return boolean
	 * true ������      false ����
	 * */
	private boolean isNoFilter_path(String ignorePath[],String reqPath){
		boolean flag = false;
		if(null!=ignorePath && ignorePath.length>0){
			for(int i=0;i<ignorePath.length;i++){
				//�����ǰ����·�����������˵�·��
				if(reqPath.indexOf(ignorePath[i])!=-1){
					flag = true;
					break;
				}
			}
		}
		return flag;
	} 
	
}
