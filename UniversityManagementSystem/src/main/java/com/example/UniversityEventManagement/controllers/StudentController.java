package com.example.UniversityEventManagement.controllers;

import com.example.UniversityEventManagement.models.Student;
import com.example.UniversityEventManagement.models.StudentDept;
import com.example.UniversityEventManagement.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;


//    update student department
//    delete student
//    Get all students
//    Get student by Id

//    Update event
//    Delete event
//    Get All events by date

//    Add student
    @PostMapping(value = "/students")
    public String addStudents(@Valid @RequestBody List<Student> studentList){
        return studentService.addStudents(studentList);
    }

//    update student department
    @PutMapping(value = "/byId/{id}/department/{dept}")
    public void updateStudentByDept(@PathVariable Integer id,@PathVariable StudentDept dept){
        studentService.updateStudentByDept(id,dept);
    }

//    delete student
    @DeleteMapping(value = "/student/byName/{name}")
    public void deleteByName(@PathVariable String name){
        studentService.deleteStudentByName(name);
    }

//    Get all students
    @GetMapping(value = "/students/all")
    public Iterable<Student> getAllStudents(){
        return studentService.fetchAllStudents();
    }

//    Get student by Id
    @GetMapping(value = "/student/byId/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Integer studentId){
        return studentService.getStudentById(studentId);
    }


}
