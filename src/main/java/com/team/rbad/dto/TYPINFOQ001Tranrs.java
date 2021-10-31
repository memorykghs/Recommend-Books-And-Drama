package com.team.rbad.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢標籤 下行
 * @author paramecium
 */
@Data
public class TYPINFOQ001Tranrs implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 標籤資訊集合 */
	@JsonProperty("TypeInfoList")
	private List<TYPINFOQ001TranrsTypeInfo> typeInfoList;
}
