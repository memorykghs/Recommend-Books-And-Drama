package com.team.rbad.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.CATINFOQ001Tranrq;
import com.team.rbad.dto.CATINFOQ001Tranrs;
import com.team.rbad.dto.CATINFOQ001TranrsCategoryInfo;
import com.team.rbad.entity.CategoryInfo;
import com.team.rbad.exception.DataNotFoundException;
import com.team.rbad.repository.CategoryInfoRepo;
import com.team.rbad.service.CATINFOQ001Svc;
import com.team.rbad.util.TranResponseFactory;

/**
 * 查詢作品類型
 * @author memorykghs
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CATINFOQ001SvcImpl implements CATINFOQ001Svc {

	@Autowired
	private CategoryInfoRepo categoryInfoRepo;

	@Autowired
	private TranResponseFactory tranResponseFactory;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public TranResponse<CATINFOQ001Tranrs> queryCategory(TranRequest<CATINFOQ001Tranrq> req)
			throws DataNotFoundException {

		CATINFOQ001Tranrq tranrq = req.getReqData();
		return tranResponseFactory.genSucessResponse(queryCategory(tranrq));
	}

	/**
	 * 查詢種類
	 * 
	 * @param tranrq
	 * @return
	 * @throws DataNotFoundException
	 */
	public CATINFOQ001Tranrs queryCategory(CATINFOQ001Tranrq tranrq) throws DataNotFoundException {

		String categoryId = tranrq.getCategoryId();
		String name = tranrq.getName();
		
		List<CATINFOQ001TranrsCategoryInfo> rtnList = new ArrayList<>();

		if (StringUtils.isNotBlank(categoryId) && StringUtils.isBlank(name)) {
			CategoryInfo categoryInfo = categoryInfoRepo.findById(categoryId)
					.orElseThrow(() -> new DataNotFoundException());
			CATINFOQ001TranrsCategoryInfo tranrsCategoryInfo = mapper.convertValue(categoryInfo,
					CATINFOQ001TranrsCategoryInfo.class);
			rtnList.add(tranrsCategoryInfo);

		} else if (StringUtils.isBlank(categoryId) && StringUtils.isNotBlank(name)) {
			CategoryInfo categoryInfo = categoryInfoRepo.findByName(name)
					.orElseThrow(() -> new DataNotFoundException());
			CATINFOQ001TranrsCategoryInfo tranrsCategoryInfo = mapper.convertValue(categoryInfo,
					CATINFOQ001TranrsCategoryInfo.class);
			rtnList.add(tranrsCategoryInfo);

		} else {
			rtnList = categoryInfoRepo.findAll().stream()
					.map(categoryInfo -> mapper.convertValue(categoryInfo, CATINFOQ001TranrsCategoryInfo.class))
					.collect(Collectors.toList());
		}
		
		CATINFOQ001Tranrs tranrs = new CATINFOQ001Tranrs();
		tranrs.setCategorySet(rtnList);
		return new CATINFOQ001Tranrs();

	}

}
