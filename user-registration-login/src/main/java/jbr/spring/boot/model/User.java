package jbr.spring.boot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  private String username;
  private String password;
  private String firstname;
  private String lastname;
  private String email;
  private String address;
  private int phone;
}
