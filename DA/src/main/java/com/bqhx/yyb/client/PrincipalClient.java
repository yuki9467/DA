package com.bqhx.yyb.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bqhx.yyb.vo.ConditionVO;
import com.bqhx.yyb.vo.PrincipalVO;

@FeignClient(value = "da-client")
public interface PrincipalClient {

	@RequestMapping(value = "/selectPrincipalByCondition", method = RequestMethod.POST)
	List<PrincipalVO> selectPrincipalByCondition(@RequestBody ConditionVO conditionVO);
	
}
