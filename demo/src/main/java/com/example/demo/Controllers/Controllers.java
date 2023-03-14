package com.example.demo.Controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Services.*;
import com.example.demo.slacks.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityResultHandler;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class Controllers {
    @GetMapping(value ="hello")
    public String getHello(){
        return "hello To TechnoPark";
    }
    @GetMapping(value ="fullName")
    public String getFullName(String firstName, String lastName){
        firstName = "AHD ";
        lastName = "ALZAKWANI";
        return "My Name Is "+firstName+" "+lastName;
    }

    @GetMapping(value = "slacMessage")
    public void message(@RequestParam String text){

        slackClient.sendMessage(text);
    }





    @Autowired
    SchoolServices schoolServices;

    @Autowired
    SlackClient slackClient;
    @Autowired
    StudentServices studentServices;

    @Autowired
    CourseServices courseServices ;

    @Autowired
    MarkServices markServices  ;





//    @RequestMapping(value="student/getByName", method = RequestMethod.GET)
//    public List<Student> getSchoollByName(@RequestParam String name){
//        return studentServices.getSchoollByName(name);
//    }
//    @GetMapping(value ="addStudent")
//    public String addStudent(){
//
//        studentServices.addStudent();
//        return "Student Add Successfull";
//
//    }
//    @GetMapping(value ="deleteStudent")
//    public String deleteStudentById(Integer id){
//
//        studentServices.deleteStudent(id);
//        return "Student Delete Successfull";
//    }


    @RequestMapping(value = "student/getStudentsBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolName(@RequestParam String schoolName) {

        return studentServices.getStudentsBySchoolName(schoolName);

    }

    @RequestMapping(value = "student/getCoursesByStudentName", method = RequestMethod.GET)
    public List<Course> getCoursesByStudentName(@RequestParam String StudentName) {

        return courseServices.getCoursesByStudentName(StudentName);

    }


    @RequestMapping(value = "student/getMarksByCourseName", method = RequestMethod.GET)
    public List<Mark> getMarksByCourseName(@RequestParam String CourseName) {

        return markServices.getMarksByCourseName(CourseName);

    }
}
