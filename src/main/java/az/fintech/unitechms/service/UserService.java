package az.fintech.unitechms.service;

import az.fintech.unitechms.dto.LoginDto;
import az.fintech.unitechms.dto.RegisterDto;

public interface UserService {

    RegisterDto register(RegisterDto registerDto);

    LoginDto login(LoginDto loginDto);
}
