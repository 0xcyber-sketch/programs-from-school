package dk.howards.resource.filters;

import org.jboss.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.Priorities;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Priority(Priorities.AUTHENTICATION)
@Provider
@ConstrainedTo(RuntimeType.SERVER)
public class AuthFilter implements ContainerRequestFilter {
    @Inject
    Logger logger;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authHeader = requestContext.getHeaders().getFirst("authorization");
        logger.info(String.format("Auth header is %s", authHeader));

    }
}
