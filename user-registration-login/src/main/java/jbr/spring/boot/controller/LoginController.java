package jbr.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jbr.spring.boot.model.Login;
import jbr.spring.boot.model.User;
import jbr.spring.boot.service.UserService;

@Controller
public class LoginController {

  @Autowired
  public UserService userService;

  @PostMapping(value = "/loginProcess")
  public String login(@ModelAttribute("login") Login login, BindingResult bindingResult, ModelMap model) {

    User user = userService.validateUser(login);

    boolean isValidUser = false;

    if (null != user && user.getUsername().equals(login.getUsername())
        && user.getPassword().equals(login.getPassword())) {
      isValidUser = true;
      model.addAttribute("username", user.getUsername());
    }

    return isValidUser ? "welcome" : "login";
  }
}
