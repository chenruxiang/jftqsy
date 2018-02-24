package com.jftshop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product_parameter")
public class ProductParameter extends BaseEntity {


    private String id;
    private String name;
    private Integer orders;
    private String contents;
    private ProductCategory productcategory;


    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotEmpty
    @Length(max=200)
    @Column(nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    @Length(max=300)
    @Column(nullable=false)
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="productcategory")
    @JsonIgnore
    public ProductCategory getProductcategory()
    {
        return this.productcategory;
    }

    public void setProductcategory(ProductCategory productcategory)
    {
        this.productcategory = productcategory;
    }


}
