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
        return cursoRepository.addCurso(curso);
    }

//    public String deleteUser(int id) {
//        return userRepository.removeUser(id);
//    }
//
//    public String getAllUsers() {
//        return userRepository.getAllUsers();
//    }
//
//    public String getUserById(int id) {
//        return userRepository.getUser(id);
//    }
//
//    public String updateUser(int id, User user) {
//        return userRepository.updateUser(id, user);
//    }

}
