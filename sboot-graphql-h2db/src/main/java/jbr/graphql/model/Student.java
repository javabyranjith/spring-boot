package jbr.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;
  
  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "dept", nullable = false)
  private String department;

  @ManyToOne
  @JoinColumn(name = "pincode", nullable = false, updatable = false)
  private Address address;

  @Column(name = "phone", nullable = false)
  private Long phone;
}
