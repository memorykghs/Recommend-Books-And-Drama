package com.team.rbad.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ItemCommentPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "UPD_TIME")
    private Timestamp updTime;

    @Column(name = "UPD_ID")
    private String updId;

}
