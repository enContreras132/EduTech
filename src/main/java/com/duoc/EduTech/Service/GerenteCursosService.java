package com.duoc.EduTech.Service;


import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Model.GerenteCursos;
import com.duoc.EduTech.Model.Instructor;
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

    //Listar
    public String getAllGerente() {
        String output = "";
        for (GerenteCursos g : gerenteRepository.findAll()){
            output += "id: "+g.getId()+"\n";
            output += "nombre: "+g.getNombre()+"\n";
            output += "correo: "+g.getCorreo()+"\n";
            output += "contraseña: "+g.getContrasena()+"\n";
            output += "departamento: "+g.getDepartamento()+"\n";
        }
        if (output.isEmpty()){
            return "no hay gerentes";
        }
        else {
            return output;
        }
    }

    //eliminar
    public String deleteGerente(int id) {
        if (gerenteRepository.existsById(id)){
            gerenteRepository.deleteById(id);
            return "gerente eliminado.";
        }
        else {
            return "gerente no encontrado";
        }
    }

    //listar por id
    public String getGerenteById(int id) {
        String output = "";
        if (gerenteRepository.existsById(id)){
            GerenteCursos g = gerenteRepository.findById(id).get();
            output += "id: "+g.getId()+"\n";
            output += "nombre: "+g.getNombre()+"\n";
            output += "correo: "+g.getCorreo()+"\n";
            output += "contraseña: "+g.getContrasena()+"\n";
            output += "departamento: "+g.getDepartamento()+"\n";
            return output;
        }
        else {
            return "gerente no encontrado";
        }
    }

    //update
    public String updateGerente(int id, GerenteCursos gerente) {
        if (gerenteRepository.existsById(id)){
            GerenteCursos g = gerenteRepository.findById(id).get();
            g.setNombre(gerente.getNombre());
            g.setCorreo(gerente.getCorreo());
            g.setContrasena(gerente.getContrasena());
            g.setDepartamento(gerente.getDepartamento());
            gerenteRepository.save(g);
            return "gerente actualizado";
        }
        else {
            return "gerente no encontrado";
        }
    }
}
