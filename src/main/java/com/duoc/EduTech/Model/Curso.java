package com.duoc.EduTech.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
    public class Curso {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String nombre;
        private String descripcion;
        private int capacidad;
    }

