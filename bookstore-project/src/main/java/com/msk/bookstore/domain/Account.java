package com.msk.bookstore.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    private long id;

    @NotBlank(message = "Firstname must not be empty.")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Firstname must contain only letters and numbers")
    private String firstName;

    @NotBlank(message = "Lastname must not be empty.")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Lastname must contain only letters and numbers")
    private String lastName;

    @NotBlank(message = "Date of birth must not be empty.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotBlank(message = "Email must not be empty.")
    @Email(message = "Please add a valid email address.")
    private String email;

    @NotBlank(message = "Password must not be empty.")
    @Size(min = 8, max = 16)
    private String password;

    private String phone;
    private String address;

}
