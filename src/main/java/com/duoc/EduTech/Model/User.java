package com.duoc.EduTech.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class User {
    private String username;
    private String password;
    private String email;
    private Boolean accountState;
    private String rol;

}
