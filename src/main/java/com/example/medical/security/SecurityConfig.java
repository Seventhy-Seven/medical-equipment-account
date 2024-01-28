package com.example.medical.security;

import com.example.medical.model.User;
import com.example.medical.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
        List<User> users = userRepository.findAll();
        String hashPassword = passwordEncoder.encode("123456");

        users.forEach(u -> {
            u.setPassword(hashPassword);
            switch (u.getPosition()) {
                case "администратор" -> u.setRole(User.Role.ADMIN);
                case "инженер" -> u.setRole(User.Role.ENGINEER);
                case "пользователь" -> u.setRole(User.Role.USER);
            }
            userRepository.save(u);
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/index").authenticated()
                .antMatchers("/equip").authenticated()
                .antMatchers("/equip_repair").authenticated()
                .antMatchers("/").permitAll()
                .and()
                .formLogin()
                .loginPage("/")
                .usernameParameter("position")
                .passwordParameter("password")
                .defaultSuccessUrl("/index")
                .permitAll();
    }
}
