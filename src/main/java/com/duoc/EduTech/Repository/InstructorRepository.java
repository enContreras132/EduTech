package com.duoc.EduTech.Repository;

import com.duoc.EduTech.Model.Instructor;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface InstructorRepository extends JpaRepository <Instructor, Integer> {



}
