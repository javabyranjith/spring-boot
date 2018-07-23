package jbr.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:users.properties")
@ConfigurationProperties("myuser")
public class UserProperties {
  /**
   * User's First Name
   */
  private String firstname;

  /**
   * User's Last Name
   */
  private String lastname;

  private String nickname;

  private Address address;
  private List<String> cars = new ArrayList<>();
  private Map<String, String> phone = new HashMap<>();

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<String> getCars() {
    return cars;
  }

  public void setCars(List<String> cars) {
    this.cars = cars;
  }

  public Map<String, String> getPhone() {
    return phone;
  }

  public void setPhone(Map<String, String> phone) {
    this.phone = phone;
  }

  public static class Address {
    private Integer doorno;
    private String street;
    private String state;
    private String country;
    private String pincode;

    public Integer getDoorno() {
      return doorno;
    }

    public void setDoorno(Integer doorno) {
      this.doorno = doorno;
    }

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public String getPincode() {
      return pincode;
    }

    public void setPincode(String pincode) {
      this.pincode = pincode;
    }

  }

}
