package com.msk.bookstore.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name must not be empty.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "First name must contain only letters and numbers")
    private String firstName;

    @NotBlank(message = "Last name must not be empty.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Last name must contain only letters and numbers")
    private String lastName;

    @NotBlank(message = "Date of birth must not be empty.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @NotBlank(message = "Email must not be empty.")
    @Email(message = "Please add a valid email address.")
    private String email;

    @NotBlank(message = "Password must not be empty.")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    private String password;

    @NotBlank(message = "Phone number must not be empty")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be a 10-digit numeric value")
    private String phone;

    @NotBlank(message = "Address must not be empty")
    @Size(max = 255, message = "Address length must not exceed 255 characters")
    @Embedded
    private Address address;

}
