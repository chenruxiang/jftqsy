package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by ThinkPad on 2018/3/6.
 */

@Entity
@Table(name="cart_item")
public class CartItem extends BaseEntity {

    protected String id;
    protected Integer quantity;
    protected Cart cart;
    protected ProductSku productsku;
    protected Product product;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cartid")
    @JsonIgnore
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productskuid")
    @JsonIgnore
    public ProductSku getProductsku() {
        return productsku;
    }

    public void setProductsku(ProductSku productsku) {
        this.productsku = productsku;
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
}
