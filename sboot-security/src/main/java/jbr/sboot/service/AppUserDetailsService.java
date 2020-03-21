package jbr.sboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jbr.sboot.model.AppUser;
import jbr.sboot.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser user = userRepository.findByUsername(username);

    if (null == user) throw new UsernameNotFoundException("User not found!!!");

    return new AppUserDetails(user);
  }

}
