package com.jftshop.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;
@Entity
@Table(name="brand")
public class Brand extends BaseEntity
{

  private String id;
  private String name;
  private String logo;
  private String orders ;
  private String url;
  private Set<ProductCategory> productcategory = new HashSet();

  @Id
  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
  @Length(max=200)
  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }


  @Length(max=200)
  public String getLogo()
  {
    return this.logo;
  }

  public void setLogo(String logo)
  {
    this.logo = logo;
  }

  @Length(max=200)
  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  @Length(max=200)
  public String getOrders()
  {
    return this.orders;
  }

  public void setOrders(String orders)
  {
    this.orders = orders;
  }


}

