package org.example.rungroop.services.impl;

import org.example.rungroop.dto.RegistrationDto;
import org.example.rungroop.models.Role;
import org.example.rungroop.models.UserEntity;
import org.example.rungroop.repository.RoleRepository;
import org.example.rungroop.repository.UserRepository;
import org.example.rungroop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServerImpl implements UserService {
    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public UserServerImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(new Role[]{role}));
        userRepository.save(user);
    }
}
