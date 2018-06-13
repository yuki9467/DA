package com.bqhx.yyb.api;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.UserVO;


public interface UserApi {
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	UserVO login(@RequestBody UserConditionVO condition);
}
