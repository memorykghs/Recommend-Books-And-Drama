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
@Table(name = "CATEGORY_INFO")
public class CategoryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "cat_generator")
    @GenericGenerator(name = "cat_generator", strategy = "spring.batch.springBatchPractice.util.CategoryIdentifierGenerator")
    @Column(name = "CATEGORY_ID")
    private String categoryId;

    @Column(name = "NAME")
    private String name;
}
