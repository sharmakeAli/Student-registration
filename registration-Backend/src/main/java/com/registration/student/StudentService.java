package com.registration.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    public void updateStudent(Long studentId ,
                              Student student){
        var std=studentRepository.findById(studentId).orElseThrow(()-> new
                EmptyResultDataAccessException(HttpStatus.NOT_FOUND.value()));
        std.setFirstName(student.getFirstName());
        std.setLastName(student.getLastName());
        std.setAddress(student.getAddress());
        std.setDateOfBirth(student.getDateOfBirth());
        std.setPhoneNumber(student.getPhoneNumber());
        std.setEmail(student.getEmail());
        studentRepository.save(std);

    }
}