package com.team.rbad.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢標籤 下行 標籤資訊
 * @author paramecium
 */
@Data
public class TYPINFOQ001TranrsTypeInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** 類別ID */
	@JsonProperty(value = "typeId")
	private String typeId;
	
	/** 類別名稱 */
	@JsonProperty(value = "name")
	private String name;

}
