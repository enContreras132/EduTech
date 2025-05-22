package com.duoc.EduTech.Service;

import com.duoc.EduTech.Model.Administrador;
import com.duoc.EduTech.Model.ClienteAlumno;
import com.duoc.EduTech.Repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    AdministradorRepository administradorRepository;


    //Agregar
    public String addAdministrador(Administrador administrador) {
        administradorRepository.save(administrador);
        return "Adminstrador agregado";
    }


    //Eliminar
    public String deleteAdministrador(int id) {
        if (administradorRepository.existsById(id)) {
            administradorRepository.deleteById(id);
            return "Adminstrador eliminado.";
        } else {
            return "Administrador no encontrado";
        }
    }

    //Listar

    public String getAllAdministrador() {
        String output = "";
        for (Administrador ad : administradorRepository.findAll()){
            output += "id: "+ad.getId_admin()+"\n";
            output += "nombre: "+ad.getNombre()+"\n";
            output += "correo: "+ad.getCorreo()+"\n";
            output += "contraseña: "+ad.getContrasena()+"\n";
        }
        if (output.isEmpty()){
            return "no hay alumnos";
        }
        else {
            return output;
        }
    }

    //Listar por ID
    public String getAdministradorById(int id) {
        String output = "";
        if (administradorRepository.existsById(id)){
            Administrador ad = administradorRepository.findById(id).get();
            output += "id: "+ad.getId_admin()+"\n";
            output += "nombre: "+ad.getNombre()+"\n";
            output += "correo: "+ad.getCorreo()+"\n";
            output += "contraseña: "+ad.getContrasena()+"\n";
            return output;
        }
        else {
            return "adminstrador no encontrado";
        }
    }

    //Actualizar
    public String updateAdminstrador(int id, Administrador administrador) {
        if (administradorRepository.existsById(id)){
            Administrador ad = administradorRepository.findById(id).get();
            ad.setNombre(ad.getNombre());
            ad.setCorreo(ad.getCorreo());
            ad.setContrasena(ad.getContrasena());
            administradorRepository.save(ad);
            return "administrador actualizado";
        }
        else {
            return "adminstrador no encontrado";
        }
    }


}
