package br.com.tranquilotech.Aula04.mapper;

import br.com.tranquilotech.Aula04.dto.CreateUserDTO;
import br.com.tranquilotech.Aula04.dto.UserDTO;
import br.com.tranquilotech.Aula04.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity createUserToEntity(CreateUserDTO dto) {
        return new UserEntity(null, dto.getName());
    }

    public UserDTO entityToDTO(UserEntity user) {
        return new UserDTO(user.getUserId(), user.getName());
    }
}
