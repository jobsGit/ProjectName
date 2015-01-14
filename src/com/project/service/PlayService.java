package com.project.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mapper.play.PlayMapper;
import com.project.pojo.Test;

/**
 * @author :wangjinbo
 * Date:   2015-1-13
 * Description: ����
 */

@Service
public class PlayService {
	
	@Autowired
	private PlayMapper playMapper;
	
	/**
	 * �û���¼
	 * */
	public Test userLogin(HashMap<String,Object> params){
		return playMapper.userLogin(params);
	}
	
	
	/**
	 * ��ѯ�û���Ϣ
	 * */
	public List<Test> queryAll(HashMap<String,Object> params){
		try{
			return  playMapper.queryAll(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ����û���Ϣ
	 * */
	public Integer addUser(HashMap<String,Object> params){
		try{
			return playMapper.addUser(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �����û���Ϣ
	 * */
	public boolean updUser(HashMap<String,Object> params){
		boolean flag = false;
		try{
			Integer row = playMapper.updUser(params);
			flag = row>0?true:false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * ɾ���û���Ϣ
	 * */
	public boolean delUser(HashMap<String,Object> params){
		boolean flag = false;
		try{
			Integer row = playMapper.delUser(params);
			flag = row>0?true:false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
}
