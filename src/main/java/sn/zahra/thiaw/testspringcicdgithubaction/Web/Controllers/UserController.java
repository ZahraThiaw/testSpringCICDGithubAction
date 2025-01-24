package sn.zahra.thiaw.testspringcicdgithubaction.Web.Controllers;


import org.springframework.http.ResponseEntity;
import sn.zahra.thiaw.testspringcicdgithubaction.Datas.Entities.UserEntity;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Dtos.Responses.UserResponseDTO;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Filters.ApiResponse;

import java.util.List;

public interface UserController extends BaseController<UserEntity, Long, UserResponseDTO> {
    ResponseEntity<ApiResponse<UserResponseDTO>> getConnectedUserProfile();
    //ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers();
}
