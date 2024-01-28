package com.example.medical.security;

import com.example.medical.model.User;
import com.example.medical.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String position) throws UsernameNotFoundException {
        User user = userRepository.findByPosition(position);
        return new UserDetailsImpl(user);
    }
}
