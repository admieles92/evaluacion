package com.smartJob.userApi.user.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRequest {
	
    @NotBlank  
    private String name;

    @Email(message = "Correo inválido")
    private String email;
    
    @NotBlank  
    private String password;

    @NotEmpty
    private List<TelephoneDTO> phones;
    

}
