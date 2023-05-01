package com.example.UniversityEventManagement.services;

import com.example.UniversityEventManagement.models.Student;
import com.example.UniversityEventManagement.models.StudentDept;
import com.example.UniversityEventManagement.repositories.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepo iStudentRepo;

    public String addStudents(List<Student> studentList) {
        Iterable<Student> added = iStudentRepo.saveAll(studentList);

        if(added != null){
            return "Added students succesfully..!!!";
        }
        return "Failed to add students..!!!";
    }

    public Iterable<Student> fetchAllStudents() {
        return iStudentRepo.findAll();
    }

    public Optional<Student> getStudentById(Integer studentId) {
        return iStudentRepo.findById(studentId);
    }

    public void deleteStudentByName(String name) {
        iStudentRepo.deleteByLastName(name);
    }

    @Transactional
    public void updateStudentByDept(Integer id, StudentDept dept) {
        iStudentRepo.updateDepartmentBasedOnStudentId(id,dept);
    }
}
