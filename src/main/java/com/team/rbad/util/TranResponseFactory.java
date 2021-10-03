package com.team.rbad.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.team.rbad.base.TranResponse;

/**
 * TranResponse Factory
 * @author memroykghs
 */
@Component
public class TranResponseFactory {
	
	/** DateTimeFormat */
	private static final DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmsss");

	/**
	 * 產生成功 Response
	 * 
	 * @param <T>
	 * @return
	 */
	public <T> TranResponse<T> genSucessResponse(T respData) {
		
		LocalDateTime time = LocalDateTime.now();

		TranResponse<T> resp = new TranResponse<>();
		resp.setTranTime(dateTimeFormat.format(time));
		resp.setReturnCode("Code001");
		resp.setReturnMsg("交易成功");
		resp.setRespData(respData);
		return resp;
	}
}
