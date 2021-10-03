package com.team.rbad.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * RbadInsIt001TranrsTagInfo 標籤資訊DTO
 * @author memorykghs
 */
@Data
public class INSITEMT001TranrqTagInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 標籤ID */
	@JsonProperty("TagId")
	@Size(max = 6, message = "TagId長度不可超過6")
	private String tagId;

	/** 標籤名稱 */
	@NotBlank
	@Size(max = 50, message = "TagName長度不可超過50")
	@JsonProperty("TagName")
	private String tagName;

}
