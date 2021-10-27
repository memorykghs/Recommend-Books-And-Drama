package com.team.rbad.service;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.TAGINFOQ001Tranrs;
import com.team.rbad.dto.TAGNUMQ001Tranrq;
import com.team.rbad.exception.ErrorInputException;

/**
 * 查詢標籤
 * @author paramecium
 */
public interface TAGNUMQ001Svc {

	/**
	 * 隨機查詢n個標籤
	 * @param req
	 * @return
	 * @throws ErrorInputException 
	 */
	TranResponse<TAGINFOQ001Tranrs> queryTagNumber(TranRequest<TAGNUMQ001Tranrq> req) throws ErrorInputException;
}

