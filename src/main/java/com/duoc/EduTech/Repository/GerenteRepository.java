package com.duoc.EduTech.Repository;

import com.duoc.EduTech.Model.GerenteCursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteRepository extends JpaRepository <GerenteCursos, Integer> {

}

