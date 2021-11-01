package com.team.rbad.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * SECHITQ001 列表查詢
 * 下行電文
 * @author lijiachi
 */
@Data
public class SECHITQ001Tranrs {

	/** 總筆數 */
	@JsonProperty("TotalCount")
	private String Count;
	
	@JsonProperty("ItemList")
	private List<SECHITQ001TranrsItemList> itemList;
}
