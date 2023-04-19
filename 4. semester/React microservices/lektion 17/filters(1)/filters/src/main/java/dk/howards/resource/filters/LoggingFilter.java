package dk.howards.resource.filters;

import org.jboss.logging.Logger;
import org.jboss.resteasy.core.interception.jaxrs.PostMatchContainerRequestContext;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Priority(1)
@Provider
@ConstrainedTo(RuntimeType.SERVER)
public class LoggingFilter implements ContainerRequestFilter {
    @Inject
    Logger logger;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        logger.info(String.format("Filter priority 1: %s called on uri %s", requestContext.getMethod(),
                ((PostMatchContainerRequestContext) requestContext).getHttpRequest().getUri().getAbsolutePath()));
    }
}
