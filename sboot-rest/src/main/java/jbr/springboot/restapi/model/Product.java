package jbr.springboot.restapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product Model.
 * 
 * @author Ranjith Sekar
 * @since 2018, Jun 20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

  @Id
  private String id;
  private String name;
  private String category;
  private String price;
}
