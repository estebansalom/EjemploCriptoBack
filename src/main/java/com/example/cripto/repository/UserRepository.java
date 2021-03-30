package com.example.cripto.repository;
import com.example.cripto.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Integer> {
    UserDto findOneByEmail(String email);
}
