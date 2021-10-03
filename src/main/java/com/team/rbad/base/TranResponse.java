package com.team.rbad.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Transaction Response
 * @author memorykghs
 */
@Data
public class TranResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 交易時間 */
	@JsonProperty("TranTime")
	private String tranTime;

	/** 交易結果代碼 */
	@JsonProperty("ReturnCode")
	private String returnCode;

	/** 交易結果訊息 */
	@JsonProperty("ReturnMsg")
	private String returnMsg;

	/** 回傳資料 */
	@JsonProperty("RespData")
	private T respData;
}
