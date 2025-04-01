package br.com.tranquilotech.Aula04.controller;

import br.com.tranquilotech.Aula04.dto.CreateUserDTO;
import br.com.tranquilotech.Aula04.dto.UpdateUserDTO;
import br.com.tranquilotech.Aula04.dto.UserDTO;
import br.com.tranquilotech.Aula04.entity.UserEntity;
import br.com.tranquilotech.Aula04.mapper.UserMapper;
import br.com.tranquilotech.Aula04.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private UserService service;
    private UserMapper mapper;

    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO dto) {
        UserEntity user = service.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entityToDTO(user));
    }

    @GetMapping
    Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<UserEntity> users = service.getAllUsers(pageable);
        return users.map(u -> mapper.entityToDTO(u));
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        UserEntity user = service.getUserById(id);
        return ResponseEntity.ok(mapper.entityToDTO(user));
    }

    @PutMapping
    ResponseEntity<UserDTO> updateUser(@RequestBody UpdateUserDTO dto) {
        UserEntity user = service.updateUser(dto);
        return ResponseEntity.ok(mapper.entityToDTO(user));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable String id){
        service.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
