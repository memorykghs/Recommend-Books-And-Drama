package com.team.rbad.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢標籤 下行
 * @author memorykghs
 */
@Data
public class TAGINFOQ001Tranrs implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 標籤資訊集合 */
	@JsonProperty("TagInfoSet")
	private Set<TAGINFOQ001TranrsTagInfo> tagInfoSet;
}
