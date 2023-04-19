package com.howard.authentication.resource;

import com.howard.authentication.domain.exception.BadRequestException;
import com.howard.authentication.domain.exception.Sid;
import com.howard.authentication.resource.dto.LoggedInDTO;
import com.howard.authentication.resource.dto.LoginDTO;
import com.howard.authentication.service.AuthenticationService;
import com.howard.authentication.service.request.GetCredentialsRequest;
import com.howard.authentication.service.response.VerifyCredentialsResponse;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Authentication {

    private final AuthenticationService service;
    private final JsonWebToken token;
    private final Logger logger;

    @Inject
    public Authentication(AuthenticationService service, JsonWebToken token, Logger logger) {
        this.service = service;
        this.token = token;
        this.logger = logger;
    }

    @PermitAll
    @POST
    @Path("login")
    public Response login(LoginDTO dto) {
        VerifyCredentialsResponse response = service.login(dto.toRequest());
        if (!response.isVerified()) {
            throw new BadRequestException(Sid.CREDENTIALS_NOT_VALID, "The credentials are not valid");
        }
        return Response.ok()
                .cookie(createCookie(60 * 60, response.getToken().getToken()))
                .entity(new LoggedInDTO(response.getId().getRaw()))
                .build();
    }

    @RolesAllowed({"USER", "ADMIN", "SUPER_USER"})
    @Path("/login")
    @GET
    public LoggedInDTO loggedIn() {
        return new LoggedInDTO(token.getSubject());
    }

    @RolesAllowed({"USER", "ADMIN"})
    @Path("/logout")
    @GET
    public Response logout() {
        return Response.ok().cookie(createLogoutCookie()).build();
    }

    private NewCookie createCookie(int age, String token) {
        return new NewCookie("jwt", token, "/", "localhost", "comment", age + 3600, false, true);
    }

    private NewCookie createLogoutCookie() {
        return new NewCookie("jwt", null, "/", "localhost", 0, "comment", 0, new Date(0), false, true);
    }
}
