package com.bqhx.yyb.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bqhx.yyb.constant.Constant;
import com.bqhx.yyb.dao.InformationVOMapper;
import com.bqhx.yyb.service.CertificateService;
import com.bqhx.yyb.service.InformationService;
import com.bqhx.yyb.service.MovableCheckService;
import com.bqhx.yyb.service.OrganizationService;
import com.bqhx.yyb.service.PrincipalService;
import com.bqhx.yyb.util.ConditionUtil;
import com.bqhx.yyb.util.ExcelUtil;
import com.bqhx.yyb.vo.CertificateVO;
import com.bqhx.yyb.vo.ConditionVO;
import com.bqhx.yyb.vo.DqVO;
import com.bqhx.yyb.vo.FgsVO;
import com.bqhx.yyb.vo.InformationVO;
import com.bqhx.yyb.vo.MovableCheckVO;
import com.bqhx.yyb.vo.OrganizationConditionVO;
import com.bqhx.yyb.vo.OrganizationResultVO;
import com.bqhx.yyb.vo.PrincipalVO;
import com.bqhx.yyb.vo.ResultTypeVO;
import com.bqhx.yyb.vo.UserVO;
import com.bqhx.yyb.vo.YybVO;

@RestController
@RequestMapping("/")
public class ExcelController {
	
	@Autowired
	private InformationVOMapper informationVOMapper;
	@Autowired
	@Qualifier("InformationServiceImpl") 
	private InformationService informationService;
	@Autowired
	@Qualifier("CertificateServiceImpl") 
	private CertificateService certificateService;
	@Autowired
	@Qualifier("PrincipalServiceImpl") 
	private PrincipalService principalService;
	@Autowired
	@Qualifier("OrganizationServiceImpl") 
	private OrganizationService organizationService;
	@Autowired
	@Qualifier("MovableCheckServiceImpl") 
	private MovableCheckService movableCheckService;
	
