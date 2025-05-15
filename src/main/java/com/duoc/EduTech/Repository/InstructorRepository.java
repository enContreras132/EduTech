package com.duoc.EduTech.Repository;

import com.duoc.EduTech.Model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository <Instructor, Integer> {

}
