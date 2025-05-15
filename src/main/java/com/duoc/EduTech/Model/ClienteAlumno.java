package com.duoc.EduTech.Model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteAlumno extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;


    //Buscar
    private String FinnById(int ID){
        return "";
    }

    //Listar
    private String List(int ID){
        return "";
    }

    //Eliminar
    public String Delete(int ID) {};
}
