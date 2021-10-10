package com.team.rbad.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.team.rbad.base.TranResponse;
import com.team.rbad.enums.ReturnCode;

/**
 * TranResponse Factory
 * @author memroykghs
 */
@Component
public class TranResponseFactory {

	/** DateTimeFormat */
	private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	/**
	 * 產生成功 Response
	 * @param <T>
	 * @return
	 */
	public <T> TranResponse<T> genSucessResponse(T respData) {

		LocalDateTime time = LocalDateTime.now();

		TranResponse<T> resp = new TranResponse<>();
		resp.setTranTime(dateTimeFormat.format(time));
		resp.setReturnCode(ReturnCode.C000.getCode());
		resp.setReturnMsg(ReturnCode.C000.getMessage());
		resp.setRespData(respData);
		return resp;
	}

	/**
	 * 產生失敗 Response
	 * @param <T>
	 * @param respData
	 * @param returnCode
	 * @return
	 */
	public <T> TranResponse<T> genFailResponse(T respData, ReturnCode returnCode) {

		LocalDateTime time = LocalDateTime.now();

		TranResponse<T> resp = new TranResponse<>();
		resp.setTranTime(dateTimeFormat.format(time));
		resp.setReturnCode(returnCode.getCode());
		resp.setReturnMsg(returnCode.getMessage());
		resp.setRespData(respData);
		return resp;
	}

	/**
	 * 產生失敗 Response
	 * 可客製錯誤訊息
	 * @param <T>
	 * @param respData
	 * @param returnCode
	 * @param e
	 * @return
	 */
	public <T> TranResponse<T> genFailResponseWithMsg(T respData, ReturnCode returnCode, Exception e) {

		LocalDateTime time = LocalDateTime.now();

		TranResponse<T> resp = new TranResponse<>();
		resp.setTranTime(dateTimeFormat.format(time));
		resp.setReturnCode(returnCode.getCode());

		StringBuilder sb = new StringBuilder();
		sb.append(returnCode.getMessage()).append(": ").append(e.getMessage());
		resp.setReturnMsg(sb.toString());

		resp.setRespData(respData);
		return resp;
	}
}
