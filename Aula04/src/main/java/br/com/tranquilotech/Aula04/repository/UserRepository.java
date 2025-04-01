package br.com.tranquilotech.Aula04.repository;

import br.com.tranquilotech.Aula04.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
