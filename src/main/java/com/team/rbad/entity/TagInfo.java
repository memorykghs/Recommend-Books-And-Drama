package com.team.rbad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "TAG_INFO")
public class TagInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "tag_generator")
    @GenericGenerator(name = "tag_generator", strategy = "com.team.rbad.util.identifier.TagIdentifierGenerator")
    @Column(name = "TAG_ID")
    private String tagId;

    @Column(name = "NAME")
    private String name;

}
