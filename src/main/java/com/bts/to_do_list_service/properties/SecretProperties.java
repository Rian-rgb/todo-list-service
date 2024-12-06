package com.bts.to_do_list_service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:secret.properties")
@ConfigurationProperties(prefix = "todolist")
public class SecretProperties {

    private String jwtIss;
    private String jwtSecretKey;

}
