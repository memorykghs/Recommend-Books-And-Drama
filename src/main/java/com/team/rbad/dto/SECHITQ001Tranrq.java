package com.team.rbad.dto;

import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * SECHITQ001 列表查詢
 * 上行電文
 * @author lijiachi
 */
@Data
public class SECHITQ001Tranrq {

	/** 作品名稱 */
	@JsonProperty("ItemName")
	@Size(max = 100, message = "ItemName長度不可超過100")
	private String itemName;
	

	/** 作者名稱 */
	@JsonProperty("AuthorName")
	@Size(max = 30, message = "AuthorName長度不可超過30")
	private String authorName;

	/** 作品類別 */
	@JsonProperty("Type")
	@Size(max = 7, message = "Type長度不可超過7")
	private String type;

	/** 作品類型 */
	@JsonProperty("Category")
	@Size(max = 7, message = "Category長度不可超過7")
	private String category;
	
	/** 標籤 */
	@JsonProperty("TagList")
	private List<String> tagList;
	
	/** 推薦度 */
	@JsonProperty("Recommend")
	private String recommend;
	
	/** 頁碼 */
	@JsonProperty("PageNumber")
	private int pageNumber;
	
	/** 一頁幾筆 */
	@JsonProperty("PageSize")
	private int pageSize;
	
	
}
