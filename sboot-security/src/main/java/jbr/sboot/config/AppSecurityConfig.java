package jbr.sboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import jbr.sboot.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AppUserDetailsService appUserDetailsService;

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(appUserDetailsService);
    authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

    return authenticationProvider;
  }

  /*
   * @Bean
   * 
   * @Override protected UserDetailsService userDetailsService() { List<UserDetails> users = new ArrayList<>();
   * users.add(User.withDefaultPasswordEncoder() .username("ranjith") .password("sekar") .roles("USER") .build());
   * return new InMemoryUserDetailsManager(users); }
   */
}
