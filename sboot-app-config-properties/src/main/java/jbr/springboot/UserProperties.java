package jbr.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@PropertySource("classpath:users.properties")
@ConfigurationProperties("myuser")
@Setter
@Getter
public class UserProperties {
  private String firstname;
  private String lastname;
  private String nickname;
  private Address address;
  private List<String> cars = new ArrayList<>();
  private Map<String, String> phone = new HashMap<>();

  @Setter
  @Getter
  public static class Address {
    private Integer doorno;
    private String street;
    private String state;
    private String country;
    private String pincode;
  }
}
