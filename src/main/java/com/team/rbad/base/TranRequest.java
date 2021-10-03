package com.team.rbad.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Transaction Request
 * @author memorykghs
 */
@Data
public class TranRequest<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 請求資料 */
	@JsonProperty("ReqData")
	private T reqData;
}
