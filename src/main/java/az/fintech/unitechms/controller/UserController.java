package az.fintech.unitechms.controller;

import az.fintech.unitechms.dto.LoginDto;
import az.fintech.unitechms.dto.RegisterDto;
import az.fintech.unitechms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public RegisterDto registerUser(@RequestBody @Valid RegisterDto registerDto) {
        return userService.register(registerDto);
    }

    @PostMapping("/login")
    public LoginDto loginUser(@RequestBody @Valid LoginDto loginDto) {
        return userService.login(loginDto);
    }
}

