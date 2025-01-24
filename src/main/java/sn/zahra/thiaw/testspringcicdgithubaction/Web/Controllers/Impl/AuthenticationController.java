package sn.zahra.thiaw.testspringcicdgithubaction.Web.Controllers.Impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.zahra.thiaw.testspringcicdgithubaction.Datas.Entities.UserEntity;
import sn.zahra.thiaw.testspringcicdgithubaction.Services.Impl.AuthenticationService;
import sn.zahra.thiaw.testspringcicdgithubaction.Services.Impl.JwtService;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Dtos.Requests.LoginUserDto;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Dtos.Requests.RegisterUserDTO;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Dtos.Responses.LoginResponse;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Filters.ApiResponse;

import java.util.Collections;

@RequestMapping("/auth")
@RestController
@Tag(name = "Auth", description = "API pour gérer les utilisateurs")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserEntity>> register(@RequestBody RegisterUserDTO registerUserDTO) {
        UserEntity registeredUser = authenticationService.signup(registerUserDTO);
        ApiResponse<UserEntity> response = new ApiResponse<>(
                true,
                "Utilisateur enregistré avec succès",
                registeredUser,
                Collections.emptyList(),
                "OK",
                201
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> authenticate(@RequestBody LoginUserDto loginUserDto) {
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);

        ApiResponse<LoginResponse> response = new ApiResponse<>(
                true,
                "Authentification réussie",
                loginResponse,
                Collections.emptyList(),
                "OK",
                200
        );
        return ResponseEntity.ok(response);
    }
}
