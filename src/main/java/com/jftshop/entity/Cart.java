package com.jftshop.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ThinkPad on 2018/3/6.
 */
@Entity
@Table(name="cart")
public class Cart extends BaseEntity {

    protected String id;
    protected String cartkey;
    private Member member;
    private Set<CartItem> cartItems = new HashSet();

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCartkey() {
        return cartkey;
    }

    public void setCartkey(String cartkey) {
        this.cartkey = cartkey;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="memberid")
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    @OneToMany(mappedBy="cart", fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Transient
    public boolean contains(Product product)
    {
        if ((product != null) && (getCartItems() != null))
        {
            Iterator localIterator = getCartItems().iterator();
            while (localIterator.hasNext())
            {
                CartItem localCartItem = (CartItem)localIterator.next();
                if ((localCartItem != null) && (localCartItem.getProduct() == product))
                    return true;
            }
        }
        return false;
    }

    @Transient
    public CartItem getCartItem(Product product)
    {
        if ((product != null) && (getCartItems() != null))
        {
            Iterator localIterator = getCartItems().iterator();
            while (localIterator.hasNext())
            {
                CartItem localCartItem = (CartItem)localIterator.next();
                if ((localCartItem != null) && (localCartItem.getProduct() == product))
                    return localCartItem;
            }
        }
        return null;
    }

}
