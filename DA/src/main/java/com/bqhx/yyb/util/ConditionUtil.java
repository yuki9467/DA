package com.bqhx.yyb.util;

import com.bqhx.yyb.constant.Constant;
import com.bqhx.yyb.vo.ConditionVO;

public class ConditionUtil {
	/**
	 * 根据用户角色处理查询条件
	 */
	public static ConditionVO getConditionVOByRole(ConditionVO condition){
		String userId = condition.getUserId();
		String typeId = condition.getTypeId();
		if(typeId != null && !typeId.equals("")){
			if(typeId.equals(Constant.LCMANAGER)){
				condition.setLcManager(userId);
			}else if(typeId.equals(Constant.TMANAGER)){
				condition.setTmanager(userId);
			}else if(typeId.equals(Constant.YYBMANAGER)){
				condition.setYybManager(userId);
			}else if(typeId.equals(Constant.FGSMANAGER)){
				condition.setFgsManager(userId);
			}else if(typeId.equals(Constant.DQMANAGER)){
				condition.setDqManager(userId);
			}else if(typeId.equals(Constant.SYBMANAGER)){
				condition.setSybManager(userId);
			}
			if(typeId.equals(Constant.SYBOFFICE)){
				condition.setSyb(condition.getSid());
			}else if(typeId.equals(Constant.DQOFFICE)){
				condition.setDq(condition.getDid());
			}else if(typeId.equals(Constant.FGSOFFICE)){
				condition.setFgs(condition.getFid());
			}else if(typeId.equals(Constant.YYBOFFICE)){
				condition.setYyb(condition.getYid());
			}
		}
		return condition;
	}
}
