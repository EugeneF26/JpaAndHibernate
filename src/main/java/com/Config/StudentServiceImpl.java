package com.Config;

import com.Config.StudentRepository;
import com.Config.Student;
import com.Config.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentServiceImpl() {

    }

    @Override
    public void newStudent() {
        Student student = new Student();
        student.setName("Petr");

        studentRepository.save(student);
    }

    @Override
    public void displayStudent() {
        Optional<Student> student = studentRepository.findById(1L);
        System.out.println(student);
    }
}
