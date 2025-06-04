package com.duoc.EduTech.Service;

import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public String addCurso(Curso curso) {
        cursoRepository.save(curso);
        return "Curso agregado.";
    }

    public String deleteCurso(int id) {
        if (cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
            return "Curso eliminado.";
        }
        else {
            return "Curso no encontrado";
        }
    }

    public String getAllCursos() {
        String output = "";
        for (Curso c : cursoRepository.findAll()){
            output += "id: "+c.getId()+"\n";
            output += "nombre: "+c.getNombre()+"\n";
            output += "desc: "+c.getDescripcion()+"\n";
            output += "capacidad: "+c.getCapacidad()+"\n";
        }
        if (output.isEmpty()){
            return "no hay cursos";
        }
        else {
            return output;
        }
    }

    public String getCursoById(int id) {
        String output = "";
        if (cursoRepository.existsById(id)){
            Curso c = cursoRepository.findById(id).get();
            output += "id: "+c.getId()+"\n";
            output += "nombre: "+c.getNombre()+"\n";
            output += "desc: "+c.getDescripcion()+"\n";
            output += "capacidad: "+c.getCapacidad()+"\n";
            return output;
        }
        else {
            return "curso no encontrado";
        }
    }

    public String updateCurso(int id, Curso curso) {
        if (cursoRepository.existsById(id)){
            Curso c = cursoRepository.findById(id).get();
            c.setNombre(curso.getNombre());
            c.setCapacidad(curso.getCapacidad());
            c.setDescripcion(curso.getDescripcion());
            cursoRepository.save(c);
            return "curso actualizado";
        }
        else {
            return "curso no encontrado";
        }
    }

}
