package com.howard.authentication.integration.userservice;

import com.howard.authentication.integration.userservice.dto.CredentialsDTO;
import com.howard.authentication.integration.userservice.dto.UserIdDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/users/login")
@RegisterRestClient(configKey = "user-service-api")
@RegisterClientHeaders(UserServiceClientHeadersFactory.class)
public interface UserServiceClient {

    @POST
    UserIdDTO validateCredentials(CredentialsDTO credentials);

}
