package com.bqhx.yyb.service;

import java.util.List;

import com.bqhx.yyb.vo.ConditionVO;
import com.bqhx.yyb.vo.MovableCheckVO;

public interface MovableCheckService {
	void insertMovableCheck(ConditionVO condition);
	
	List<MovableCheckVO> selectMovableCheckByCondition(ConditionVO condition);
}
