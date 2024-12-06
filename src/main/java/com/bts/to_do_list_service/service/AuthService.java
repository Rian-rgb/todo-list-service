package com.bts.to_do_list_service.service;

import com.bts.to_do_list_service.request.LoginRequest;
import com.bts.to_do_list_service.response.DataResponse;
import com.bts.to_do_list_service.response.auth.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailsService myUserDetailsService;


    public DataResponse<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(myUserDetailsService.loadUserByUsername(request.getUsername()));
            LoginResponse loginResponse = LoginResponse.builder().token(token).build();
            return new DataResponse<>(HttpStatus.OK.value(), "Proses view detail berhasil", null, loginResponse);
        }

        throw new UsernameNotFoundException("Invalid user");
    }
}
