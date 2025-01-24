package sn.zahra.thiaw.testspringcicdgithubaction.Services.Impl;


import org.springframework.stereotype.Service;
import sn.zahra.thiaw.testspringcicdgithubaction.Datas.Entities.UserEntity;
import sn.zahra.thiaw.testspringcicdgithubaction.Datas.Repositories.UserRepository;
import sn.zahra.thiaw.testspringcicdgithubaction.Mappers.GenericMapper;
import sn.zahra.thiaw.testspringcicdgithubaction.Services.UserService;
import sn.zahra.thiaw.testspringcicdgithubaction.Web.Dtos.Responses.UserResponseDTO;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long> implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final GenericMapper<UserEntity, ?, UserResponseDTO> userMapper;

    public UserServiceImpl(UserRepository userRepository, JwtService jwtService, GenericMapper<UserEntity, ?, UserResponseDTO> userMapper) {
        super(userRepository);
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO getConnectedUserProfile() {
        String email = jwtService.extractUsernameFromToken(); // Récupérer l'e-mail depuis le JWT
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'e-mail : " + email));
        return userMapper.toResponseDto(user); // Mapper vers UserResponseDTO
    }

}
