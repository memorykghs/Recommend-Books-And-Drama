package com.team.rbad.dto;

import java.io.Serializable;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * RbadInsIt001Tranrs 新增作品DTO
 * @author memorykghs
 */
@Data
public class INSITEMT001Tranrq implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 封面圖片 */
//	@JsonProperty("ItemName")
//	@NotBlank
//	@Size(max = 100, message = "ItemName長度不可超過100")
//	private String itemName;

	/** 作品名稱 */
	@JsonProperty("ItemName")
	@NotBlank
	@Size(max = 100, message = "ItemName長度不可超過100")
	private String itemName;

	/** 作者ID */
	@JsonProperty("AuthorId")
	@Size(max = 8, message = "AuthorId長度不可超過8")
	private String authorId;

	/** 作者名稱 */
	@JsonProperty("AuthorName")
	@NotBlank
	@Size(max = 30, message = "AuthorName長度不可超過30")
	private String authorName;

	/** 作品類別 */
	@JsonProperty("Type")
	@NotBlank
	@Size(max = 7, message = "Type長度不可超過7")
	private String type;

	/** 作品類型 */
	@JsonProperty("Category")
	@NotBlank
	@Size(max = 7, message = "Category長度不可超過7")
	private String category;

	/** 標籤 */
	@JsonProperty("TagSet")
	@Valid
	private Set<INSITEMT001TranrqTagInfo> tagSet;

	/** 作品描述 */
	@JsonProperty("Description")
	@Size(max = 1000, message = "Description長度不可超過1000")
	private String description;

	/** 使用者ID */
	@JsonProperty("UserId")
	@NotBlank
	@Size(max = 50, message = "UserId長度不可超過50")
	private String userId;
}
