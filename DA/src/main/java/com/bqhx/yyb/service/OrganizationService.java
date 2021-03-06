package com.bqhx.yyb.service;

import java.util.List;

import com.bqhx.yyb.vo.DqVO;
import com.bqhx.yyb.vo.FgsVO;
import com.bqhx.yyb.vo.OrganizationCodeVO;
import com.bqhx.yyb.vo.OrganizationConditionVO;
import com.bqhx.yyb.vo.OrganizationResultVO;
import com.bqhx.yyb.vo.OrganizationVO;
import com.bqhx.yyb.vo.TdVO;
import com.bqhx.yyb.vo.YybVO;

public interface OrganizationService {
	OrganizationCodeVO selectOrganizationCodeByOid(OrganizationConditionVO organizationConditionVO);
	/** 更新oc */
	int updateOrganizationCode(OrganizationConditionVO organizationConditionVO);
	/** 插入oc */
	int insertOrganizationCode(OrganizationConditionVO organizationConditionVO);
	/** controller */
	List<OrganizationVO> selectOrganizationByCondition(OrganizationConditionVO organizationConditionVO);
	/** file */
	List<OrganizationVO> selectOrByCondition(OrganizationConditionVO organizationConditionVO);
	
	int insertOrganization(OrganizationConditionVO organizationConditionVO);
	
	List<OrganizationCodeVO> fuzzySelectOrganizationCode(OrganizationConditionVO organizationConditionVO);
	
	List<OrganizationCodeVO> selectOrganizationCodeByCondition(OrganizationCodeVO orcode);
	/** 查询某个事业部 */
	OrganizationResultVO selectSybByCondition(OrganizationConditionVO organizationConditionVO);
	/** 查询某个大区及所在事业部 */
	DqVO selectDqByCondition(OrganizationConditionVO organizationConditionVO);
	/** 查询某个分公司及所在大区 */
	FgsVO selectFgsByCondition(OrganizationConditionVO organizationConditionVO);
	/** 查询某个营业部及所在分公司 */
	YybVO selectYybByCondition(OrganizationConditionVO organizationConditionVO);
	/** 查询某个团队及所在营业部 */
	TdVO selectTdByCondition(OrganizationConditionVO organizationConditionVO);
	/** 查询所有事业部 */
	List<OrganizationResultVO> selectAllsybOrganization(OrganizationConditionVO organizationConditionVO);
	/** 查询所有大区或者在某个事业部下的所有大区 */
	List<DqVO> selectAlldqOrganization(OrganizationConditionVO organizationConditionVO);
	/** 查询所有分公司或者在某个大区下的所有分公司 */
	List<FgsVO> selectAllfgsOrganization(OrganizationConditionVO organizationConditionVO);
	/** 查询所有营业部或者在某个分公司下的所有营业部  */
	List<YybVO> selectAllyybOrganization(OrganizationConditionVO organizationConditionVO);
	/** 查询所有团队或者在某个营业部下的所有团队 */
	List<TdVO> selectAlltdOrganization(OrganizationConditionVO organizationConditionVO);
}
