package com.howard.authentication.integration.userservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.howard.authentication.domain.*;
import com.howard.authentication.domain.exception.BadRequestException;
import com.howard.authentication.domain.exception.DomainException;

import java.util.List;

public class UserIdDTO {
    private final String id;
    private final List<Role> roles;
    private final String userName;

    @JsonCreator
    public UserIdDTO(@JsonProperty("id") String id, @JsonProperty("userName") String userName, @JsonProperty("roles") List<Role> roles) {
        this.id = id;
        this.roles = roles;
        this.userName = userName;
    }
    public String getId() {
        return id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public SecurityInfo toSecurityInfo() {
        try {
            return new SecurityInfo(new Id(id), new UserName(userName), new Roles(roles));
        } catch (DomainException e) {
            throw new BadRequestException(e.getSid(), e.getMessage(), e);
        }
    }
}
