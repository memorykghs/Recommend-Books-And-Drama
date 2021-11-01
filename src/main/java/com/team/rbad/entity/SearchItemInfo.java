package com.team.rbad.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SearchItemInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ITEM_ID")
	private String itemId;

	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "AUTHOR_ID")
	private String authorId;

	@Column(name = "AUTHOR_NAME")
	private String authorName;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "UPD_ID")
	private String updId;

	@Column(name = "UPD_TIME")
	private Timestamp updTime;

	@Column(name = "RECOMMEND")
	private String recommend;

	private String count;
}
