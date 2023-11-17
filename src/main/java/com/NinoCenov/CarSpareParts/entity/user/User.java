package com.NinoCenov.CarSpareParts.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    @NotEmpty()
    @Size(min=2, max = 255)
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty()
    @Size(min=2, max = 255)
    private String lastName;

    @Column(name = "email", unique = true)
    @NotBlank()
    @Email
    private String email;

    @Column(name = "phone_number")
    @NotEmpty()
    @Pattern(regexp = "^(\\+|00)[0-9\\-]{10,15}$")
    private String phoneNumber;

    @Column(name = "password")
    @NotEmpty()
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
