package com.bts.to_do_list_service.service;

import com.bts.to_do_list_service.exception.custom.BadRequestException;
import com.bts.to_do_list_service.mapper.RegisterMapper;
import com.bts.to_do_list_service.model.User;
import com.bts.to_do_list_service.repository.UserRespository;
import com.bts.to_do_list_service.request.RegisterRequest;
import com.bts.to_do_list_service.response.DataResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserRespository userRespository;

    @SneakyThrows
    public DataResponse<Object> register(RegisterRequest request) {
        try {

            // Validasi Username Sudah Terdaftar
            User dataUser = userRespository.findByUsername(request.getUsername());
            if (dataUser != null){
                throw new BadRequestException("username sudah terdaftar");
            }

            User user = RegisterMapper.INSTANCE.mapToRegister(request);
            String password = request.getPassword();
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
            userRespository.save(user);

            return new DataResponse<>(HttpStatus.OK.value(), "Proses save berhasil", null, null);

        }catch (Exception e){
            throw e;
        }
    }
}
