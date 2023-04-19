package com.lange.integration.userservice;


import com.lange.integration.userservice.dto.CredentialsDTO;
import com.lange.integration.userservice.dto.UserIdDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

    @Path("/users/login")
    @RegisterRestClient(configKey = "user-service-api")
    public interface UserServiceClient {

        @POST
        UserIdDTO validateCredentials(CredentialsDTO credentials);

    }

