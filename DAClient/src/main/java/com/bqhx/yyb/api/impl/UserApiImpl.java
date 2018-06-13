package com.bqhx.yyb.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bqhx.yyb.api.UserApi;
import com.bqhx.yyb.service.UserService;
import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.UserVO;

@RestController
public class UserApiImpl implements UserApi {

	@Autowired
	@Qualifier("UserServiceImpl") 
	private UserService userService;
	
	@Override
	public UserVO login(@RequestBody UserConditionVO condition) {
		return userService.login(condition);
	}

}
