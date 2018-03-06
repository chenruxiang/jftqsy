package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThinkPad on 2018/3/2.
 */

@Entity
@Table(name="product_specification")
public class ProductSpecification extends BaseEntity {

    private String id;
    private Integer orders;
    private String memo;
    private String name;
    private ProductSpecification.Type type;
    private Product product;
    private List<ProductSpecificationValue> productspecificationvalues = new ArrayList();

    public enum Type
    {
        text, image;
    }

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductSpecification.Type getType() {
        return type;
    }

    public void setType(ProductSpecification.Type type) {
        this.type = type;
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

    @OneToMany(mappedBy="productspecification", fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    public List<ProductSpecificationValue> getProductspecificationvalues() {
        return productspecificationvalues;
    }

    public void setProductspecificationvalues(List<ProductSpecificationValue> productspecificationvalues) {
        this.productspecificationvalues = productspecificationvalues;
    }


}
