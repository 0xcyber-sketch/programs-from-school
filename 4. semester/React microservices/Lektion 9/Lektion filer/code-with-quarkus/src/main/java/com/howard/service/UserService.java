package com.howard.service;

import com.howard.domain.User;
import com.howard.repository.Repository;
import com.howard.service.request.GetUserRequest;
import com.howard.service.request.UpdateProfileRequest;
import com.howard.service.response.UserResponse;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Dependent
@Transactional
public class UserService {
    private final Repository repository;

    @Inject
    public UserService(Repository repository) {
        this.repository = repository;
    }

    public User get(GetUserRequest request) {
        return repository.getUser(request.getId());
    }

    public UserResponse updateUserProfile(UpdateProfileRequest request) {
        return new UserResponse(repository.updateUserName(
                request.getId(),
                request.getUserName(),
                request.getEmail(),
                request.getName(),
                request.getGender()));
    }
}
