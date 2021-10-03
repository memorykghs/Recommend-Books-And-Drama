package com.team.rbad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ItemTagPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ITEM_ID")
	private String itemId;

	@Column(name = "TAG_ID")
	private String tagId;

}
