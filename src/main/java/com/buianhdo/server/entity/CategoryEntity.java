package com.buianhdo.server.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    
    @Column(name="name")
    private String name;

    @Column(name="code")
    private String code;

    @Column(name = "shortdescription")
    private String shortDescription;

    @Column(name="content")
    private String content;

    @OneToMany(mappedBy = "category")
    private List<ArtworkEntity> artworks = new ArrayList<>();

}
