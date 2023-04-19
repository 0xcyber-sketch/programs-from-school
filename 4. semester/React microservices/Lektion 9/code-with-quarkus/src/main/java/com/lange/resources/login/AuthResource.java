package com.lange.resources.login;

import com.lange.resources.login.dto.CreatedDTO;
import com.lange.resources.login.dto.LoggedinDTO;
import com.lange.resources.login.dto.LoginDTO;
import com.lange.resources.login.dto.SignUpDTO;
import com.lange.service.AuthService;
import com.lange.service.requests.LoginRequest;
import com.lange.service.requests.SignupRequest;
import com.lange.service.responses.LoginResponse;
import com.lange.service.responses.SignupResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/")
public class AuthResource {

    private final AuthService service;

    @Inject
    public AuthResource(AuthService auservice) {
        service = auservice;
    }


    @Path("/signup")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)

    public Response Signup(SignUpDTO signUpDTO) {
        SignupRequest request = new SignupRequest(signUpDTO.getEmail(), signUpDTO.getUserName(), signUpDTO.getPassword());
        SignupResponse res = service.signup(request);

        CreatedDTO dto = new CreatedDTO(res.getUser().getUserID().toString());



       return Response.status(Response.Status.CREATED).entity(dto).build();


    }
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Login(LoginDTO loginDTO) {
        LoginRequest request = new LoginRequest(loginDTO.getUserName(), loginDTO.getPassword());
        LoginResponse res = service.login(request);

        return Response.ok().cookie(createCookie(0, null)).entity(new LoggedinDTO(false, loginDTO.getUserName())).build();

    }

    private NewCookie createCookie(int age, String token) {
        if (age > 0) {
            return new NewCookie("jwt", token, "/", "localhost", "comment", age + 3600, false, true);
        }
        return new NewCookie("jwt", null, null, null, 0, "comment", 0, new Date(0), false, true);
    }


}
