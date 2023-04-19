package com.howard.resource.scope;

import com.howard.service.scope.ScopeService;
import com.howard.service.scope.ScopeServiceNoProxy;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/scopes")
@RequestScoped
public class ScopeResource {

    ScopeService service;
    ScopeServiceNoProxy serviceNoProxy;

    @Inject
    public ScopeResource(ScopeService service,ScopeServiceNoProxy serviceNoProxy) {
        this.service = service;
        this.serviceNoProxy=serviceNoProxy;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getScope() {
        return Arrays.asList(this.toString(),service.getScope(),serviceNoProxy.getScope());
    }
}
