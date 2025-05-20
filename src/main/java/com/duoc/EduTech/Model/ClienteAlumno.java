package com.duoc.EduTech.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ClienteAlumno extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String k;//prueba de branch, dsps borrar



}
