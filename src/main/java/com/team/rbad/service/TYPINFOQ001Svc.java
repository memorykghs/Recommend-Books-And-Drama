package com.team.rbad.service;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.TYPINFOQ001Tranrq;
import com.team.rbad.dto.TYPINFOQ001Tranrs;
import com.team.rbad.exception.DataNotFoundException;

/**
 * 查詢標籤
 * @author paramecium
 */
public interface TYPINFOQ001Svc {

	/**
	 * 查詢類別
	 * @param req
	 * @return
	 */
	TranResponse<TYPINFOQ001Tranrs> queryType(TranRequest<TYPINFOQ001Tranrq> req) throws DataNotFoundException;
	
}

