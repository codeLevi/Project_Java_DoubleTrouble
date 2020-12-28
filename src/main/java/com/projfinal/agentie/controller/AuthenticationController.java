package com.projfinal.agentie.controller;

import com.projfinal.agentie.model.LoginForm;
import com.projfinal.agentie.model.UserDTO;
import com.projfinal.agentie.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDTO userDTO() {
        return new UserDTO();
    }

    @ModelAttribute("login")
    public LoginForm loginForm() {
        return new LoginForm();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("login") @Valid LoginForm loginForm, BindingResult result) {
        if (result.hasErrors()) {
            return "home";
        }
        Map<String, Boolean> loginResult = userService.login(loginForm);

        if (loginResult.get("mail") && loginResult.get("pass")) {
            return "redirect:/index";
        }

        if (Boolean.FALSE.equals(loginResult.get("mail"))) {
            result.rejectValue("email", "email.error", "Nu s-a gasit utilizator!");
        }

        if (Boolean.FALSE.equals(loginResult.get("pass"))) {
            result.rejectValue("pass", "pass.error", "Parola incorecta!");
        }

        return "home";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result) {
        if (userService.checkUser(userDTO)) {
            result.rejectValue("email", "email.error", "Adresa de mail este deja folosita!");
        }

        if (result.hasErrors()) {
            return "home";
        }

        userService.save(userDTO);

        return "redirect:/index";
    }
}
