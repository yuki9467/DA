package com.bqhx.yyb.service;

import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.UserVO;

public interface UserService {
	UserVO login(UserConditionVO condition);
}
