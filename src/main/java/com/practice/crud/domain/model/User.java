package com.practice.crud.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Builder
@Table(schema = "public", name = "users")
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private BigInteger rut;
    private String dv;
    private LocalDate birthDate;
    private String emailAddress;
    private String password;
}
