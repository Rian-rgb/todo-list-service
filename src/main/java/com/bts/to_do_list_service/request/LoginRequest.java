package com.bts.to_do_list_service.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotNull(message = "Username tidak boleh kosong")
    private String username;

    @NotNull(message = "Password tidak boleh kosong")
    private String password;
}
