package com.duoc.EduTech.Repository;

import com.duoc.EduTech.Model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

}