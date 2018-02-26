package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Created by ThinkPad on 2018/2/23.
 */

@Entity
@Table(name = "product_product_image")
public class ProductImage extends  BaseEntity {

    private String id;
    private String large;
    private String medium;
    private Integer orders;
    private String source;
    private String thumbnail;
    private String title;
    private Product product;
    private MultipartFile file;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productid")
    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Transient
    public MultipartFile getFile()
    {
        return this.file;
    }

    public void setFile(MultipartFile file)
    {
        this.file = file;
    }


}
