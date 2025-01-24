package sn.zahra.thiaw.testspringcicdgithubaction.Services;


import sn.zahra.thiaw.testspringcicdgithubaction.Datas.Entities.UserEntity;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Dtos.Responses.UserResponseDTO;

public interface UserService extends BaseService<UserEntity, Long> {
    UserResponseDTO getConnectedUserProfile();
}
