package com.team.rbad.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 查詢標籤 上行
 * @author paramecium
 */
@Data
public class TAGNUMQ001Tranrq implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 想隨機拿的標籤數量 */
	@Min(value = 1, message = "Can't be less then 1 Tag.")
	@JsonProperty("ItemNumber")
	private int itemNumber ;
}
