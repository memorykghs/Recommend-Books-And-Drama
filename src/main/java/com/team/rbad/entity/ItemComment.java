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
@Table(name = "ITEM_COMMENT")
@IdClass(value = ItemCommentPK.class)
public class ItemComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UPD_TIME")
    private Timestamp updTime;

    @Id
    @Column(name = "UPD_ID")
    private String updId;
    
    @Column(name = "ITEM_ID")
    private String itemId;

    @Column(name = "COMMENTS")
    private String comments;
}
