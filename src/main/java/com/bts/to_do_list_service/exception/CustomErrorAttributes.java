package com.bts.to_do_list_service.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("statusCode", errorAttributes.get("status"));
        errorAttributes.put("message", "Validation Error");
        errorAttributes.put("errorMessage", errorAttributes.get("body.errorMessage"));
        errorAttributes.put("data", null);
        errorAttributes.remove("status");
        errorAttributes.remove("locale");
        errorAttributes.remove("error");
        errorAttributes.remove("path");
        errorAttributes.remove("cause");
        errorAttributes.remove("trace");
        errorAttributes.remove("timestamp");

        return errorAttributes;
    }
}
