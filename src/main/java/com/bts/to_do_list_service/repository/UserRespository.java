package com.bts.to_do_list_service.repository;

import com.bts.to_do_list_service.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
