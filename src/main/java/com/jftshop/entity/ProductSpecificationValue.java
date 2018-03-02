package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by ThinkPad on 2018/3/2.
 */

@Entity
@Table(name="product_specification_value")
public class ProductSpecificationValue  extends BaseEntity {

    private String id;
    private Integer orders;
    private String image;
    private String name;
    private ProductSpecification productspecification;



    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productspecificationid")
    @JsonIgnore
    public ProductSpecification getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(ProductSpecification productspecification) {
        this.productspecification = productspecification;
    }
}
