package com.team.rbad.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "AUTHOR_INFO")
public class AuthorInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "author_generator")
    @GenericGenerator(name = "author_generator", strategy = "com.team.rbad.util.identifier.AuthorIdentifierGenerator")
    @Column(name = "AUTHOR_ID")
    private String authorId;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UPD_ID")
    private String updId;

    @Column(name = "UPD_TIME")
    private Timestamp updTime;

}
