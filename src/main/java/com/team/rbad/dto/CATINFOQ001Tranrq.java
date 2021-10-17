package com.team.rbad.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 查詢作品類型
 * CATINFOQ001Tranrq
 * @author memorykghs
 */
@Data
public class CATINFOQ001Tranrq implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String categoryId;
	
	private String name;

}
