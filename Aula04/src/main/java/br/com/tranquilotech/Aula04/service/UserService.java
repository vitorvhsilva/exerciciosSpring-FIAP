package br.com.tranquilotech.Aula04.service;

import br.com.tranquilotech.Aula04.dto.CreateUserDTO;
import br.com.tranquilotech.Aula04.dto.UpdateUserDTO;
import br.com.tranquilotech.Aula04.entity.UserEntity;
import br.com.tranquilotech.Aula04.mapper.UserMapper;
import br.com.tranquilotech.Aula04.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository repository;
    private UserMapper mapper;

    public UserEntity createUser(CreateUserDTO dto) {
        return repository.save(mapper.createUserToEntity(dto));
    }

    public Page<UserEntity> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public UserEntity getUserById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Transactional
    public UserEntity updateUser(UpdateUserDTO dto) {
        UserEntity user = getUserById(dto.getId());
        user.setName(dto.getName());
        return user;
    }

    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
