package com.jftshop.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="parameter")
public class Parameter extends BaseEntity {


    private String id;
    private String name;
    private Integer orders;
    private ParameterGroup parametergroup;

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
    @JoinColumn(name="parametergroup")
    @JsonIgnore
    public ParameterGroup getParametergroup()
    {
        return parametergroup;
    }

    public void setParametergroup(ParameterGroup parametergroup)
    {
        this.parametergroup = parametergroup;
    }


}
