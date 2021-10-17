package com.team.rbad.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 查詢作品類型
 * CATINFOQ001Tranrs
 * @author memorykghs
 */
@Data
public class CATINFOQ001Tranrs implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<CATINFOQ001TranrsCategoryInfo> categorySet;

	
}
