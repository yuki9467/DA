package com.bqhx.yyb.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bqhx.yyb.vo.DqVO;
import com.bqhx.yyb.vo.FgsVO;
import com.bqhx.yyb.vo.OrganizationConditionVO;
import com.bqhx.yyb.vo.OrganizationResultVO;
import com.bqhx.yyb.vo.OrganizationVO;
import com.bqhx.yyb.vo.TdVO;
import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.YybVO;

@FeignClient(value = "da-client")
public interface OrganizationClient {

	@RequestMapping(value = "/selectOrganizationByCondition", method = RequestMethod.POST)
	List<OrganizationResultVO> selectOrganizationByCondition(@RequestBody UserConditionVO userCondition);
	
	@RequestMapping(value = "/getDqListByCondition", method = RequestMethod.POST)
	List<DqVO> getDqListByCondition(@RequestBody OrganizationConditionVO orConditionVO);
	
	@RequestMapping(value = "/getFgsListByCondition", method = RequestMethod.POST)
	List<FgsVO> getFgsListByCondition(@RequestBody OrganizationConditionVO orConditionVO);
	
	@RequestMapping(value = "/getYybListByCondition", method = RequestMethod.POST)
	List<YybVO> getYybListByCondition(@RequestBody OrganizationConditionVO orConditionVO);
	
	@RequestMapping(value = "/getTdListByCondition", method = RequestMethod.POST)
	List<TdVO> getTdListByCondition(@RequestBody OrganizationConditionVO orConditionVO);
	
	@RequestMapping(value = "/selectSybByCondition", method = RequestMethod.POST)
	OrganizationResultVO selectSybByCondition(@RequestBody OrganizationConditionVO orConditionVO);
	
	@RequestMapping(value = "/selectDqByCondition", method = RequestMethod.POST)
	DqVO selectDqByCondition(@RequestBody OrganizationConditionVO organizationConditionVO);
	
	@RequestMapping(value = "/selectFgsByCondition", method = RequestMethod.POST)
	FgsVO selectFgsByCondition(@RequestBody OrganizationConditionVO organizationConditionVO);
	
	@RequestMapping(value = "/selectYybByCondition", method = RequestMethod.POST)
	YybVO selectYybByCondition(@RequestBody OrganizationConditionVO organizationConditionVO);
	
	@RequestMapping(value = "/selectTdByCondition", method = RequestMethod.POST)
	TdVO selectTdByCondition(@RequestBody OrganizationConditionVO organizationConditionVO);
	
	@RequestMapping(value = "/selectAllOrganization", method = RequestMethod.POST)
	List<OrganizationResultVO> selectAllOrganization(@RequestBody OrganizationConditionVO organizationConditionVO);
	
	@RequestMapping(value = "/insertOrganization", method = RequestMethod.POST)
	public int insertOrganization(@RequestBody OrganizationConditionVO organizationConditionVO);
	
	@RequestMapping(value = "/selectOrg", method = RequestMethod.GET)
	public List<OrganizationVO> selectOrg(@RequestBody OrganizationConditionVO orcode);
}
