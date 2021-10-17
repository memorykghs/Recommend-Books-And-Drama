package com.team.rbad.enums;

import lombok.Getter;

/**
 * Return Code
 * @author memorykghs
 */
@Getter
public enum ReturnCode {

	C000("0000", "交易成功"),
	C001("0001", "必填欄位有誤"),
	C002("0002", "查無資料"),
	C099("9999", "其他系統異常");

	ReturnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	private String code;

	private String message;
}
