package com.jftshop.entity;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product_category")
public class ProductCategory  extends  BaseEntity  {


    private String id;
    private String name;
    private String seoTitle;
    private String seoKeywords;
    private String seoDescription;
    private String treePath;
    private Integer grade;
    private Integer orders;
    private ProductCategory parent;
    private Set<ProductCategory> children = new HashSet();


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

    @Length(max=200)
    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    @Length(max=200)
    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getTreePath() {
        return treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="parent")
    public ProductCategory getParent()
    {
        return this.parent;
    }

    public void setParent(ProductCategory parent)
    {
        this.parent = parent;
    }


    @OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
    public Set<ProductCategory> getChildren()
    {
        return this.children;
    }

    public void setChildren(Set<ProductCategory> children)
    {
        this.children = children;
    }



}