	/**
	 * 下载总表
	 *
	 */
	@RequestMapping(value="/downloadSummaryTable", method = RequestMethod.POST)
	protected void downloadSummaryTable(HttpServletResponse res,String typeId, String userId) throws Exception {
		ConditionVO conditionVO = new ConditionVO();
		ConditionVO condition = ConditionUtil.getConditionVOByRole(conditionVO);
		String fileName = Constant.SUMMARYNAME + getDate() + ".xlsx"; 
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<InformationVO> list = informationService.selectByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${totalCount}", list.size() + " 条");
		map.put("${date}", getDate());
		map.put("${title}", Constant.SUMMARYTABLETITLE);
		if(typeId != null && !typeId.equals("") && !typeId.equals(Constant.MB)){
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.TOTALTEMPLATE,
					getOutputStreamByCondition(excelName,res), list, InformationVO.class, true);
		}else{
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.MBTEMPLATE,
					getOutputStreamByCondition(excelName,res), list, InformationVO.class, true);
		}
	}

	
	/**
	 * 下载已赎回表
	 * status="1"
	 */
	@RequestMapping(value="/downloadRedeemedTable", method = RequestMethod.POST)
	protected void downloadRedeemedTable(HttpServletResponse res, String typeId, String userId) throws Exception {
		ConditionVO condition = new ConditionVO();
		condition.setStatus(Constant.FLAG_ONE);
		String fileName = Constant.REDEEMEDNAME + getDate() + ".xlsx"; 
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<InformationVO> list = informationService.selectByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${title}", Constant.REDEEMEDTABLETITLE);
		map.put("${totalCount}", list.size() + " 条");
		map.put("${date}", getDate());
		if(typeId != null && !typeId.equals("") && !typeId.equals(Constant.MB)){
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.TOTALTEMPLATE,
					getOutputStreamByCondition(excelName,res), list, InformationVO.class, true);
		}else{
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.MBTEMPLATE,
					getOutputStreamByCondition(excelName,res), list, InformationVO.class, true);
		}
	}
	
	/**
	 * 下载提前赎回表
	 * status="3"
	 */
	@RequestMapping(value="/downloadRedeemableTable", method = RequestMethod.POST)
	protected void downloadRedeemableTable(HttpServletResponse res,String typeId, String userId) throws Exception {
		ConditionVO condition = new ConditionVO();
		condition.setStatus(Constant.FLAG_THREE);
		String fileName = Constant.REDEEMABLENAME + getDate() + ".xlsx"; 
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<InformationVO> list = informationService.selectByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${title}", Constant.REDEEMABLETABLETITLE);
		map.put("${totalCount}", list.size() + " 条");
		map.put("${date}", getDate());
		if(typeId != null && !typeId.equals("") && !typeId.equals(Constant.MB)){
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.TOTALTEMPLATE,
					getOutputStreamByCondition(excelName,res), list, InformationVO.class, true);
		}else{
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.MBTEMPLATE,
					getOutputStreamByCondition(excelName,res), list, InformationVO.class, true);
		}
	}
	
	/**
	 * 下载续投业绩表
	 * continueFlg="0"
	 */
	@RequestMapping(value="/downloadInvestmentTable", method = RequestMethod.POST)
	protected void downloadInvestmentTable(HttpServletResponse res, String typeId, String userId) throws Exception {
		ConditionVO condition = new ConditionVO();
		condition.setContinueFlg(Constant.FLAG_ZERO);
		String fileName = Constant.INVESTMENTNAME + getDate() + ".xlsx"; 
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<InformationVO> list = informationService.selectByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${title}", Constant.INVESTMENTTABLETITLE);
		map.put("${totalCount}", list.size() + " 条");
		map.put("${date}", getDate());
		if(typeId != null && !typeId.equals("") && !typeId.equals(Constant.MB)){
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.TOTALTEMPLATE,
					getOutputStreamByCondition(excelName,res), list, InformationVO.class, true);
		}else{
			ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.MBTEMPLATE,
					getOutputStreamByCondition(excelName,res), list, InformationVO.class, true);
		}
	}
	
	/**
	 * 付息凭证表
	 *
	 */
	@RequestMapping(value = "/downloadInterestCertificate", method = RequestMethod.POST)
	protected void downloadInterestCertificate(ConditionVO condition,HttpServletResponse res) throws Exception {
		String fileName = Constant.INTERESTCERTIFICATENAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		String startTime = condition.getStartTime();
		List<CertificateVO> certificateList = certificateService.selectCertificateByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${title}", Constant.INTERESTCERTIFICATETITLE);
		map.put("${date}", getDate());
		map.put("${startTime}", startTime);
		ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.INTERESTTEMPLATE,
				getOutputStreamByCondition(excelName,res), certificateList, CertificateVO.class, true);
	}
	
	/**
	 * 发放凭证表
	 *
	 */
	@RequestMapping(value = "/downloadReleaseCertificate", method = RequestMethod.POST)
	protected void downloadReleaseCertificate(ConditionVO condition,HttpServletResponse res) throws Exception {
		String fileName = Constant.RELEASECERTIFICATENAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		String startTime = condition.getStartTime();
		List<CertificateVO> certificateList = certificateService.selectCertificateByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${title}", Constant.RELEASECERTIFICATETITLE);
		map.put("${date}", getDate());
		map.put("${startTime}", startTime);
		ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.INTERESTTEMPLATE,
				getOutputStreamByCondition(excelName,res), certificateList, CertificateVO.class, true);
	}
	
	/**
	 * 还本信息表
	 *
	 */
	@RequestMapping(value = "/downloadPrincipal", method = RequestMethod.POST)
	protected void downloadPrincipal(ConditionVO condition,HttpServletResponse res) throws Exception {
		String fileName = Constant.PRINCIPALNAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		String startTime = condition.getStartTime();
		List<PrincipalVO> principalList = principalService.selectPrincipalByCondition(condition);
		for(PrincipalVO principal:principalList){
			String endDate = principal.getEndDate().replaceAll("-", "/");
			principal.setEndDate(endDate);
			//架构信息显示name
			/*OrganizationConditionVO orcon = new OrganizationConditionVO();
			orcon.setVlevel(Constant.FLAG_ZERO);
			//syb
			if(principal.getSyb() != null && !"".equals(principal.getSyb()) && !"A001".equals(principal.getSyb())){
				orcon.setD_ID(principal.getSyb());
				OrganizationResultVO syb = organizationService.selectSybByCondition(orcon);
				if(syb != null){
					principal.setSybname(syb.getDname());
//					informationVO.setSybManager(syb.getDmanager());
				}else{
					principal.setSybname("无");
				}
			}else{
				orcon.setD_ID("A001");
				principal.setSybname("无");
			}
			//dq
			if(principal.getDq() != null && !"".equals(principal.getDq()) && !"B001".equals(principal.getDq())){
				orcon.setP_ID(principal.getDq());
				DqVO dq = organizationService.selectDqByCondition(orcon);
				if(dq != null){
					principal.setDqname(dq.getPname());
				}else{
					principal.setDqname("无");
				}
			}else{
				orcon.setP_ID("B001");
				principal.setDqname("无");
			}
			//fgs
			if(principal.getFgs() != null && !"".equals(principal.getFgs()) && !"C001".equals(principal.getFgs())){
				orcon.setF_ID(principal.getFgs());
				FgsVO fgs = organizationService.selectFgsByCondition(orcon);
				if(fgs != null){
					principal.setFgsname(fgs.getFname());
				}else{
					principal.setFgsname("无");
				}
			}else{
				orcon.setF_ID("C001");
				principal.setFgsname("无");
			}
			//yyb
			if(principal.getYyb() != null && !"".equals(principal.getYyb()) && !"D001".equals(principal.getYyb())){
				orcon.setY_ID(principal.getYyb());
				YybVO yyb = organizationService.selectYybByCondition(orcon);	
				if(yyb != null){
					principal.setYybname(yyb.getYname());
				}else{
					principal.setYybname("无");
				}
			}else{
				orcon.setY_ID("D001");
				principal.setYybname("无");
			}*/
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("${title}", Constant.PRINCIPALTITLE);
		map.put("${startTime}", startTime);
		ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.PRINCIPALTEMPLATE,
				getOutputStreamByCondition(excelName,res), principalList, PrincipalVO.class, true);
	}
	
	/**
	 * 移动支票表
	 *
	 */
	@RequestMapping(value = "/downloadMovableCheck", method = RequestMethod.POST)
	protected void downloadMovableCheck(ConditionVO condition,HttpServletResponse res) throws Exception {
		String fileName = Constant.MOVABLECHECKNAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<MovableCheckVO> movableCheckList = movableCheckService.selectMovableCheckByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${date}", getDate());
		ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.MOVABLECHECKTEMPLATE,
				getOutputStreamByCondition(excelName,res), movableCheckList, MovableCheckVO.class, true);
	}
	
	/**
	 * 银行短信回息表
	 *
	 */
	@RequestMapping(value = "/downloadSMSInterest", method = RequestMethod.POST)
	protected void downloadSMSInterest(ConditionVO condition,HttpServletResponse res) throws Exception {
		String fileName = Constant.SMSINTERESTNAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<CertificateVO> certificateList = certificateService.selectCertificateByCondition(condition);
		for(CertificateVO certificate : certificateList){
			String str = certificate.getInCardNo();
			if(str.length() > 4){
				String inCardNo = str.substring(str.length() - 4);//银行卡后四位
				certificate.setInCardNo(inCardNo);
			}else{
				certificate.setInCardNo(str);
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("${date}", getDate());
		ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.SMSINTERESTTEMPLATE,
				getOutputStreamByCondition(excelName,res), certificateList, CertificateVO.class, true);
	}
	
	/**
	 * 银行短信回本表
	 *
	 */
	@RequestMapping(value = "/downloadSMSCapital", method = RequestMethod.POST)
	protected void downloadSMSCapital(ConditionVO condition,HttpServletResponse res) throws Exception {
		String fileName = Constant.SMSCAPITALNAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<CertificateVO> certificateList = certificateService.selectCertificateByCondition(condition);
		for(CertificateVO certificate : certificateList){
			String str = certificate.getInCardNo();
			if(str.length() > 4){
				String inCardNo = str.substring(str.length() - 4);//银行卡后四位
				certificate.setInCardNo(inCardNo);
			}else{
				certificate.setInCardNo(str);
			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("${date}", getDate());
		ExcelUtil.getInstance().exportObj2ExcelByTemplate(map, Constant.SMSCAPITALTEMPLATE,
				getOutputStreamByCondition(excelName,res), certificateList, CertificateVO.class, true);
	}
	
	/**
	 * 全国汇总表
	 *
	 *//*
	@RequestMapping(value="/downloadNationalSummaryTable", method = RequestMethod.POST)
	protected void downloadNationalSummaryTable(HttpServletResponse res) throws Exception {
		ConditionVO condition = new ConditionVO();
		String fileName = Constant.NATIONALSUMMARYNAME + getDate() + ".xlsx"; 
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<InformationVO> list = informationVOMapper.selectByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${date}", getDate());
		String[] sheetNames = new String[2];
		sheetNames[0] = "理财经理";
		sheetNames[1] = "团队经理";
		ExcelUtil.getInstance().exportObj2ExcelByTemplateTest(map, Constant.NATIONALSUMMARYTEMPLATE,
				getOutputStreamByCondition(excelName,res), list, InformationVO.class, true,sheetNames);
	}*/
	
	/**
	 * 人力与业绩汇总表
	 *
	 */
	@RequestMapping(value="/downloadHumanAndPerformance", method = RequestMethod.POST)
	protected void downloadHumanAndPerformance(HttpServletResponse res,ConditionVO conditionVO) throws Exception {
		ConditionVO condition = ConditionUtil.getConditionVOByRole(conditionVO);
		condition.setJxAchievement(new BigDecimal(12500.00));
		String fileName = Constant.HUMANANDPERFORMANCENAME + getDate() + ".xlsx"; 
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		List<ResultTypeVO> list = informationService.selectHumanAndPerformanceByCondition(condition);
		Map<String, String> map = new HashMap<String, String>();
		map.put("${title}", Constant.HUMANANDPERFORMANCETITLE);
		map.put("${endTime}", condition.getEndTime());
		ExcelUtil.getInstance().exportObj2ExcelByTemplateHP(map, Constant.HUMANANDPERFORMANCETEMPLATE,
				getOutputStreamByCondition(excelName,res), list, ResultTypeVO.class, true);
	}
	
	/**
	 * 实时业绩表
	 *
	 */
	@RequestMapping(value="/downloadActualTimeTable", method = RequestMethod.POST)
	protected void downloadActualTimeTable(HttpServletResponse res,ConditionVO conditionVO, UserVO user) throws Exception {
		
	}
	
	/**
	 * 每日业绩分表
	 *
	 */
	@RequestMapping(value="/downloadPerformancePD", method = RequestMethod.POST)
	protected void downloadPerformancePD(HttpServletResponse res,ConditionVO condition) throws Exception {
		String fileName = Constant.PERFORMANCEPDNAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		String startTime = condition.getStartTime();
		String endTime = condition.getEndTime();
		String strTime = startTime + " 至 " + endTime;
		List<ResultTypeVO> list = informationVOMapper.selectPerformancePDByCondition(condition);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("${title}", Constant.PERFORMANCEPDTITLE);
		map.put("${date}", getDate());
		map.put("${startTime}-${endTime}", strTime);
		ExcelUtil.getInstance().exportObj2ExcelByTemplatePD(map, Constant.PERFORMANCEPDTEMPLATE,
				getOutputStreamByCondition(excelName,res), list, ResultTypeVO.class, true,startTime,endTime);
	}
	
	/**
	 * 下载编码模板
	 *
	 */
	@RequestMapping(value="/downloadCodingTemplate", method = RequestMethod.POST)
	protected void downloadCodingTemplate(HttpServletResponse res) throws Exception {
		String fileName = Constant.CODINGTEMPLATENAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		ExcelUtil.getInstance().downloadCodingTemplate(Constant.CODINGTEMPLATE,
				getOutputStreamByCondition(excelName,res), true);
	}
	
	/**
	 * 下载数据总表模板
	 *
	 */
	@RequestMapping(value="/downloadDataTemplate", method = RequestMethod.POST)
	protected void downloadDataTemplate(HttpServletResponse res) throws Exception {
		String fileName = Constant.SUMMARYNAME + getDate() + ".xlsx";
		String excelName = new String(fileName.getBytes("gb2312") , "ISO8859-1");
		ExcelUtil.getInstance().downloadCodingTemplate(Constant.UPLOADINFOTEMPLATE,
				getOutputStreamByCondition(excelName,res), true);
	}
	
	protected OutputStream getOutputStreamByCondition(String fileName,HttpServletResponse res){
		res.setHeader("content-type", "application/octet-stream");
	    res.setContentType("application/octet-stream");
	    res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
	    OutputStream os = null;
		      try {
				os = res.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    return os;
	}
	
	private String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(Constant.PATTERN);
		return sdf.format(new Date());
	}
}
