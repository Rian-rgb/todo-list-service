package com.bts.to_do_list_service.mapper;

import com.bts.to_do_list_service.model.User;
import com.bts.to_do_list_service.request.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterMapper {

    RegisterMapper INSTANCE = Mappers.getMapper(RegisterMapper.class);

    User mapToRegister(RegisterRequest registerRequest);
}
