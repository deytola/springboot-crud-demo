package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        this.studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = this.studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException(String.format("student with id %s does not exist", studentId));
        }
        this.studentRepository.deleteById(studentId);
    }
}
