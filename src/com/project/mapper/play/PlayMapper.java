package com.project.mapper.play;

import java.util.HashMap;
import java.util.List;

import com.project.pojo.Test;

/**
 * @author :wangjinbo
 * Date:   2015-1-13
 * Description: 测试
 */
public interface PlayMapper {
	
	/**
	 * 用户登录
	 * */
	public Test userLogin(HashMap<String,Object> params);
	
	/**
	 * 查询用户信息
	 * */
	public List<Test> queryAll(HashMap<String,Object> params);
	
	/**
	 * 添加用户信息
	 * */
	public Integer addUser(HashMap<String,Object> params);
	
	/**
	 * 更新用户信息
	 * */
	public Integer updUser(HashMap<String,Object> params);
	
	/**
	 * 删除用户信息
	 * */
	public Integer delUser(HashMap<String,Object> params);
	
}
