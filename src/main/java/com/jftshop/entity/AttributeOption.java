package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by ThinkPad on 2018/2/6.
 */

@Entity
@Table(name = "attribute_option")
public class AttributeOption extends  BaseEntity {

    private String id;
    private String options;
    private Attribute attribute;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="attributeid")
    @JsonIgnore
    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
