package com.bts.to_do_list_service.service;

import com.bts.to_do_list_service.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.bts.to_do_list_service.entity.User user = userRespository.findByUsername(username);
        if (username == null || !username.equals(user.getUsername())) {
            throw new UsernameNotFoundException("Invalid user");
        }

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
