package com.team.rbad.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.TAGINFOQ001Tranrs;
import com.team.rbad.dto.TAGINFOQ001TranrsTagInfo;
import com.team.rbad.dto.TAGNUMQ001Tranrq;
import com.team.rbad.entity.TagInfo;
import com.team.rbad.exception.ErrorInputException;
import com.team.rbad.repository.TagInfoRepo;
import com.team.rbad.service.TAGNUMQ001Svc;
import com.team.rbad.util.TranResponseFactory;

/**
 * 查詢標籤
 * 
 * @author paramecium
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TAGNUMQ001SvcImpl implements TAGNUMQ001Svc {

	@Autowired
	private TranResponseFactory tranResponseFactory;

	@Autowired
	private TagInfoRepo tagInfoRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public TranResponse<TAGINFOQ001Tranrs> queryTagNumber(TranRequest<TAGNUMQ001Tranrq> req)
			throws ErrorInputException {

		List<TagInfo> tagInfoList = tagInfoRepo.findAll().stream().collect(Collectors.toList());

		Random random = new Random();
		Set<TagInfo> querySet = new HashSet<TagInfo>();
		while (querySet.size() < req.getReqData().getTagNumber()) {
			int randomIndex = random.nextInt(tagInfoList.size());
			querySet.add(tagInfoList.get(randomIndex));
		}
		
		TAGINFOQ001Tranrs resp = new TAGINFOQ001Tranrs();
		resp.setTagInfoSet(querySet.stream().map(tagInfo -> mapper.convertValue(tagInfo, TAGINFOQ001TranrsTagInfo.class))
				.collect(Collectors.toSet()));

		return tranResponseFactory.genSucessResponse(resp);
	}

}
