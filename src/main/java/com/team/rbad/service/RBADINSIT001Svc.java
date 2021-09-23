package com.team.rbad.service;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.RBADINSIT001Tranrq;
import com.team.rbad.dto.RBADINSIT001Tranrs;

/**
 * RBADINSIT001 新增作品
 * @author memorykghs
 */
public interface RBADINSIT001Svc {

	/**
	 * 新增作品
	 * @param req
	 * @return
	 */
	TranResponse<RBADINSIT001Tranrs> insertItem(TranRequest<RBADINSIT001Tranrq> req);
}
