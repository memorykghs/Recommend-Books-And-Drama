package com.team.rbad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.team.rbad.util.DefaultIdSeqGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORY_INFO")
public class CategoryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAT_SEQ")
    @GenericGenerator(name = "CAT_SEQ", strategy = "com.team.rbad.util.DefaultIdSeqGenerator", parameters = {
            @Parameter(name = DefaultIdSeqGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = DefaultIdSeqGenerator.VALUE_PREFIX_PARAMETER, value = "C"),
            @Parameter(name = DefaultIdSeqGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @Column(name = "CATEGORY_ID")
    private String categoryId;

    @Column(name = "MAIN_NAME")
    private String mainName;
    
    @Column(name = "SUB_NAME")
    private String subName;

}
