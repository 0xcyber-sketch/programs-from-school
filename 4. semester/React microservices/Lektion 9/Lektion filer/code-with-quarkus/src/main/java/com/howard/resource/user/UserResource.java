package com.howard.resource.user;

import com.howard.resource.login.dto.ProfileDTO;
import com.howard.resource.login.dto.UpdateProfileDTO;
import com.howard.resource.login.dto.UserDTO;
import com.howard.service.UserService;
import com.howard.service.request.GetUserRequest;
import com.howard.service.request.UpdateProfileRequest;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class UserResource {
    private final UserService userService;
    private final JsonWebToken jwt;

    @Inject
    public UserResource(UserService userService, JsonWebToken jwt) {
        this.userService = userService;
        this.jwt = jwt;
    }

    @Path("/users/{id}")
    @GET
    @RolesAllowed({"USER"})
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("id") String id) {
        return new UserDTO(userService.get(new GetUserRequest(id)));
    }


    @Path("/profile")
    @PUT
    @RolesAllowed({"USER"})
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO updateProfile(UpdateProfileDTO updateProfileDTO) {
        UpdateProfileRequest request = new UpdateProfileRequest(jwt.getSubject(), updateProfileDTO);
        return new UserDTO(userService.updateUserProfile(request).getUser());
    }

    @Path("/profile")
    @GET
    @RolesAllowed({"USER"})
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileDTO getProfile() {
        return new ProfileDTO(userService.get(new GetUserRequest(jwt.getSubject())));

    }

}
