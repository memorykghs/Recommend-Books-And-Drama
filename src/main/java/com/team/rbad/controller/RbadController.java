package com.team.rbad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.INSITEMT001Tranrq;
import com.team.rbad.dto.INSITEMT001Tranrs;
import com.team.rbad.dto.TAGINFOQ001Tranrq;
import com.team.rbad.dto.TAGINFOQ001Tranrs;
import com.team.rbad.exception.DataNotFoundException;
import com.team.rbad.service.INSITEMT001Svc;
import com.team.rbad.service.TAGINFOQ001Svc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Recommend Book And Movies")
@RestController
@RequestMapping(value = "/rbad")
public class RbadController {

	@Autowired
	private INSITEMT001Svc theRBADINSIT001Svc;
	
	@Autowired
	private TAGINFOQ001Svc theTAGINFOQ001Svc;

	@ApiOperation(value = "新增作品")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public TranResponse<INSITEMT001Tranrs> insert(TranRequest<INSITEMT001Tranrq> req) {
		return theRBADINSIT001Svc.insertItem(req);
	}
	
	@ApiOperation(value = "查詢標籤")
	@RequestMapping(value = "/query/tag", method = RequestMethod.POST)
	public TranResponse<TAGINFOQ001Tranrs> queryTag(TranRequest<TAGINFOQ001Tranrq> req) throws DataNotFoundException {
		return theTAGINFOQ001Svc.queryTag(req);
	}

}
