package com.team.rbad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * SECHITQ001 列表查詢
 * 下行電文
 * @author lijiachi
 */
@Data
public class SECHITQ001TranrsItemList {
	
	/** 作品ID */
	@JsonProperty("ItemId")
	private String ItemId;
	
	/** 作品名稱 */
	@JsonProperty("ItemName")
	private String itemName;
	
	/** 作者ID */
	@JsonProperty("AuthorId")
	private String authorId;
	
	/** 作品描述 */
	@JsonProperty("Description")
    private String description;

	/** 作者名稱 */
	@JsonProperty("AuthorName")
	private String authorName;

	/** 作品類別 */
	@JsonProperty("Type")
	private String type;

	/** 作品類型 */
	@JsonProperty("Category")
	private String category;
	
	/** 推薦度 */
	@JsonProperty("Recommend")
	private String recommend;
	
}
