package com.team.rbad.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢作品類型 CATINFOQ001TranrsCategoryInfo
 * 
 * @author memorykghs
 */
@Data
public class CATINFOQ001TranrsCategoryInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 作品類別Id */
	@JsonProperty("CategoryId")
	private String categoryId;

	/** 作品類別名稱 */
	@JsonProperty("Name")
	private String name;
}
