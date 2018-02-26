package com.jftshop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ThinkPad on 2018/2/26.
 */

@Entity
@Table(name = "goods")
public class Goods extends  BaseEntity {

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
