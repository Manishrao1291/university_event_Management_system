package com.geeks.university.controller;

import com.geeks.university.model.Department;
import com.geeks.university.model.Student;
import com.geeks.university.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class StudentController {

    @Autowired
    StudentService studentService;

    // get all of the students
    @GetMapping("students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("student/{Id}")
    public Student getStudentById(@PathVariable Integer studentId){
        return studentService.getStudentById(studentId);
    }
// add a student
    @PostMapping("students")
    public void addStudent( @RequestBody @Valid List<Student> students){
        studentService.addStudentList(students);

    }

//    @PutMapping("/id/{studentId}/dept/{department}")
//    public String updateDept(@PathVariable int studentId, @PathVariable Department department){
//        return studentService.updateDepartment(studentId,department);
//    }

    @DeleteMapping("student/{Id}")
    public String deleteStudentById(@PathVariable Integer studentId){
        return studentService.deleteStudentById(studentId);
    }
}
