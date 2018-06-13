package com.bqhx.yyb.client;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bqhx.yyb.vo.MessageVO;
import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.UserHistoryVO;
import com.bqhx.yyb.vo.UserVO;

@FeignClient(value = "da-client")
public interface UserClient {
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	UserVO login(@RequestBody UserConditionVO condition);
	
	@RequestMapping(value = "/loginUser",method = RequestMethod.POST)
	UserVO loginUser(@RequestBody UserConditionVO condition);
	
	@RequestMapping(value = "/insertUserSelective", method = RequestMethod.POST)
	MessageVO insertUserSelective(@RequestBody UserConditionVO condition);
	
	@RequestMapping(value = "/deleteUserByPrimaryKey", method = RequestMethod.POST)
	MessageVO deleteUserByPrimaryKey(@RequestBody UserConditionVO condition);
	
	@RequestMapping(value = "/updateUserByPrimaryKeySelective", method = RequestMethod.POST)
	MessageVO updateUserByPrimaryKeySelective(@RequestBody UserConditionVO condition);
	
	@RequestMapping(value = "/selectUserByCondition", method = RequestMethod.POST)
	List<UserVO> selectUserByCondition(@RequestBody UserConditionVO condition);
	
	@RequestMapping(value = "/selectUserHistoryByCondition", method = RequestMethod.POST)
	List<UserHistoryVO> selectUserHistoryByCondition(@RequestBody UserConditionVO condition);
}
