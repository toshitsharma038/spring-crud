package com.demo.SpringCrud.Service;

import com.demo.SpringCrud.Beans.Student;
import com.demo.SpringCrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{

    @Autowired
    StudentRepository studentRepository;

    public void addData(Student student)
    {
        System.out.println("I am object"+student);
        studentRepository.save(student);
    }

    public List<Student> fetchdata()
    {
        return studentRepository.findAll();
    }


    public Student searchData(long id)
    {
        return  studentRepository.getById(id);
    }

    public Student inserData(Student student)
    {
        return  studentRepository.save(student);
    }

    public boolean deleteData(Student stu)
    {
        studentRepository.delete(stu);
        return true;
    }
}
