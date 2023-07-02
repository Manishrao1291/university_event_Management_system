package com.geeks.university.service;

import com.geeks.university.model.Student;
import com.geeks.university.repo.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    public List<Student> getAllStudent() {
        return (List<Student>) studentDao.findAll();
    }

    public void addStudentList(List<Student> students) {
        studentDao.saveAll(students);

    }


    public String deleteStudentById(int studentId) {
        studentDao.deleteById(studentId);
        return "Deleted Successfully";
    }

    public Student getStudentById(int studentId) {
        Optional<Student> stud= studentDao.findById(studentId);
        return stud.isPresent()? stud.get():null;
    }
}
