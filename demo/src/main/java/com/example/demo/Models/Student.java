package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;


@Entity
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "Student_Name")
    String studentName;
    @Column(name = "Student_Age")
    Integer studentAge;


   @ManyToOne
   @JoinColumn(name = "School_id",referencedColumnName = "id")
    School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public Integer getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }



}
