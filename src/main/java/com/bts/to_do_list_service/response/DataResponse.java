package com.bts.to_do_list_service.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DataResponse<T> {

    int statusCode ;
    String message ;
    String errorMessage ;
    T data;

}
