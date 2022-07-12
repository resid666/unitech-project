package com.fintech.unitech.service;

import com.fintech.unitech.dto.LoginDto;
import com.fintech.unitech.dto.RegisterDto;

public interface UserService {

    RegisterDto register(RegisterDto registerDto);

    LoginDto login(LoginDto loginDto);
}
