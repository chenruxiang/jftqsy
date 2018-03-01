package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ThinkPad on 2018/2/26.
 */

@Entity
@Table(name = "goods")
public class Goods extends  BaseEntity {

    private String id;
    private Set<Product> products = new HashSet();

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OneToMany(mappedBy="goods", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
