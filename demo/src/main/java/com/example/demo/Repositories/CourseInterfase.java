package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseInterfase extends CrudRepository<Course, Integer> {
    @Query("SELECT c FROM Course c")
    List<Course> getAllCourse();


    @Query(value = "SELECT s FROM Course s WHERE s.id =:id")
    Course getCourseById(@Param("id") Integer id);

    @Query(value = "SELECT s from Course s where s.isActive = true")
    List<Course> getAllActiveCourses();


    @Query(value = "SELECT s from Course s where s.isActive = true AND s.student.id =:id")
    List<Course> getAllActiveCoursesForAStudent(@Param("id") Integer id);

    @Query(value = "SELECT s from Course s where s.isActive = false")
    List<Course> getAllNotActiveCourse();

    @Query(value = "SELECT st from Course st " +
            "WHERE st.student.id = :id ")
    List<Course> getCourseByStudentId(@Param("id") Integer id);

    @Query(value = "SELECT s from Course s " +
            "WHERE s.CourseName = :courseName")
    Course getByCourseName(@Param("courseName") String courseName);

    @Query(value = "SELECT s from Course s where s.id=(SELECT max(s.id) from Course s)")
    Course getLatestCourse();

    @Query(value = "UPDATE Course s SET s.isActive = false WHERE s.id =:id")
    Course getIdToDeleteCourseById(@Param("id") Integer id);

    @Query(value ="select s from Course s where s.updatedDate=(select max(updatedDate) from Course)")
    Course getLatestUpdated();

    @Query(value ="select s from Course s where s.createdDate >= :date")
    <list>Course getCourseCreatedAfterDate(@Param("date") Date date);

    @Query(value="select s from Course s where s.createdDate = :createdDate")
    Course getCourseByCreatedDate(@Param("createdDate") Date date);

    @Query(value="select s from Course s where s.updatedDate = :updatedDate")
    Course getCourseByUpdatedDate(@Param("updatedDate") Date date);
    @Query(value = "UPDATE Course s SET s.isActive = false")
    Course getDeletedAllCourse();

    @Query(value = "UPDATE Course s SET s.isActive = false where s.createdDate > :createdDate")
    Course getDeleteAllCourseCreatedAfterDate(@Param("createdDate") Date createdDate);


    @Query(value = "UPDATE Course s SET s.isActive = false where s.createdDate = :createdDate")
    <list> Course getDeleteCoursesByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value = "UPDATE Course s SET s.isActive = false where s.updatedDate > :updatedDate")
    <list> Course getsetDeleteCoursesByUpdatedDate(@Param("updatedDate") Date createdDate);
    @Query(value = "UPDATE Course s SET s.isActive = false WHERE s.CourseName = :CourseName")
    Course getDeleteCoursesByCourseName(@Param("CourseName") String schoolName);


}
