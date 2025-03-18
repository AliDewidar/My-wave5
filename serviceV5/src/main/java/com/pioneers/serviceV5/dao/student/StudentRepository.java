package com.pioneers.serviceV5.dao.student;

import com.pioneers.serviceV5.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository // @Repository is optional for JpaRepository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    Optional<Student> findByEmail(String email);

    Optional<Student> findFirstByOrderById();
}
