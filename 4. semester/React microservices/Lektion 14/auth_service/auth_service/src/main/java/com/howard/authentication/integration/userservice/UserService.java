package com.howard.authentication.integration.userservice;

import com.howard.authentication.domain.*;
import com.howard.authentication.integration.userservice.dto.CredentialsDTO;
import com.howard.authentication.integration.userservice.dto.UserIdDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class UserService {
    private final UserServiceClient client;
    private final Logger logger;

    @Inject
    public UserService(@RestClient UserServiceClient client, Logger logger) {
        this.client = client;
        this.logger = logger;
    }

    public SecurityInfo validateCredentials(Credential credential, Password password) {
        logger.info("CALLING CLIENT WITH  " + credential.getValue() + password.getValue());
                UserIdDTO dto = client.validateCredentials(new CredentialsDTO(credential.getValue(), password.getValue(), credential instanceof Email));
        logger.info("RESUL CALLING CLIENT WITH  " + dto.toSecurityInfo().getUserId().getRaw() + " " + dto.toSecurityInfo().getRoles().getRolesAsString());
        return dto.toSecurityInfo();
    }
}
