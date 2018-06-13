package com.bqhx.yyb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bqhx.yyb.config.TargetDataSource;
import com.bqhx.yyb.dao.OrganizationMapper;
import com.bqhx.yyb.service.OrganizationService;
import com.bqhx.yyb.vo.DqVO;
import com.bqhx.yyb.vo.FgsVO;
import com.bqhx.yyb.vo.OrganizationCodeVO;
import com.bqhx.yyb.vo.OrganizationConditionVO;
import com.bqhx.yyb.vo.OrganizationResultVO;
import com.bqhx.yyb.vo.OrganizationVO;
import com.bqhx.yyb.vo.TdVO;
import com.bqhx.yyb.vo.YybVO;

@Service("OrganizationServiceImpl")
public class OrganizationServiceImpl implements OrganizationService {
	@Autowired
	private OrganizationMapper organizationMapper;
	
	@TargetDataSource(name="ds1")
	@Override
	public OrganizationCodeVO selectOrganizationCodeByOid(OrganizationConditionVO organizationConditionVO) {
		OrganizationCodeVO oc = organizationMapper.selectOrganizationCodeByOid(organizationConditionVO);
		return oc;
	}

	@Override
	public int updateOrganizationCode(OrganizationConditionVO organizationConditionVO) {
		organizationMapper.updateOrganizationCode(organizationConditionVO); 
		return 1;
	}

	@Override
	public int insertOrganizationCode(OrganizationConditionVO organizationConditionVO) {
		organizationMapper.insertOrganizationCode(organizationConditionVO);
		return 1;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<OrganizationVO> selectOrganizationByCondition(OrganizationConditionVO organizationConditionVO) {
		List<OrganizationVO> list = organizationMapper.selectOrganizationByCondition(organizationConditionVO);
		return list;
	}

	@Override
	public int insertOrganization(OrganizationConditionVO organizationConditionVO) {
		organizationMapper.insertOrganization(organizationConditionVO);
		return 1;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<OrganizationVO> selectOrByCondition(OrganizationConditionVO organizationConditionVO) {
		List<OrganizationVO> orList = organizationMapper.selectOrByCondition(organizationConditionVO);
		return orList;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<OrganizationCodeVO> fuzzySelectOrganizationCode(OrganizationConditionVO organizationConditionVO) {
		List<OrganizationCodeVO> oclist = organizationMapper.fuzzySelectOrganizationCode(organizationConditionVO);
		return oclist;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<OrganizationCodeVO> selectOrganizationCodeByCondition(OrganizationCodeVO orcode) {
		List<OrganizationCodeVO> oc = organizationMapper.selectOrganizationCodeByCondition(orcode);
		return oc;
	}

	@TargetDataSource(name="ds1")
	@Override
	public OrganizationResultVO selectSybByCondition(OrganizationConditionVO organizationConditionVO) {
		OrganizationResultVO syb = organizationMapper.selectSybByCondition(organizationConditionVO);
		return syb;
	}

	@TargetDataSource(name="ds1")
	@Override
	public DqVO selectDqByCondition(OrganizationConditionVO organizationConditionVO) {
		DqVO dq = organizationMapper.selectDqByCondition(organizationConditionVO);
		return dq;
	}

	@TargetDataSource(name="ds1")
	@Override
	public FgsVO selectFgsByCondition(OrganizationConditionVO organizationConditionVO) {
		FgsVO fgs = organizationMapper.selectFgsByCondition(organizationConditionVO);
		return fgs;
	}

	@TargetDataSource(name="ds1")
	@Override
	public YybVO selectYybByCondition(OrganizationConditionVO organizationConditionVO) {
		YybVO yyb = organizationMapper.selectYybByCondition(organizationConditionVO);
		return yyb;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<OrganizationResultVO> selectAllsybOrganization(OrganizationConditionVO organizationConditionVO) {
		List<OrganizationResultVO> sybList = organizationMapper.selectAllsybOrganization(organizationConditionVO);
		return sybList;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<DqVO> selectAlldqOrganization(OrganizationConditionVO organizationConditionVO) {
		List<DqVO> dqList = organizationMapper.selectAlldqOrganization(organizationConditionVO);
		return dqList;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<FgsVO> selectAllfgsOrganization(OrganizationConditionVO organizationConditionVO) {
		List<FgsVO> fgsList = organizationMapper.selectAllfgsOrganization(organizationConditionVO);
		return fgsList;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<YybVO> selectAllyybOrganization(OrganizationConditionVO organizationConditionVO) {
		List<YybVO> yybList = organizationMapper.selectAllyybOrganization(organizationConditionVO);
		return yybList;
	}

	@TargetDataSource(name="ds1")
	@Override
	public TdVO selectTdByCondition(OrganizationConditionVO organizationConditionVO) {
		TdVO td = organizationMapper.selectTdByCondition(organizationConditionVO);
		return td;
	}

	@TargetDataSource(name="ds1")
	@Override
	public List<TdVO> selectAlltdOrganization(OrganizationConditionVO organizationConditionVO) {
		List<TdVO> tdList = organizationMapper.selectAlltdOrganization(organizationConditionVO);
		return tdList;
	}

}
