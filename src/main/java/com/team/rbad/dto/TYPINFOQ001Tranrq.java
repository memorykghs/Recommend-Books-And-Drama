package com.team.rbad.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢類別 上行
 * @author paramecium
 */
@Data
public class TYPINFOQ001Tranrq implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 類別名稱 */
	@Size(min = 1, max = 50)
	@JsonProperty("TypeName")
	private String typeName;

}
