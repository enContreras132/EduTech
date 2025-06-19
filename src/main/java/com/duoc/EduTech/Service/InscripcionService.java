package com.duoc.EduTech.Service;

import com.duoc.EduTech.Model.GerenteCursos;
import com.duoc.EduTech.Model.Inscripcion;
import com.duoc.EduTech.Repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {

    @Autowired
    InscripcionRepository inscripcionRepository;

    //Agregar Gerente
    public String addInscripcion(Inscripcion inscripcion) {
        inscripcionRepository.save(inscripcion);
        return "Inscripcion agregada.";
    }

    //Listar
    public String getAllInscripcion() {
        String output = "";
        for (Inscripcion i : inscripcionRepository.findAll()){
            output += "id: "+i.getId_inscripcion()+"\n";
            output += "fecha de inscripcion: "+i.getFecha_inscripcion()+"\n";
        }
        if (output.isEmpty()){
            return "no hay gerentes";
        }
        else {
            return output;
        }
    }

    //eliminar
    public String deleteInscripcion(int id) {
        if (inscripcionRepository.existsById(id)){
            inscripcionRepository.deleteById(id);
            return "inscripcion eliminada.";
        }
        else {
            return "inscripcion no encontrada";
        }
    }

    //listar por id
    public static String getInscripcionById(int id) {
        String output = "";
        if (inscripcionRepository.existsById(id)){
            Inscripcion i = inscripcionRepository.findById(id).get();
            output += "id: "+i.getId_inscripcion()+"\n";
            output += "fecha de inscripcion: "+i.getFecha_inscripcion()+"\n";
            return output;
        }
        else {
            return "inscripcion no encontrada";
        }
    }

    //update
    public String updateIncripcion(int id, Inscripcion inscripcion) {
        if (inscripcionRepository.existsById(id)){
            Inscripcion i = inscripcionRepository.findById(id).get();
            i.setFecha_inscripcion(inscripcion.getFecha_inscripcion());
            inscripcionRepository.save(i);
            return "inscripcion actualizada";
        }
        else {
            return "inscripcion no encontrada";
        }
    }
}
