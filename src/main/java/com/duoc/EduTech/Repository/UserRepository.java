package com.duoc.EduTech.Repository;

import com.duoc.EduTech.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Opcional, pero se puede dejar
public interface UserRepository extends JpaRepository<User, Integer> {

    // Puedes agregar métodos personalizados aquí si quieres
}
