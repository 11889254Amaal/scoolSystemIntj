package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentInterface extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s")
    List<Student> getAllStudent();

    @Query(value = "SELECT s FROM Student s WHERE s.id =:id")
    Student getStudentById(@Param("id") Integer id);

    @Query(value = "SELECT st from Student st " +
            "WHERE st.school.id = :id ")
    List<Student> getStudentsBySchoolId(@Param("id") Integer id);

    @Query(value = "SELECT s from Student s where s.isActive = true")
    List<Student> getAllActiveStudent();
    @Query(value = "SELECT s from Student s where s.isActive = false")
    List<Student> getAllNotActiveStudent();

    @Query(value = "SELECT s from Student s " +
            "WHERE s.studentName = :studentName")
    Student getByStudentName(@Param("studentName") String studentName);

    @Query(value = "SELECT s from Student s " +
            "WHERE s.studentAge = :studentAge")
    List<Student> getByStudentAge(@Param("studentAge") Integer studentAge);
    @Query(value = "SELECT s from Student s where s.id=(SELECT max(s.id) from Student s)")
    Student getLatestStudent();

    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.id =:id")
    Student getIdToDeleteStudentById(@Param("id") Integer id);

    @Query(value ="select s from Student s where s.updatedDate=(select max(updatedDate) from Student)")
    Student getLatestUpdated();

    @Query(value ="select s from Student s where s.createdDate >= :date")
    <list>Student getStudentCreatedAfterDate(@Param("date") Date date);
    @Query(value="select s from School s where s.createdDate = :createdDate")
    Student getStudentByCreatedDate(@Param("createdDate") Date date);

    @Query(value="select s from School s where s.updatedDate = :updatedDate")
    Student getStudentByUpdatedDate(@Param("updatedDate") Date date);

    @Query(value = "UPDATE Student s SET s.isActive = false")
    Student getDeletedAllStudent();

    @Query(value = "UPDATE Student s SET s.isActive = false where s.createdDate > :createdDate")
    Student getDeleteAllStudentsCreatedAfterDate(@Param("createdDate") Date createdDate);

    @Query(value = "UPDATE Student s SET s.isActive = false where s.createdDate = :createdDate")
    <list> Student getDeleteStudentsByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value = "UPDATE Student s SET s.isActive = false where s.updatedDate > :updatedDate")
    <list> Student getsetDeleteStudentsByUpdatedDate(@Param("updatedDate") Date createdDate);

    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.studentName = :studentName")
    Student getDeleteStudentsByStudentName(@Param("studentName") String schoolName);

    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.studentAge = :schoolAge")
    Student getDeleteStudentsByStudentAge(@Param("schoolAge") Integer schoolAge);

    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.school.id = :schoolId")
    Student getDeleteStudentsByStudentId(@Param("schoolId") Integer schoolId);

    @Query(value = "Select distinct school_id from student", nativeQuery = true)
    List<Integer> getUniqueSchoolIdsFromStudents();

    @Query(value = "Select count(id) from student where id =?1", nativeQuery = true)
    Integer getCountOfStudentBySchoolId(Integer schoolId);
}
