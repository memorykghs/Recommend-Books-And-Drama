package com.team.rbad.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢標籤 下行 標籤資訊
 * @author user
 */
@Data
public class TAGINFOQ001TranrsTagInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** 標籤ID */
	@JsonProperty("TagId")
	private String tagId;
	
	/** 標籤名稱 */
	@JsonProperty("Name")
	private String name;

}
