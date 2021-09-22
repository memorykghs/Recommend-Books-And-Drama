package com.team.rbad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "RECOMMEND")
@IdClass(value = RecommendPK.class)
@Data
public class Recommend implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ITEM_ID")
	private String itemId;
	
	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "RECOMMEND")
    private float recommend;

}
