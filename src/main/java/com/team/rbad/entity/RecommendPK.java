package com.team.rbad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class RecommendPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ITEM_ID")
	private String itemId;

	@Column(name = "USER_ID")
	private String userId;
}
