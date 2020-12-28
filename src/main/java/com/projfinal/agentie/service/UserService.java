package com.projfinal.agentie.service;

import com.projfinal.agentie.model.LoginForm;
import com.projfinal.agentie.model.User;
import com.projfinal.agentie.model.UserDTO;
import com.projfinal.agentie.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void save(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        userRepo.save(user);
    }

    public Map<String, Boolean> login(LoginForm loginForm) {
        Map<String, Boolean> result = new HashMap<>();
        User user = userRepo.findByEmail(loginForm.getEmail());
        if (Objects.nonNull(user)) {
            result.put("mail", true);
            result.put("pass", user.getPassword().equals(loginForm.getPass()));
            return result;
        }
            result.put("mail", false);
            result.put("pass", false);
            return result;
    }

    public boolean checkUser(UserDTO userDTO) {
        User existing = userRepo.findByEmail(userDTO.getEmail());
        return Objects.nonNull(existing);
    }
}
