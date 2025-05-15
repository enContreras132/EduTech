package com.duoc.EduTech.Repository;

import com.duoc.EduTech.Model.ClienteAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <ClienteAlumno, Integer> {

}
