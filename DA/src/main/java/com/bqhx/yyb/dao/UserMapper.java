package com.bqhx.yyb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bqhx.yyb.vo.ConditionVO;
import com.bqhx.yyb.vo.UserConditionVO;
import com.bqhx.yyb.vo.UserHistoryVO;
import com.bqhx.yyb.vo.UserVO;

@Mapper
public interface UserMapper {

	List<UserVO> selectUserByCondition(UserConditionVO condition);

	int insertUserSelective(UserConditionVO condition);
	
	UserVO selectUserByPrimaryKey(UserConditionVO condition);

	int updateUserByPrimaryKeySelective(UserConditionVO condition);
	//批量插入user表
	int insertUserBatch(@Param("uconlist")List<UserConditionVO> conlist);
}