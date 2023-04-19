package com.howard.resource.login;

import com.howard.resource.login.dto.EmailDTO;
import com.howard.resource.login.dto.LoggedInDTO;
import com.howard.resource.login.dto.LoginDTO;
import com.howard.resource.login.dto.SignUpDTO;
import com.howard.service.AuthenticationService;
import com.howard.service.UserService;
import com.howard.service.response.LoginResponse;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/")
public class AuthResource {


    private final JsonWebToken jwt;
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @Inject
    public AuthResource(JsonWebToken jwt, AuthenticationService authenticationService, UserService userService) {
        this.jwt = jwt;
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @Path("/signup")
    @POST
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public EmailDTO signup(SignUpDTO signUpDTO) {
        return new EmailDTO(authenticationService.signUp(signUpDTO.toSignupRequest()).getEmail().getValue());
    }

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response login(LoginDTO login) {
        LoginResponse response = authenticationService.login(login.toLoginRequest());
        System.out.println(response.getToken().getToken());
        return Response.ok()
                .cookie(createCookie(1000, response.getToken().getToken()))
                .entity(new LoggedInDTO(true, response.getToken().getUserName(), response.getToken().getGender()))
                .build();
    }

    @Path("/logout")
    @GET
    @RolesAllowed({"USER"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        return Response.ok()
                .cookie(createCookie(0, null))
                .entity(new LoggedInDTO(false, null, null))
                .build();
    }


    @Path("/login")
    @GET
    @RolesAllowed({"USER"})
    @Produces(MediaType.APPLICATION_JSON)
    public LoggedInDTO loggedIn() {
        return new LoggedInDTO(true, jwt.getClaim(Claims.preferred_username), jwt.getClaim(Claims.gender));
    }

    private NewCookie createCookie(int age, String token) {
        if (age > 0) {
            return new NewCookie("jwt", token, "/", "localhost", "comment", age + 3600, false, true);
        }
        return new NewCookie("jwt", null, null, null, 0, "comment", 0, new Date(0), false, true);
    }
}
