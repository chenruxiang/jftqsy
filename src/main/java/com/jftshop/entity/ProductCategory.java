package com.jftshop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String seotitle;
    private String seokeywords;
    private String seodescription;
    private String treepath;
    private Integer grade;
    private Integer orders;
    private ProductCategory parent;
    private Set<ProductCategory> children = new HashSet();
    //private Set<ParameterGroup> IIlIIllI = new HashSet();
    private Set<Attribute> attributes = new HashSet();
    private Set<ParameterGroup> parametergroups = new HashSet();
    private Set<Product>  products =  new HashSet();

    public ProductCategory(){
        super();
    }


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
    public String getSeotitle() {
        return seotitle;
    }

    public void setSeotitle(String seoTitle) {
        this.seotitle = seotitle;
    }

    @Length(max=200)
    public String getSeokeywords() {
        return seokeywords;
    }

    public void setSeokeywords(String seokeywords) {
        this.seokeywords = seokeywords;
    }

    public String getSeodescription() {
        return seodescription;
    }

    public void setSeodescription(String seodescription) {
        this.seodescription = seodescription;
    }

    public String getTreepath() {
        return treepath;
    }

    public void setTreepath(String treepath) {
        this.treepath = treepath;
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
    @JsonIgnore
    public ProductCategory getParent()
    {
        return this.parent;
    }

    public void setParent(ProductCategory parent)
    {
        this.parent = parent;
    }


    @OneToMany(mappedBy="parent", fetch=FetchType.LAZY)
    @JsonIgnore
    public Set<ProductCategory> getChildren()
    {
        return this.children;
    }

    public void setChildren(Set<ProductCategory> children)
    {
        this.children = children;
    }

    @OneToMany(mappedBy="productcategory", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<ParameterGroup> getParametergroups()
    {
        return this.parametergroups;
    }

    public void setParametergroups(Set<ParameterGroup> parametergroups)
    {
        this.parametergroups = parametergroups;
    }

    @OneToMany(mappedBy="productcategory", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Attribute> getAttributes()
    {
        return this.attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }


    @OneToMany(mappedBy="productcategory", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
