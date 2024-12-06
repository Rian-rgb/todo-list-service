package com.bts.to_do_list_service.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class RegisterRequest {

    @Email(message = "Email invalid")
    private String email;
    private String password;
    private String username;

}
