package com.bqhx.yyb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bqhx.yyb.client.CertificateClient;
import com.bqhx.yyb.vo.CertificateVO;
import com.bqhx.yyb.vo.ConditionVO;
@RestController
@RequestMapping("/")
public class CertificateController {

	@Autowired
	private CertificateClient certificateClient;
	
	@RequestMapping(value = "/selectCertificateByCondition", method = RequestMethod.POST)
	List<CertificateVO> selectCertificateByCondition(ConditionVO conditionVO){
		return certificateClient.selectCertificateByCondition(conditionVO);
	}
	
	/**
	 * 银行短信（回息）
	 */
	@RequestMapping(value = "/selectSMSInterestByCondition", method = RequestMethod.POST)
	List<CertificateVO> selectSMSInterestByCondition(ConditionVO conditionVO){
		return certificateClient.selectSMSInterestByCondition(conditionVO);
	}
	
	/**
	 * 银行短信（回本）
	 */
	@RequestMapping(value = "/selectSMSCapitalByCondition", method = RequestMethod.POST)
	List<CertificateVO> selectSMSCapitalByCondition(ConditionVO conditionVO){
		return certificateClient.selectSMSCapitalByCondition(conditionVO);
	}
}
