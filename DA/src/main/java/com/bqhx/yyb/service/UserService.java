package com.bqhx.yyb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.UserHistoryVO;
import com.bqhx.yyb.vo.UserVO;

public interface UserService {
	boolean insertUserSelective(UserConditionVO condition);
	
	List<UserVO> selectUserByCondition(UserConditionVO condition);
	
	UserVO selectUserByPrimaryKey(UserConditionVO condition);
	/**更新 */
	int updateUserByPrimaryKeySelective(UserConditionVO condition,String localUserId);
	
	int insertUserHistory(UserConditionVO record);
	
	List<UserHistoryVO> selectUserHistoryByCondition(UserConditionVO condition);
	//批量插入user表
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	int insertUserBatch(@Param("uconlist")List<UserConditionVO> conlist);
}
