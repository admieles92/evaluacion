package com.smartJob.userApi.user.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.smartJob.userApi.user.auth.JwtUtil;
import com.smartJob.userApi.user.config.PassProperties;
import com.smartJob.userApi.user.dto.UserRequest;
import com.smartJob.userApi.user.dto.UserResponse;
import com.smartJob.userApi.user.entity.SjTelephone;
import com.smartJob.userApi.user.entity.SjUser;
import com.smartJob.userApi.user.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

	@Autowired
	private PassProperties passProperties;
	
	@Autowired
	private JwtUtil jwtUtil;

	public UserResponse create(UserRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El correo ya registrado");
        }
        String regex = passProperties.getRegex();
        if (!Pattern.compile(regex).matcher(request.getPassword()).matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contraseña no cumple con el formato requerido");
        }
        
        
        SjUser user = new SjUser();
        user.setId(UUID.randomUUID());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String token = jwtUtil.generateToken(username);
        user.setToken(token);
        
//        user.setToken(UUID.randomUUID().toString());
        user.setActive(true);
        
        List<SjTelephone> lTelf = request.getPhones().stream().map(dto -> {
        	SjTelephone tel = new SjTelephone();
            tel.setNumber(dto.getNumber());
            tel.setCitycode(dto.getCitycode());
            tel.setContrycode(dto.getContrycode());
            return tel;
        }).collect(Collectors.toList());

        user.setPhones(lTelf);

        userRepo.save(user);
        return new UserResponse(user.getId(), user.getName(), user.getEmail(),
                user.getCreated(), user.getModified(), user.getLastLogin(), user.getToken(), user.isActive());
    
	}
	
    public boolean isPasswordValida(String pwd) {
        String regex = passProperties.getPassword();
        return Pattern.matches(regex, pwd);
    }
}
