package com.jftshop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "attribute")
public class Attribute extends  BaseEntity {

    private String id;
    private Integer orders;
    private String name;
    private Integer propertyindex;
    private ProductCategory productcategory;
    private Set<AttributeOption> attributeOptions = new HashSet();

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

    @ManyToOne(fetch=FetchType.LAZY)
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


    @OneToMany(mappedBy="attribute", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonIgnore
    public Set<AttributeOption> getAttributeOptions()
    {
        return this.attributeOptions;
    }

    public void setAttributeOptions(Set<AttributeOption> attributeOptions)
    {
        this.attributeOptions = attributeOptions;
    }

    public void addAttributeOption(AttributeOption attributeOption)
    {
        this.attributeOptions.add( attributeOption );
    }

}
