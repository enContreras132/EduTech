package com.duoc.EduTech.Service;



import com.duoc.EduTech.Model.Curso;
import com.duoc.EduTech.Model.Instructor;
import com.duoc.EduTech.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository InstructorRepository;

    //Agregar Instructor

    public String addInstructor(Instructor instructor) {
        InstructorRepository.save(instructor);
        return "Instructror agregado.";
    }

    //Listar

    public String getAllInstructor() {
        String output = "";
        for (Instructor i : InstructorRepository.findAll()){
            output += "id: "+i.getId()+"\n";
            output += "nombre: "+i.getNombre()+"\n";
            output += "especialidad: "+i.getEspecialidad()+"\n";
            output += "correo: "+i.getCorreo()+"\n";
            output += "contraseña: "+i.getContrasena()+"\n";
        }
        if (output.isEmpty()){
            return "no hay Instructor";
        }
        else {
            return output;
        }
    }

    //Listar por ID

    public String getInstructorById(int id) {
        String output = "";
        if (InstructorRepository.existsById(id)){
            Instructor i = InstructorRepository.findById(id).get();
            output += "id: "+i.getId()+"\n";
            output += "nombre: "+i.getNombre()+"\n";
            output += "especialidad: "+i.getEspecialidad()+"\n";
            output += "correo: "+i.getCorreo()+"\n";
            output += "contraseña: "+i.getContrasena()+"\n";
            return output;
        }
        else {
            return "Instructor no encontrado";
        }
    }

    //Eliminar

    public String deleteInstructor(int id) {
        if (InstructorRepository.existsById(id)){
            InstructorRepository.deleteById(id);
            return "Instructor eliminado.";
        }
        else {
            return "Instructor no encontrado";
        }
    }

    //Actualizar

    public String updateInstructor(int id, Instructor instructor) {
        if (InstructorRepository.existsById(id)){
            Instructor i = InstructorRepository.findById(id).get();
            i.setNombre(instructor.getNombre());
            i.setEspecialidad(instructor.getEspecialidad());
            i.setCorreo(instructor.getCorreo());
            i.setContrasena(instructor.getContrasena());
            InstructorRepository.save(i);
            return "Instructor actualizado";
        }
        else {
            return "Instructor no encontrado";
        }
    }
}
