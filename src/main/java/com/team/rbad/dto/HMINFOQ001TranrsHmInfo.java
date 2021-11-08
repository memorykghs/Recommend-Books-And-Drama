package com.team.rbad.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 首頁查詢ITEM_INFO
 * @author paramecium
 */
@Data
public class HMINFOQ001TranrsHmInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** 類別ID */
	@JsonProperty(value = "itemId")
	private String itemId;
	
	/** 書名 */
	@JsonProperty(value = "itemName")
	private String itemName;
	
	/** 描述 */
	@JsonProperty(value = "description")
	private String description;

}
