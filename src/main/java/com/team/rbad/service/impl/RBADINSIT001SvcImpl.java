package com.team.rbad.service.impl;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.RBADINSIT001Tranrq;
import com.team.rbad.dto.RBADINSIT001Tranrs;
import com.team.rbad.repository.ItemInfoRepo;
import com.team.rbad.service.RBADINSIT001Svc;

/**
 * RBADINSIT001 新增作品
 * @author memorykghs
 */
public class RBADINSIT001SvcImpl implements RBADINSIT001Svc{
	
	/** ItemInfoRepo */
	private ItemInfoRepo itemInfoRepo;

	@Override
	public TranResponse<RBADINSIT001Tranrs> insertItem(TranRequest<RBADINSIT001Tranrq> req) {
		// TODO Auto-generated method stub
		return null;
	}

}
