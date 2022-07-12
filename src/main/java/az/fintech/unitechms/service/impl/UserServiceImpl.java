package az.fintech.unitechms.service.impl;

import az.fintech.unitechms.exception.CredentialsException;
import az.fintech.unitechms.exception.PinAlreadyExistException;
import az.fintech.unitechms.model.User;
import az.fintech.unitechms.dto.LoginDto;
import az.fintech.unitechms.dto.RegisterDto;
import az.fintech.unitechms.repository.UserRepository;
import az.fintech.unitechms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public RegisterDto register(RegisterDto registerDto) {
        Optional<User> existingUser = userRepository.findByPin(registerDto.getPin());
        if (existingUser.isPresent()) throw new PinAlreadyExistException("Pin already exists !");

        User newUser = modelMapper.map(registerDto, User.class);
        userRepository.save(newUser);

        // TODO: return JWT
        return registerDto;
    }

    @Override
    public LoginDto login(LoginDto loginDto) {
        User user = userRepository.findByPinAndPassword(loginDto.getPin(), loginDto.getPassword())
                .orElseThrow(() -> new CredentialsException("Pin or password is not correct!"));

        return modelMapper.map(user, LoginDto.class);
    }
}
