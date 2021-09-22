package com.team.rbad.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name = "BOOK_COMMENT")
@IdClass(value = ItemCommentPK.class)
public class ItemComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
    private ItemInfo itemInfo;

    @Id
    @Column(name = "UPD_TIME")
    private Timestamp updTime;

    @Id
    @Column(name = "UPD_ID")
    private String updId;

    @Column(name = "COMMENTS")
    private String comments;
}
