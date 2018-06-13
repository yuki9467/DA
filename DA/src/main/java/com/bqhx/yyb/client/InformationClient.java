package com.bqhx.yyb.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bqhx.yyb.vo.ConditionVO;
import com.bqhx.yyb.vo.InformationHistoryVO;
import com.bqhx.yyb.vo.InformationVO;
import com.bqhx.yyb.vo.MessageVO;

@FeignClient(value = "da-client")
public interface InformationClient {

	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.POST)
	MessageVO deleteByPrimaryKey(@RequestBody ConditionVO condition);
	
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	MessageVO insertSelective(@RequestBody ConditionVO condition);
	
	@RequestMapping(value = "/selectByCondition", method = RequestMethod.POST)
	List<InformationVO> selectByCondition(@RequestBody ConditionVO conditionVO);
	
	@RequestMapping(value = "/selectByContract", method = RequestMethod.POST)
	InformationVO selectByContract(@RequestBody ConditionVO conditionVO);
	
	@RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
	MessageVO updateByPrimaryKeySelective(@RequestBody ConditionVO conditionVO);
	
	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	MessageVO approve(@RequestBody ConditionVO condition);
	
	@RequestMapping(value = "/selectInfoHistoryByCondition", method = RequestMethod.POST)
	List<InformationHistoryVO> selectInfoHistoryByCondition(@RequestBody ConditionVO condition);
}
