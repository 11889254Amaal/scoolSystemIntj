package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MarkInterfase extends CrudRepository<Mark, Integer> {

    @Query("SELECT m FROM Mark m")
    List<Mark> getAllMark();

    @Query(value = "SELECT m FROM Mark m WHERE m.id =:id")
    Mark getMarkById(@Param("id") Integer id);

    @Query(value = "SELECT s from Mark s where s.isActive = true")
    List<Mark> getAllActiveMarks();

    @Query(value = "SELECT s from Mark s where s.isActive = false")
    List<Mark> getAllNotActiveMark();


    @Query(value = "SELECT m FROM Mark m WHERE m.grade =:grade")
    List<Mark> getAllByGrade(@Param("grade") String grade);

    @Query(value = "SELECT m FROM Mark m WHERE m.obtainMark >:obtainMark")
    List<Mark> getByObtainedMarksMoreThan(@Param("obtainMark") Integer obtainMark);

    @Query(value = "SELECT m FROM Mark m WHERE m.obtainMark <:obtainMark")
    List<Mark> getByObtainedMarksLessThan(@Param("obtainMark") Integer obtainMark);

    @Query(value = "SELECT st from Mark st " +
            "WHERE st.course.id = :id ")
    List<Mark> getMarksByCourseId(@Param("id") Integer id);

    @Query(value = "SELECT s from Mark s where s.id=(SELECT max(s.id) from Mark s)")
    Mark getLatestMark();

    @Query(value ="select s from Course s where s.updatedDate=(select max(updatedDate) from Course)")
    Mark getLatestUpdated();
    @Query(value ="select s from Mark s where s.createdDate >= :date")
    <list>Mark getMarkCreatedAfterDate(@Param("date") Date date);



    @Query(value="select s from Mark s where s.updatedDate = :updatedDate")
    Mark getMarkByUpdatedDate(@Param("updatedDate") Date date);
    @Query(value = "UPDATE Course s SET s.isActive = false")
    Mark getDeletedAllMark();

    @Query(value = "UPDATE Mark s SET s.isActive = false where s.createdDate > :createdDate")
    Mark getDeleteAllMarkCreatedAfterDate(@Param("createdDate") Date createdDate);


    @Query(value = "UPDATE Mark s SET s.isActive = false where s.createdDate = :createdDate")
    <list> Mark getDeleteMarkByCreatedDate(@Param("createdDate") Date createdDate);

    @Query(value = "UPDATE Mark s SET s.isActive = false where s.updatedDate > :updatedDate")
    <list> Mark getsetDeleteMarksByUpdatedDate(@Param("updatedDate") Date createdDate);
    @Query(value = "UPDATE Mark s SET s.isActive = false WHERE s.course.id= :courseid")
    Mark getDeleteMarksByCourseid(@Param("courseid") Integer courseid);

    @Query(value = "UPDATE Mark s SET s.isActive = false WHERE s.id =:id")
    Mark getIdToDeleteMarkById(@Param("id") Integer id);

}
