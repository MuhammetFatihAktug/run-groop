package org.example.rungroop.services;

import org.example.rungroop.dto.RegistrationDto;
import org.example.rungroop.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
