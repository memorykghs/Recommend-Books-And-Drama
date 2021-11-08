package com.team.rbad.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.HMINFOQ001TranrsHmInfo;
import com.team.rbad.dto.HMITEMQ001Tranrq;
import com.team.rbad.dto.HMITEMQ001Tranrs;
import com.team.rbad.entity.ItemInfo;
import com.team.rbad.exception.ErrorInputException;
import com.team.rbad.repository.ItemInfoRepo;
import com.team.rbad.service.HMITEMQ001Svc;
import com.team.rbad.util.TranResponseFactory;

/**
 * 查詢標籤
 * 
 * @author paramecium
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HMITEMQ001SvcImpl implements HMITEMQ001Svc {

	@Autowired
	private TranResponseFactory tranResponseFactory;

	@Autowired
	private ItemInfoRepo itemInfoRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public TranResponse<HMITEMQ001Tranrs> queryHomeItemNewest(TranRequest<HMITEMQ001Tranrq> req)
			throws ErrorInputException {
		int itemNumber = req.getReqData().getItemNumber();
		if (itemNumber < 1) {
			throw new ErrorInputException("IitemNumber不得小於1");
		}
		Page<ItemInfo> pageResult = itemInfoRepo.findAll(PageRequest.of(0, // 查詢的頁數，從0起算
				itemNumber, // 查詢的每頁筆數
				Sort.by("updTime").descending())); // 依CREATE_TIME欄位降冪排序

		List<HMINFOQ001TranrsHmInfo> hmInfoList = new ArrayList<>();
		hmInfoList = pageResult.getContent().stream()
				.map(itemInfoList -> mapper.convertValue(itemInfoList, HMINFOQ001TranrsHmInfo.class))
				.collect(Collectors.toList());

		HMITEMQ001Tranrs resp = new HMITEMQ001Tranrs();
		resp.setHmInfoList(hmInfoList);
		return tranResponseFactory.genSucessResponse(resp);

	}

}
