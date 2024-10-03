package com.example.service;


import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
    public List<Student> findByCollegeId(Long collegeId) {
        return studentRepository.findByCollegeId(collegeId);
    }

    public Student update(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            // Update only non-null fields
            if (student.getName() != null) {
                existingStudent.setName(student.getName());
            }
            if (student.getRollNumber() != null) {
                existingStudent.setRollNumber(student.getRollNumber());
            }
            if (student.getDob() != null) {
                existingStudent.setDob(student.getDob());
            }
            if (student.getEmail() != null) {
                existingStudent.setEmail(student.getEmail());
            }
            if (student.getPhoneNumber() != null) {
                existingStudent.setPhoneNumber(student.getPhoneNumber());
            }
            if (student.getBranch() != null) {
                existingStudent.setBranch(student.getBranch());
            }
            if (student.getDegree() != null) {
                existingStudent.setDegree(student.getDegree());
            }
            if (student.getDegreeYear() != null) {
                existingStudent.setDegreeYear(student.getDegreeYear());
            }
            if (student.getBio() != null) {
                existingStudent.setBio(student.getBio());
            }

            return studentRepository.save(existingStudent);
        }
        return null; // Handle the case where the student doesn't exist
    }
}
