package com.bqhx.yyb.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bqhx.yyb.client.UserClient;
import com.bqhx.yyb.vo.MessageVO;
import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.UserHistoryVO;
import com.bqhx.yyb.vo.UserVO;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserClient userClient;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	UserVO login(UserConditionVO condition) {
		return userClient.login(condition);
	}
	
	@RequestMapping(value = "/loginUser",method = RequestMethod.POST)
	UserVO loginUser(UserConditionVO condition){
		return userClient.loginUser(condition);
	}
	
	@RequestMapping(value = "/insertUserSelective", method = RequestMethod.POST)
	MessageVO insertUserSelective(UserConditionVO condition){
		return userClient.insertUserSelective(condition);
	}
	
	@RequestMapping(value = "/deleteUserByPrimaryKey", method = RequestMethod.POST)
	MessageVO deleteUserByPrimaryKey(UserConditionVO condition){
		return userClient.deleteUserByPrimaryKey(condition);
	}
	
	/**
	 * 更新
	 * @param condition
	 * @return
	 */
	@RequestMapping(value = "/updateUserByPrimaryKeySelective", method = RequestMethod.POST)
	MessageVO updateUserByPrimaryKeySelective(UserConditionVO condition) {
		return userClient.updateUserByPrimaryKeySelective(condition);
	}
	
	@RequestMapping(value = "/selectUserByCondition", method = RequestMethod.POST)
	List<UserVO> selectUserByCondition(UserConditionVO condition){
		return userClient.selectUserByCondition(condition);
	}
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	@RequestMapping(value = "/selectUserHistoryByCondition", method = RequestMethod.POST)
	List<UserHistoryVO> selectUserHistoryByCondition(UserConditionVO condition){
		return userClient.selectUserHistoryByCondition(condition);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/now")
	String getTime() {
		return "Current time: " + (new Date()).toLocaleString();
	}
}
