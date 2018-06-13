package com.bqhx.yyb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bqhx.yyb.dao.UserMapper;
import com.bqhx.yyb.service.UserService;
import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.UserVO;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserVO login(UserConditionVO condition) {
		UserVO vo = userMapper.selectUserByPrimaryKey(condition);
		if(vo == null) {
			vo = new UserVO();
			vo.setMessage("用户不存在");
		} else if(!condition.getPassword().equals(vo.getPassword())) {
			vo = new UserVO();
			vo.setMessage("密码错误");
		}
		return vo;
	}

}
