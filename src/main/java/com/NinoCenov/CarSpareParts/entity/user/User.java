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

    @Column(name = "first_name", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty()
    @Size(min=2, max = 255)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank()
    @Email
    private String email;

    @Column(name = "phone_number", nullable = false)
    @NotEmpty()
    @Pattern(regexp = "^(\\+|00)[0-9\\-]{10,15}$", message = "Phone number should be between 10 and 15 digits")
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    @NotEmpty()
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!#%*?&])[A-Za-z\\d@$!#%*?&]{8,30}$",
            message = "Password should be between 8 and 30 chars with at least 1 lowercase, 1 uppercase," +
                    " 1 special char, 1 digit and no whitespace")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
