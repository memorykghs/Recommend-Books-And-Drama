package com.team.rbad.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢標籤 上行
 * @author memorykghs
 */
@Data
public class TAGINFOQ001Tranrq implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 標籤名稱 */
	@Size(min = 1, max = 50)
	@JsonProperty("TagName")
	private String tagName;
}
