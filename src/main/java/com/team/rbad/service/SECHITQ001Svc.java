package com.team.rbad.service;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.SECHITQ001Tranrq;
import com.team.rbad.dto.SECHITQ001Tranrs;

/**
 * SECHITQ001 列表查詢
 * @author lijiachi
 */
public interface SECHITQ001Svc {

	/**
	 * SECHITQ001 列表查詢
	 * @param req
	 * @return
	 */
	TranResponse<SECHITQ001Tranrs> searchItemList(TranRequest<SECHITQ001Tranrq> req);
}
