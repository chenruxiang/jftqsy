package com.jftshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThinkPad on 2018/2/22.
 */

@Entity
@Table(name="specification")
public class Specification extends BaseEntity {

    protected String id;
    private Integer orders;
    private String memo;
    private String name;
    private Specification.Type type;
    private List<SpecificationValue> specificationValues = new ArrayList();

    public enum Type
    {
        text, image;
    }

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @OneToMany(mappedBy="specification", fetch=FetchType.LAZY , cascade = CascadeType.ALL)
    public List<SpecificationValue> getSpecificationValues() {
        return specificationValues;
    }

    public void setSpecificationValues(List<SpecificationValue> specificationValues) {
        this.specificationValues = specificationValues;
    }

}
