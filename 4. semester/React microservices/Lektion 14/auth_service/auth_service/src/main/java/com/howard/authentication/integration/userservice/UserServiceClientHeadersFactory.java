package com.howard.authentication.integration.userservice;

import com.howard.authentication.domain.*;
import com.howard.authentication.domain.exception.DomainException;
import com.howard.authentication.domain.exception.ProgrammingException;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import java.util.UUID;

@ApplicationScoped
public class UserServiceClientHeadersFactory implements ClientHeadersFactory {

    private static Id id = new Id(UUID.randomUUID());
    @Inject
    Logger logger;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {
        try {
            JWTToken token = new JWTToken(new SecurityInfo(id, new UserName("AUTH_SERVICE"), Roles.API_ROLES));
            logger.info("INCOMMING HEADERS" + incomingHeaders);
            clientOutgoingHeaders.add("Cookie", String.format("jwt=%s", token.getToken()));
            logger.info("CLIENT OUTGOING HEADERS" + clientOutgoingHeaders);
            return clientOutgoingHeaders;
        } catch (DomainException e) {
            throw new ProgrammingException(e.getSid(), e.getMessage(), e);
        }
    }
}
