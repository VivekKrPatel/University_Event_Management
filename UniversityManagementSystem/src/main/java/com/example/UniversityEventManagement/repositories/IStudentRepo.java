package com.example.UniversityEventManagement.repositories;

import com.example.UniversityEventManagement.models.Student;
import com.example.UniversityEventManagement.models.StudentDept;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student,Integer> {

//    custom deletion
    public void deleteByLastName(String lastName);


//    custom query
    @Modifying
    @Query(value = "update STUDENT set DEPARTMENT = :department where student_id  = :studentId",nativeQuery = true)
    public void updateDepartmentBasedOnStudentId(Integer studentId, StudentDept department);
}
