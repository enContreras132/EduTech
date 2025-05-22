package com.duoc.EduTech.Service;

import com.duoc.EduTech.Model.ClienteAlumno;
import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteAlumnoService {

    @Autowired
    ClienteRepository clienteRepository;

    public String addCliente(ClienteAlumno cliente) {
        clienteRepository.save(cliente);
        return "Cliente agregado";
    }

    public String deleteCliente(int id) {
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return "Cliente eliminado.";
        }
        else {
            return "Cliente no encontrado";
        }
    }

    public String getAllClientes() {
        String output = "";
        for (ClienteAlumno c : clienteRepository.findAll()){
            output += "id: "+c.getId_alumno()+"\n";
            output += "nombre: "+c.getNombre()+"\n";
            output += "correo: "+c.getCorreo()+"\n";
            output += "contraseña: "+c.getContraseña()+"\n";
            output += "fecha de registro: "+c.getFecha_registro()+"\n";
        }
        if (output.isEmpty()){
            return "no hay cursos";
        }
        else {
            return output;
        }
    }

    public String getClienteById(int id) {
        String output = "";
        if (clienteRepository.existsById(id)){
            ClienteAlumno c = clienteRepository.findById(id).get();
            output += "id: "+c.getId_alumno()+"\n";
            output += "nombre: "+c.getNombre()+"\n";
            output += "correo: "+c.getCorreo()+"\n";
            output += "contraseña: "+c.getContraseña()+"\n";
            output += "fecha de registro: "+c.getFecha_registro()+"\n";
            return output;
        }
        else {
            return "curso no encontrado";
        }
    }

    public String updateCliente(int id, ClienteAlumno cliente) {
        if (clienteRepository.existsById(id)){
            ClienteAlumno c = clienteRepository.findById(id).get();
            c.setNombre(cliente.getNombre());
            c.setCorreo(cliente.getCorreo());
            c.setContraseña(cliente.getContraseña());
            clienteRepository.save(c);
            return "curso actualizado";
        }
        else {
            return "curso no encontrado ejemplo";
        }


        System.out.println("Hola");



    }
}
