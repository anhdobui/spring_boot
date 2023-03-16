package com.buianhdo.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "artwork")
public class ArtworkEntity extends BaseEntity {
    @Column(name="name")
    private String name;

    @Column(name="thumbnail")
    private String thumbnail;

    @Column(name="album")
    private String album;

    @Column(name="price")
    private String price;

    @Column(name="width")
    private String width;

    @Column(name="height")
    private String height;

    @Column(name="deep")
    private String deep;

    @ManyToOne
    @JoinColumn(name="category_id")
    private CategoryEntity category;
}
