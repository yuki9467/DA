package com.bqhx.yyb.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bqhx.yyb.vo.ConditionVO;
import com.bqhx.yyb.vo.MovableCheckVO;

@FeignClient(value = "da-client")
public interface MovableCheckClient {

	@RequestMapping(value = "/selectMovableCheckByCondition", method = RequestMethod.POST)
	List<MovableCheckVO> selectMovableCheckByCondition(@RequestBody ConditionVO conditionVO);
	
}
