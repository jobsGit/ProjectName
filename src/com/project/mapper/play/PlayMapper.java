package com.project.mapper.play;

import java.util.HashMap;
import java.util.List;

import com.project.pojo.Test;

/**
 * @author :wangjinbo
 * Date:   2015-1-13
 * Description: ����
 */
public interface PlayMapper {
	
	/**
	 * �û���¼
	 * */
	public Test userLogin(HashMap<String,Object> params);
	
	/**
	 * ��ѯ�û���Ϣ
	 * */
	public List<Test> queryAll(HashMap<String,Object> params);
	
	/**
	 * ����û���Ϣ
	 * */
	public Integer addUser(HashMap<String,Object> params);
	
	/**
	 * �����û���Ϣ
	 * */
	public Integer updUser(HashMap<String,Object> params);
	
	/**
	 * ɾ���û���Ϣ
	 * */
	public Integer delUser(HashMap<String,Object> params);
	
}
