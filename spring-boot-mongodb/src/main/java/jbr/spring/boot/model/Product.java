package jbr.spring.boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {

  @Id
  private String id;
  private String name;
  private String type;
  private String price;

  public Product() {

  }

  public Product(String id, String name, String type, String price) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "id:" + this.id + " | name: " + this.name + " | type: " + this.type + " | price: " + this.price;
  }

}
