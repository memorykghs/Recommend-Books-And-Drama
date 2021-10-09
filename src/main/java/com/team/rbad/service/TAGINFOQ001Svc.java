package com.team.rbad.service;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.TAGINFOQ001Tranrq;
import com.team.rbad.dto.TAGINFOQ001Tranrs;
import com.team.rbad.exception.DataNotFoundException;

/**
 * 查詢標籤
 * @author memorykghs
 */
public interface TAGINFOQ001Svc {

	/**
	 * 查詢標籤
	 * @param req
	 * @return
	 */
	TranResponse<TAGINFOQ001Tranrs> queryTag(TranRequest<TAGINFOQ001Tranrq> req) throws DataNotFoundException;
}
