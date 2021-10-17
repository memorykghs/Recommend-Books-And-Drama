package com.team.rbad.service;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.CATINFOQ001Tranrq;
import com.team.rbad.dto.CATINFOQ001Tranrs;
import com.team.rbad.exception.DataNotFoundException;

/**
 * 查詢作品類型
 * @author memorykghs
 */
public interface CATINFOQ001Svc {

	TranResponse<CATINFOQ001Tranrs> queryCategory(TranRequest<CATINFOQ001Tranrq> req) throws DataNotFoundException;

}
