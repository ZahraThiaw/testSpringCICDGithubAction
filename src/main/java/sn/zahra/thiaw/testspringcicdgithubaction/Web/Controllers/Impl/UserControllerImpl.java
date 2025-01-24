package sn.zahra.thiaw.testspringcicdgithubaction.Web.Controllers.Impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.zahra.thiaw.testspringcicdgithubaction.Datas.Entities.UserEntity;
import sn.zahra.thiaw.testspringcicdgithubaction.Mappers.GenericMapper;
import sn.zahra.thiaw.testspringcicdgithubaction.Services.UserService;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Controllers.UserController;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Dtos.Responses.UserResponseDTO;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Filters.ApiResponse;

import java.util.Collections;

@RequestMapping("/users")
@RestController
public class UserControllerImpl extends BaseControllerImpl<UserEntity, Long, UserResponseDTO> implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService,
                              GenericMapper<UserEntity, ?, UserResponseDTO> userMapper) {
        super(userService, userMapper);
        this.userService = userService;
    }

    @Override
    @GetMapping("/profile")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getConnectedUserProfile() {
        UserResponseDTO profile = userService.getConnectedUserProfile();
        ApiResponse<UserResponseDTO> response = new ApiResponse<>(
                true,
                "Profil utilisateur récupéré avec succès",
                profile,
                Collections.emptyList(),
                "OK",
                200
        );
        return ResponseEntity.ok(response);
    }




}
