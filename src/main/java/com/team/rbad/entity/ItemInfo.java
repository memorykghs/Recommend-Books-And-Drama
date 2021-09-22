package com.team.rbad.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.rbad.util.ItemIdSeqGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "BOOK_INFO")
public class ItemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "itemInfo")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ItemComment> bookComments;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
    @GenericGenerator(name = "ITEM_SEQ", strategy = "com.team.rbad.util.ItemIdSeqGenerator", parameters = {
            @Parameter(name = ItemIdSeqGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = ItemIdSeqGenerator.VALUE_PREFIX_PARAMETER, value = "I"),
            @Parameter(name = ItemIdSeqGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
    @Column(name = "ITEM_ID")
    private String itemId;

    @Column(name = "AUTHOR_ID")
    private String authorId;
    
    @Column(name = "TYPE")
    private String type;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "TAG")
    private String tag;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RECOMMEND")
    private float recommend;

    @Column(name = "UPD_ID")
    private String updId;

    @Column(name = "UPD_TIME")
    private Timestamp updTime;
}
