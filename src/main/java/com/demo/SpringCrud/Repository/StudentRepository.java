package com.demo.SpringCrud.Repository;

import com.demo.SpringCrud.Beans.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
{
}
