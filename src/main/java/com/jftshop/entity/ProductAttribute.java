package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by ThinkPad on 2018/2/28.
 */

@Entity
@Table(name = "product_attribute_value")
public class ProductAttribute extends  BaseEntity {

    private String id;
    private Product product;
    private String attributevalue;
    private String attributevaluekey;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAttributevalue() {
        return attributevalue;
    }

    public void setAttributevalue(String attributevalue) {
        this.attributevalue = attributevalue;
    }

    public String getAttributevaluekey() {
        return attributevaluekey;
    }

    public void setAttributevaluekey(String attributevaluekey) {
        this.attributevaluekey = attributevaluekey;
    }
}
