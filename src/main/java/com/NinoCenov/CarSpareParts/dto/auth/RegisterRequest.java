package com.NinoCenov.CarSpareParts.dto.auth;

import com.NinoCenov.CarSpareParts.entity.user.Role;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
