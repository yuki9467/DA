package com.bqhx.yyb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bqhx.yyb.client.InformationClient;
import com.bqhx.yyb.vo.ConditionVO;
import com.bqhx.yyb.vo.InformationHistoryVO;
import com.bqhx.yyb.vo.InformationVO;
import com.bqhx.yyb.vo.MessageVO;


/**
 * @author Administrator InformationController
 */

@RestController
@RequestMapping("/")
public class InformationController {

	@Autowired
	private InformationClient informationClient;
	/**
	 * 
	 * @param record
	 * @return messageVO delete
	 */
	@RequestMapping(value = "/deleteByPrimaryKey", method = RequestMethod.POST)
	MessageVO deleteByPrimaryKey(ConditionVO condition) {
		return informationClient.deleteByPrimaryKey(condition);
	}

	/**
	 * 
	 * @param record
	 * @return messageVO insert
	 */
	@RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
	MessageVO insertSelective(ConditionVO condition) {
		return informationClient.insertSelective(condition);
	}

	@RequestMapping(value = "/selectByCondition", method = RequestMethod.POST)
	List<InformationVO> selectByCondition(ConditionVO conditionVO) {
		return informationClient.selectByCondition(conditionVO);
	}
	
	@RequestMapping(value = "/selectByContract", method = RequestMethod.POST)
	InformationVO selectByContract(ConditionVO conditionVO) {
		return informationClient.selectByContract(conditionVO);
	}
	
	/**
	 * 
	 * 人力与业绩
	 */
	/*@RequestMapping(value = "/selectHumanAndPerformanceByCondition", method = RequestMethod.POST)
	List<ResultTypeVO> selectHumanAndPerformanceByCondition(ConditionVO conditionVO, UserVO user) {
		ConditionVO condition = ConditionUtil.getConditionVOByRole(conditionVO,user);
		condition.setJxAchievement(new BigDecimal(12500.00));
		List<ResultTypeVO> informationVOList = informationService.selectHumanAndPerformanceByCondition(condition,user);
		return informationVOList;
	}*/
	
	@RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
	MessageVO updateByPrimaryKeySelective(ConditionVO conditionVO) {
		return informationClient.updateByPrimaryKeySelective(conditionVO);
	}

	/**
	 * 
	 * @param record
	 * @return record approve
	 */
	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	MessageVO approve(ConditionVO condition) {
		return informationClient.approve(condition);
	}

	/**
	 * 查询历史记录
	 * @param conditionVO
	 * @return InformationVOList
	 */
	@RequestMapping(value = "/selectInfoHistoryByCondition", method = RequestMethod.POST)
	List<InformationHistoryVO> selectInfoHistoryByCondition(ConditionVO condition){
		return informationClient.selectInfoHistoryByCondition(condition);
	}
}
