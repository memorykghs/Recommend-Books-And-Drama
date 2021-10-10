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
@Table(name = "TYPE_INFO")
public class TypeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "TYPE_SEQ")
    @GenericGenerator(name = "TYPE_SEQ", strategy = "com.team.rbad.util.identifier.TypeIdentifierGenerator")
    @Column(name = "TYPE_ID")
    private String typeId;

    @Column(name = "NAME")
    private String name;

}
