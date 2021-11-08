package com.team.rbad.service;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.HMITEMQ001Tranrq;
import com.team.rbad.dto.HMITEMQ001Tranrs;
import com.team.rbad.exception.ErrorInputException;

/**
 * 查詢標籤
 * 
 * @author paramecium
 */
public interface HMITEMQ001Svc {

	/**
	 * 查詢更新時間最新n筆資料
	 * 
	 * @param req
	 * @return
	 */
	TranResponse<HMITEMQ001Tranrs> queryHomeItemNewest(TranRequest<HMITEMQ001Tranrq> req) throws ErrorInputException;
}
