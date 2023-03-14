package com.example.demo.Repositories;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SchoolInterfase extends JpaRepository<School, Integer> {

    @Query(value = "SELECT s FROM School s")
    List<School> getAllSchools();

    @Query(value = "SELECT s from School s where s.id = :schoolId")
    School getSchoolById(@Param("schoolId") Integer id);

    @Query(value = "SELECT s from School s " +
            "WHERE s.Name = :schoolName")
    School getBySchoolName(@Param("schoolName") String schoolName);

    @Query(value = "SELECT s from School s where s.isActive = true")
    List<School> getAllActiveSchools();

    @Query(value = "SELECT s from School s where s.isActive = false")
    List<School> getAllNotActiveSchools();

    @Query(value = "SELECT s from School s where s.id=(SELECT max(s.id) from School s)")
    School getLatestSchools();
    @Query(value = "UPDATE Student s SET s.isActive = false WHERE s.id =:id")
    School getIdToDeleteSchoolById(@Param("id") Integer id);

    @Query(value ="select s from School s where s.updatedDate=(select max(updatedDate) from School)")
    School getLatestUpdated();
    @Query(value ="select s from School s where s.createdDate >= :date")
    <list>School getSchoolCreatedAfterDate(@Param("date") Date date);

    @Query(value="select s from School s where s.createdDate = :createdDate")
    School getSchoolByCreatedDate(@Param("createdDate") Date date);
    @Query(value="select s from School s where s.updatedDate = :updatedDate")
    School getSchoolByUpdatedDate(@Param("updatedDate") Date date);

    @Query(value = "UPDATE School s SET s.isActive = false")
    School getDeletedAllSchool();

    @Query(value = "UPDATE School s SET s.isActive = false where s.createdDate = :createdDate")
    <list> School getDeleteSchoolsByCreatedDate(@Param("createdDate") Date createdDate);


    @Query(value = "UPDATE School s SET s.isActive = false where s.updatedDate > :updatedDate")
    <list> School getsetDeleteSchoolsByUpdatedDate(@Param("updatedDate") Date createdDate);
    @Query(value = "UPDATE School s SET s.isActive = false where s.createdDate > :createdDate")
    School getDeleteAllSchoolsCreatedAfterDate(@Param("createdDate") Date createdDate);
    @Query(value = "UPDATE School s SET s.isActive = false WHERE s.Name = :schoolName")
    School getDeleteSchoolsBySchoolName(@Param("schoolName") String schoolName);


}



