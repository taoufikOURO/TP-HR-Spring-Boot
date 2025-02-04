package com.taoufik.hrassociation.services.user;

import java.util.List;

import com.taoufik.hrassociation.models.User;

public interface IUserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
}
