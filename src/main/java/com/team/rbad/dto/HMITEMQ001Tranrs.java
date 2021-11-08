package com.team.rbad.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 首頁查詢ITEM_INFO 下行
 * @author paramecium
 */
@Data
public class HMITEMQ001Tranrs implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 標籤資訊集合 */
	@JsonProperty("HmInfoList")
	private List<HMINFOQ001TranrsHmInfo> hmInfoList;
}
