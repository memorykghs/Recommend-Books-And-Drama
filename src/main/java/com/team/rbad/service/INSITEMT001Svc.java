package com.team.rbad.service;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.INSITEMT001Tranrq;
import com.team.rbad.dto.INSITEMT001Tranrs;

/**
 * RBADINSIT001 新增作品
 * @author memorykghs
 */
public interface INSITEMT001Svc {

	/**
	 * 新增作品
	 * @param req
	 * @return
	 */
	TranResponse<INSITEMT001Tranrs> insertItem(TranRequest<INSITEMT001Tranrq> req);
}
