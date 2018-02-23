package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by ThinkPad on 2018/2/23.
 */

@Entity
@Table(name = "product_parameter_value")
public class ProductParameter extends  BaseEntity {

    private String id;
    private Product product;
    private String parametervalue;
    private String parametervaluekey;

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

    public String getParametervalue() {
        return parametervalue;
    }

    public void setParametervalue(String parametervalue) {
        this.parametervalue = parametervalue;
    }

    public String getParametervaluekey() {
        return parametervaluekey;
    }

    public void setParametervaluekey(String parametervaluekey) {
        this.parametervaluekey = parametervaluekey;
    }
}
