package com.bqhx.yyb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bqhx.yyb.client.OrganizationClient;
import com.bqhx.yyb.vo.DqVO;
import com.bqhx.yyb.vo.FgsVO;
import com.bqhx.yyb.vo.OrganizationConditionVO;
import com.bqhx.yyb.vo.OrganizationResultVO;
import com.bqhx.yyb.vo.OrganizationVO;
import com.bqhx.yyb.vo.TdVO;
import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.YybVO;

@RestController
@RequestMapping("/")
public class OrganizationController {

	@Autowired
	private OrganizationClient organizationClient;
	/**
	 * 根据条件查询organization关系
	 * 参数：当前用户'typeId':user.typeId,'sid':user.sid,'did':user.did,s'fid':user.fid,'yid':user.yid
	 */
	@RequestMapping(value = "/selectOrganizationByCondition", method = RequestMethod.POST)
	List<OrganizationResultVO> selectOrganizationByCondition(UserConditionVO userCondition){
		return organizationClient.selectOrganizationByCondition(userCondition);
	}
	
	/***
	 * 获取某事业部下所有大区
	 */
	@RequestMapping(value = "/getDqListByCondition", method = RequestMethod.POST)
	List<DqVO> getDqListByCondition(OrganizationConditionVO orConditionVO){
		return organizationClient.getDqListByCondition(orConditionVO);
	}
	
	/***
	 * 获取某大区下所有分公司
	 */
	@RequestMapping(value = "/getFgsListByCondition", method = RequestMethod.POST)
	List<FgsVO> getFgsListByCondition(OrganizationConditionVO orConditionVO){
		return organizationClient.getFgsListByCondition(orConditionVO);
	}
	
	/***
	 * 获取某分公司下所有营业部
	 */
	@RequestMapping(value = "/getYybListByCondition", method = RequestMethod.POST)
	List<YybVO> getYybListByCondition(OrganizationConditionVO orConditionVO){
		return organizationClient.getYybListByCondition(orConditionVO);
	}
	
	/***
	 * 获取某营业部下所有团队
	 */
	@RequestMapping(value = "/getTdListByCondition", method = RequestMethod.POST)
	List<TdVO> getTdListByCondition(OrganizationConditionVO orConditionVO){
		return organizationClient.getTdListByCondition(orConditionVO);
	}
	
	/***
	 * 查询某个事业部
	 */
	@RequestMapping(value = "/selectSybByCondition", method = RequestMethod.POST)
	OrganizationResultVO selectSybByCondition(OrganizationConditionVO orConditionVO){
		return organizationClient.selectSybByCondition(orConditionVO);
	}
	
	/***
	 * 查询某个大区及所在事业部
	 */
	@RequestMapping(value = "/selectDqByCondition", method = RequestMethod.POST)
	DqVO selectDqByCondition(OrganizationConditionVO organizationConditionVO){
		return organizationClient.selectDqByCondition(organizationConditionVO);
	}
	
	/***
	 * 查询某个分公司及所在大区
	 */
	@RequestMapping(value = "/selectFgsByCondition", method = RequestMethod.POST)
	FgsVO selectFgsByCondition(OrganizationConditionVO organizationConditionVO){
		return organizationClient.selectFgsByCondition(organizationConditionVO);
	}
	
	/***
	 * 查询某个营业部及所在分公司
	 */
	@RequestMapping(value = "/selectYybByCondition", method = RequestMethod.POST)
	YybVO selectYybByCondition(OrganizationConditionVO organizationConditionVO){
		return organizationClient.selectYybByCondition(organizationConditionVO);
	}
	
	/***
	 * 查询某个团队及所在营业部
	 */
	@RequestMapping(value = "/selectTdByCondition", method = RequestMethod.POST)
	TdVO selectTdByCondition(OrganizationConditionVO organizationConditionVO){
		return organizationClient.selectTdByCondition(organizationConditionVO);
	}
	
	/***
	 * 查询所有机构
	 */
	@RequestMapping(value = "/selectAllOrganization", method = RequestMethod.POST)
	List<OrganizationResultVO> selectAllOrganization(OrganizationConditionVO organizationConditionVO){
		return organizationClient.selectAllOrganization(organizationConditionVO);
	}
	
	/***
	 * 插入机构
	 */
	@RequestMapping(value = "/insertOrganization", method = RequestMethod.POST)
	public int insertOrganization(OrganizationConditionVO organizationConditionVO){
		return organizationClient.insertOrganization(organizationConditionVO);
	}
	
	@RequestMapping(value = "/selectOrg", method = RequestMethod.POST)
	public List<OrganizationVO> selectOrg(OrganizationConditionVO orcode){
		return organizationClient.selectOrg(orcode);
	}
}
