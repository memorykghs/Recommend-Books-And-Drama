package com.team.rbad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ITEM_TAG")
@IdClass(value = ItemTagPK.class)
public class ItemTag implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	private ItemInfo itemInfo;

	@Id
	@Column(name = "TAG_ID")
	private String tagId;

}
