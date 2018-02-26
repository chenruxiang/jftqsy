package com.jftshop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "attribute")
public class Attribute extends  BaseEntity {

    private String id;
    private Integer orders;
    private String name;
    private Integer propertyindex;
    private ProductCategory productcategory;
    private List<AttributeOption> attributeoptions = new ArrayList();


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPropertyindex() {
        return propertyindex;
    }

    public void setPropertyindex(Integer propertyindex) {
        this.propertyindex = propertyindex;
    }

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="productcategory")
    public ProductCategory getProductcategory()
    {
        return this.productcategory;
    }

    public void setProductcategory(ProductCategory productcategory)
    {
        this.productcategory = productcategory;
    }


    @OneToMany(mappedBy="attribute", fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    public List<AttributeOption> getAttributeoptions() {
        return attributeoptions;
    }

    public void setAttributeoptions(List<AttributeOption> attributeoptions) {
        this.attributeoptions = attributeoptions;
    }

}
