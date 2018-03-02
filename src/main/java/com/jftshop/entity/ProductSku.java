package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by ThinkPad on 2018/3/2.
 */

@Entity
@Table(name="product_sku")
public class ProductSku extends BaseEntity {

    private String id;
    private Product product;
    private Integer allocatedstock;
    private String sn;
    private Integer stock;
    private String stockmemo;
    private String productspecificationvalueid1;
    private String productspecificationvalueid2;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="productid")
    @JsonIgnore
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductspecificationvalueid1() {
        return productspecificationvalueid1;
    }

    public void setProductspecificationvalueid1(String productspecificationvalueid1) {
        this.productspecificationvalueid1 = productspecificationvalueid1;
    }

    public String getProductspecificationvalueid2() {
        return productspecificationvalueid2;
    }

    public void setProductspecificationvalueid2(String productspecificationvalueid2) {
        this.productspecificationvalueid2 = productspecificationvalueid2;
    }

    public Integer getAllocatedstock() {
        return allocatedstock;
    }

    public void setAllocatedstock(Integer allocatedstock) {
        this.allocatedstock = allocatedstock;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getStockmemo() {
        return stockmemo;
    }

    public void setStockmemo(String stockmemo) {
        this.stockmemo = stockmemo;
    }
}
