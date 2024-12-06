package com.bts.to_do_list_service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DataResponse<T> {

    int statusCode ;
    String message ;
    String errorMessage ;
    T data;

}
