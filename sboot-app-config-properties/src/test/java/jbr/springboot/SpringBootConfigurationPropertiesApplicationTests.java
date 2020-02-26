package jbr.springboot;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpringBootConfigurationPropertiesApplicationTests {

  @Value("${myuser.firstname}")
  private String firstname;

  @Value("${myuser.lastname}")
  private String lastname;
//
//  @Value("#{'${myuser.nickname}'.split(',')}")
//  private List<String> nickname;

  /*
   * @Value("${myuser.cars}") private List<String> cars;
   * 
   * @Value("${myuser.phone}") private Map<String, Integer> phone;
   * 
   * @Value("${ myuser.address}") private Address address;
   */

  @Test
  public void contextLoads() {
  }

  @Test
  public void testUsers() {
    Assert.assertEquals("Ranjith", firstname);
    Assert.assertEquals("Sekar", lastname);
    // System.out.println("address: " + address.getCountry());
  }

}
