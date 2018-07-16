package jbr.spring.boot.service;

import org.springframework.stereotype.Service;

import jbr.spring.boot.model.Login;
import jbr.spring.boot.model.User;

@Service
public interface UserService {

  void addUser(User user);

  User validateUser(Login login);
}
