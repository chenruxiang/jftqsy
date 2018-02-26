package com.jftshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/22 0022.
 */
@Entity
@Table(name="parameter_group")
public class ParameterGroup extends BaseEntity {

    private String id;
    private String name;
    private Integer orders;
    private ProductCategory productcategory;
    private List<Parameter> parameters = new ArrayList<Parameter>();

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

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="productcategory")
    @JsonIgnore
    public ProductCategory getProductcategory() {
        return productcategory;
    }

    public void setProductcategory(ProductCategory productcategory) {
        this.productcategory = productcategory;
    }

    @OneToMany(mappedBy="parametergroup", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    public List<Parameter> getParameters() {
        return this.parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}
