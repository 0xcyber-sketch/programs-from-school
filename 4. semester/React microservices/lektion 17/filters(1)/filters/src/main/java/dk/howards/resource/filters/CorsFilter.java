package dk.howards.resource.filters;

import javax.annotation.Priority;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(1)
@ConstrainedTo(RuntimeType.SERVER)
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().addAll("Access-Control-Allow-Headers", "content-type", "Authorization");
        responseContext.getHeaders().addAll("Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().addAll("Access-Control-Allow-Origin", "http://localhost:3000");
        responseContext.getHeaders().addAll("Access-Control-Allow-Methods", "POST,GET,OPTION,PATCH,PUT");


    }
}
