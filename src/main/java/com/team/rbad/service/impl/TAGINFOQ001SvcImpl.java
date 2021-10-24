package com.team.rbad.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.TAGINFOQ001Tranrq;
import com.team.rbad.dto.TAGINFOQ001Tranrs;
import com.team.rbad.dto.TAGINFOQ001TranrsTagInfo;
import com.team.rbad.entity.TagInfo;
import com.team.rbad.exception.DataNotFoundException;
import com.team.rbad.repository.TagInfoRepo;
import com.team.rbad.service.TAGINFOQ001Svc;
import com.team.rbad.util.TranResponseFactory;

/**
 * 查詢標籤
 * @author memorykghs
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TAGINFOQ001SvcImpl implements TAGINFOQ001Svc {

	@Autowired
	private TranResponseFactory tranResponseFactory;

	@Autowired
	private TagInfoRepo tagInfoRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public TranResponse<TAGINFOQ001Tranrs> queryTag(TranRequest<TAGINFOQ001Tranrq> req) throws DataNotFoundException {

		String tagName = req.getReqData().getTagName();

		Set<TAGINFOQ001TranrsTagInfo> tagInfoSet = new HashSet<>();
		if (StringUtils.isNoneBlank(tagName)) {
			TagInfo tagInfo = tagInfoRepo.findByName(tagName).orElseThrow(() -> new DataNotFoundException());
			tagInfoSet.add(mapper.convertValue(tagInfo, TAGINFOQ001TranrsTagInfo.class));

		} else {
			tagInfoSet = tagInfoRepo.findAll().stream()
					.map(tagInfo -> mapper.convertValue(tagInfo, TAGINFOQ001TranrsTagInfo.class))
					.collect(Collectors.toSet());
		}

		TAGINFOQ001Tranrs resp = new TAGINFOQ001Tranrs();
		resp.setTagInfoSet(tagInfoSet);

		return tranResponseFactory.genSucessResponse(resp);
	}

}
