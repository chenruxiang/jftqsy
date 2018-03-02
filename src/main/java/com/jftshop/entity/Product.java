package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Entity
@Table(name = "product")
public class Product extends  BaseEntity {

    private String id;
    private String image;
    private String introduction;
    private Boolean isgift;
    private Boolean islist;
    private Boolean ismarketable;
    private Boolean istop;
    private String name;
    private BigDecimal price;
    private ProductCategory productcategory;
    private List<ProductImage> productimages = new ArrayList();
    private List<ProductParameter> productparameters = new ArrayList();
    private List<ProductAttribute> productattributes = new ArrayList();
    private List<ProductSpecification> productspecifications = new ArrayList();
    private List<ProductSku> productskus = new ArrayList();

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Boolean getIsgift() {
        return isgift;
    }

    public void setIsgift(Boolean isgift) {
        this.isgift = isgift;
    }

    public Boolean getIslist() {
        return islist;
    }

    public void setIslist(Boolean islist) {
        this.islist = islist;
    }

    public Boolean getIsmarketable() {
        return ismarketable;
    }

    public void setIsmarketable(Boolean ismarketable) {
        this.ismarketable = ismarketable;
    }

    public Boolean getIstop() {
        return istop;
    }

    public void setIstop(Boolean istop) {
        this.istop = istop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productcategoryid")
    @JsonIgnore
    public ProductCategory getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(ProductCategory productcategory) {
        this.productcategory = productcategory;
    }

    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    public List<ProductImage> getProductimages() {
        return productimages;
    }

    public void setProductimages(List<ProductImage> productimages) {
        this.productimages = productimages;
    }

    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    public List<ProductParameter> getProductparameters() {
        return productparameters;
    }

    public void setProductparameters(List<ProductParameter> productparameters) {
        this.productparameters = productparameters;
    }

    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    public List<ProductAttribute> getProductattributes() {
        return productattributes;
    }

    public void setProductattributes(List<ProductAttribute> productattributes) {
        this.productattributes = productattributes;
    }

    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    public List<ProductSku> getProductskus() {
        return productskus;
    }

    public void setProductskus(List<ProductSku> productskus) {
        this.productskus = productskus;
    }


    @OneToMany(mappedBy = "product",fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    public List<ProductSpecification> getProductspecifications() {
        return productspecifications;
    }

    public void setProductspecifications(List<ProductSpecification> productspecifications) {
        this.productspecifications = productspecifications;
    }

}
