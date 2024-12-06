package com.bts.to_do_list_service.controller;

import com.bts.to_do_list_service.request.RegisterRequest;
import com.bts.to_do_list_service.response.DataResponse;
import com.bts.to_do_list_service.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public ResponseEntity<DataResponse<Object>> createCategory(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(registerService.register(request));
    }
}
