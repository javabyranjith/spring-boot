package jbr.spring.boot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jbr.spring.boot.anno.ServerDetail;
import jbr.spring.boot.service.LoginService;

@Controller
public class LoginController {

  @Autowired
  private LoginService loginSerice;

  @Autowired
  private ServerDetail serverDetail;

  @Value("${hello.message}")
  private String message;

  @RequestMapping("/hello")
  public String hello(Map<String, Object> model) {
    model.put("message", this.message);
    return "hello";
  }

  @RequestMapping("/users")
  public String users(Map<String, Object> model) {
    model.put("users", loginSerice.users());
    return "users";
  }

  @RequestMapping("/environment")
  public String values(Map<String, Object> model) {
    model.put("environment", serverDetail.toString());
    return "environment";
  }
}
