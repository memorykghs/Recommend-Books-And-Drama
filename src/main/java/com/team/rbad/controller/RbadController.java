package com.team.rbad.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team.rbad.base.TranRequest;
import com.team.rbad.base.TranResponse;
import com.team.rbad.dto.CATINFOQ001Tranrq;
import com.team.rbad.dto.CATINFOQ001Tranrs;
import com.team.rbad.dto.HMITEMQ001Tranrq;
import com.team.rbad.dto.HMITEMQ001Tranrs;
import com.team.rbad.dto.INSITEMT001Tranrq;
import com.team.rbad.dto.INSITEMT001Tranrs;
import com.team.rbad.dto.SECHITQ001Tranrq;
import com.team.rbad.dto.SECHITQ001Tranrs;
import com.team.rbad.dto.TAGINFOQ001Tranrq;
import com.team.rbad.dto.TAGINFOQ001Tranrs;
import com.team.rbad.dto.TAGNUMQ001Tranrq;
import com.team.rbad.dto.TYPINFOQ001Tranrq;
import com.team.rbad.dto.TYPINFOQ001Tranrs;
import com.team.rbad.exception.DataNotFoundException;
import com.team.rbad.exception.ErrorInputException;
import com.team.rbad.service.CATINFOQ001Svc;
import com.team.rbad.service.HMITEMQ001Svc;
import com.team.rbad.service.INSITEMT001Svc;
import com.team.rbad.service.SECHITQ001Svc;
import com.team.rbad.service.TAGINFOQ001Svc;
import com.team.rbad.service.TAGNUMQ001Svc;
import com.team.rbad.service.TYPINFOQ001Svc;

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
	private TAGNUMQ001Svc theTAGNUMQ001Svc;

	@Autowired
	private CATINFOQ001Svc theCATINFOQ001Svc;

	@Autowired
	private TYPINFOQ001Svc theTYPINFOQ001Svc;
	
	@Autowired
	private HMITEMQ001Svc theHMITEMQ001Svc;

	@Autowired
	private SECHITQ001Svc theSECHITQ001Svc;

	@ApiOperation(value = "新增作品")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public TranResponse<INSITEMT001Tranrs> insert(@RequestBody TranRequest<INSITEMT001Tranrq> req)
			throws ErrorInputException {
		return theRBADINSIT001Svc.insertItem(req);
	}

	@ApiOperation(value = "查詢標籤")
	@RequestMapping(value = "/query/tag", method = RequestMethod.POST)
	public TranResponse<TAGINFOQ001Tranrs> queryTag(@RequestBody TranRequest<TAGINFOQ001Tranrq> req)
			throws DataNotFoundException {
		return theTAGINFOQ001Svc.queryTag(req);
	}

	@ApiOperation(value = "查詢指定數量標籤")
	@RequestMapping(value = "/query/tagNumber", method = RequestMethod.POST)
	public TranResponse<TAGINFOQ001Tranrs> queryTagNumber(@Valid @RequestBody TranRequest<TAGNUMQ001Tranrq> req,
			Errors err) throws DataNotFoundException, ErrorInputException {
		if (err.hasErrors()) {
			throw new DataNotFoundException();
		}
		return theTAGNUMQ001Svc.queryTagNumber(req);
	}

	@ApiOperation(value = "查詢作品類型")
	@RequestMapping(value = "/query/category", method = RequestMethod.POST )
	public TranResponse<CATINFOQ001Tranrs> queryCategory(TranRequest<CATINFOQ001Tranrq> req)
			throws DataNotFoundException {
		return theCATINFOQ001Svc.queryCategory(req);
	}

	@ApiOperation(value = "查詢作品類別")
	@RequestMapping(value = "/query/type", method = RequestMethod.POST)
	public TranResponse<TYPINFOQ001Tranrs> queryType(@RequestBody TranRequest<TYPINFOQ001Tranrq> req)
			throws DataNotFoundException {
		return theTYPINFOQ001Svc.queryType(req);
	}
	
	@ApiOperation(value = "查詢首頁最新書籍n筆")
	@RequestMapping(value = "/query/hmNewstItem", method = RequestMethod.POST)
	public TranResponse<HMITEMQ001Tranrs> queryHmNewstItem(@RequestBody TranRequest<HMITEMQ001Tranrq> req)
			throws ErrorInputException {
		return theHMITEMQ001Svc.queryHomeItemNewest(req);
	}

	@ApiOperation(value = "首頁查詢")
	@RequestMapping(value = "/query/items", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TranResponse<SECHITQ001Tranrs> queryItemList(@RequestBody TranRequest<SECHITQ001Tranrq> req)
			throws DataNotFoundException {
		return theSECHITQ001Svc.searchItemList(req);
	}

}
