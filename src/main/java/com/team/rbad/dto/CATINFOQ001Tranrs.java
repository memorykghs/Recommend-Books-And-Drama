package com.team.rbad.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢作品類型
 * CATINFOQ001Tranrs
 * @author memorykghs
 */
@Data
public class CATINFOQ001Tranrs implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 作品類別資訊集合 */
	@JsonProperty("CategorySet")
	private List<CATINFOQ001TranrsCategoryInfo> categorySet;

	
}
