package sn.zahra.thiaw.testspringcicdgithubaction.Web.Dtos.Responses;

import lombok.Data;
import sn.zahra.thiaw.testspringcicdgithubaction.Datas.Entities.UserEntity;

import java.math.BigDecimal;

@Data
public class UserResponseDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private UserEntity.Role role;
}
