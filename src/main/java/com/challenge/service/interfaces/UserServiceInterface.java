package com.challenge.service.interfaces;

import com.challenge.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface extends ServiceInterface<User> {

    Optional<User> findById(Long userId);

    List<User> findByCompanyId(Long companyId);

    List<User> findByAccelerationName(String name);

}
