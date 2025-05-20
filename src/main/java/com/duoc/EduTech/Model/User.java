package com.duoc.EduTech.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
public abstract class User {
    private String username;
    private String password;
    private String email;
    private Boolean accountState;
    private String rol;

}
