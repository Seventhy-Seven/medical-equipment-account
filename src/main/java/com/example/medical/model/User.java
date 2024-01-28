package com.example.medical.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN,
        ENGINEER,
        USER
    }
}
