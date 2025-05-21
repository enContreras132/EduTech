package com.duoc.EduTech.Service;


import com.duoc.EduTech.Model.GerenteCursos;
import com.duoc.EduTech.Repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GerenteCursosService {
    @Autowired
    GerenteRepository gerenteRepository;


    //Agregar Gerente

    public String addGerente(GerenteCursos gerenteCursos) {
        gerenteRepository.save(gerenteCursos);
        return "Gerente agregado.";
    }

}
