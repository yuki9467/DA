package com.bqhx.yyb.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bqhx.yyb.vo.CertificateVO;
import com.bqhx.yyb.vo.ConditionVO;

@FeignClient(value = "da-client")
public interface CertificateClient {
	
	@RequestMapping(value = "/selectCertificateByCondition", method = RequestMethod.POST)
	List<CertificateVO> selectCertificateByCondition(@RequestBody ConditionVO conditionVO);
	
	@RequestMapping(value = "/selectSMSInterestByCondition", method = RequestMethod.POST)
	List<CertificateVO> selectSMSInterestByCondition(@RequestBody ConditionVO conditionVO);
	
	@RequestMapping(value = "/selectSMSCapitalByCondition", method = RequestMethod.POST)
	List<CertificateVO> selectSMSCapitalByCondition(@RequestBody ConditionVO conditionVO);
}
