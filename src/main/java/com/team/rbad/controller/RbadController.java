package com.team.rbad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.CATINFOQ001Tranrq;
import com.team.rbad.dto.CATINFOQ001Tranrs;
import com.team.rbad.dto.INSITEMT001Tranrq;
import com.team.rbad.dto.INSITEMT001Tranrs;
import com.team.rbad.dto.TAGINFOQ001Tranrq;
import com.team.rbad.dto.TAGINFOQ001Tranrs;
import com.team.rbad.exception.DataNotFoundException;
import com.team.rbad.exception.ErrorInputException;
import com.team.rbad.service.CATINFOQ001Svc;
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
	
	@Autowired
	private CATINFOQ001Svc theCATINFOQ001Svc;

	@ApiOperation(value = "新增作品")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public TranResponse<INSITEMT001Tranrs> insert(@RequestBody TranRequest<INSITEMT001Tranrq> req) throws ErrorInputException {
		return theRBADINSIT001Svc.insertItem(req);
	}
	
	@ApiOperation(value = "查詢標籤")
	@RequestMapping(value = "/query/tag", method = RequestMethod.POST)
	public TranResponse<TAGINFOQ001Tranrs> queryTag(@RequestBody TranRequest<TAGINFOQ001Tranrq> req) throws DataNotFoundException {
		return theTAGINFOQ001Svc.queryTag(req);
	}
	
	@ApiOperation(value = "查詢作品類型")
	@RequestMapping(value = "/query/category", method = RequestMethod.POST)
	public TranResponse<CATINFOQ001Tranrs> queryCategory(@RequestBody TranRequest<CATINFOQ001Tranrq> req) throws DataNotFoundException {
		return theCATINFOQ001Svc.queryCategory(req);
	}
}
