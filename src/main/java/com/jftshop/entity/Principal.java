package com.jftshop.entity;

import java.io.Serializable;

public class Principal
  implements Serializable
{
  private static final long serialVersionUID = 5798882004228239559L;
  private String id;
  private String username;

  public Principal(String id, String username)
  {
    this.id = id;
    this.username = username;
  }

  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String toString()
  {
    return this.username;
  }
}

