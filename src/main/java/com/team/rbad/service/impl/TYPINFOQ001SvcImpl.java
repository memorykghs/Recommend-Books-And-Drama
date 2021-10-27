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
import com.team.rbad.dto.TYPINFOQ001Tranrq;
import com.team.rbad.dto.TYPINFOQ001Tranrs;
import com.team.rbad.dto.TYPINFOQ001TranrsTypeInfo;
import com.team.rbad.entity.TypeInfo;
import com.team.rbad.exception.DataNotFoundException;
import com.team.rbad.repository.TypeInfoRepo;
import com.team.rbad.service.TYPINFOQ001Svc;
import com.team.rbad.util.TranResponseFactory;

/**
 * 查詢標籤
 * 
 * @author paramecium
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TYPINFOQ001SvcImpl implements TYPINFOQ001Svc {

	@Autowired
	private TranResponseFactory tranResponseFactory;

	@Autowired
	private TypeInfoRepo typeInfoRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public TranResponse<TYPINFOQ001Tranrs> queryType(TranRequest<TYPINFOQ001Tranrq> req) throws DataNotFoundException {

		String tagName = req.getReqData().getTypeName();

		List<TYPINFOQ001TranrsTypeInfo> typeInfoList = new ArrayList<>();
		if (StringUtils.isNoneBlank(tagName)) {
			TypeInfo typeInfo = typeInfoRepo.findByNameContaining(tagName).orElseThrow(() -> new DataNotFoundException());
			typeInfoList.add(mapper.convertValue(typeInfo, TYPINFOQ001TranrsTypeInfo.class));
		} else {
			typeInfoList = typeInfoRepo.findAll().stream()
					.map(typeInfo -> mapper.convertValue(typeInfo, TYPINFOQ001TranrsTypeInfo.class))
					.collect(Collectors.toList());
		}

		TYPINFOQ001Tranrs resp = new TYPINFOQ001Tranrs();
		resp.setTypeInfoList(typeInfoList);

		return tranResponseFactory.genSucessResponse(resp);
	}

}
