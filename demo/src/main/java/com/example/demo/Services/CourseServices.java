package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.CourseInterfase;
import com.example.demo.Repositories.SchoolInterfase;
import com.example.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CourseServices {

    @Autowired
    CourseInterfase courseInterfase;
    @Autowired
    StudentInterface studentInterface ;

    public void addCourse(){

        Course courseToInsert = new Course();
        courseToInsert.setCourseName("Java");
        courseInterfase.save(courseToInsert);

    }



    public List<Course> getAllCourse(){
        return courseInterfase.getAllCourse();
    }

    public Course getCourseById(Integer id){

        return courseInterfase.getCourseById(id);
    }

    public List<Course> getAllActiveCourses(){

        return courseInterfase.getAllActiveCourses();
    }

    public List<Course> getAllActiveCoursesForAStudent(Integer studentId){

        return courseInterfase.getAllActiveCoursesForAStudent(studentId);
    }
    public List<Course> getAllNotActiveCourses(){

        return courseInterfase.getAllNotActiveCourse();
    }
    public Course getByCourseName(String courseName)
    {
        return courseInterfase.getByCourseName(courseName);
    }
    public List<Course> getCoursesByStudentName(String studentName){
        Student student = studentInterface.getByStudentName(studentName);
        Integer studentId = student.getId();
        List<Course> courseList = courseInterfase.getCourseByStudentId(studentId);
        return courseList;
    }


    public Course getLatestCourse(){
        return courseInterfase.getLatestCourse();
    }

    public List<Course> getCourseByStudentId(Integer studentid){
        List<Course> courseList = courseInterfase.getCourseByStudentId(studentid);
        return courseList;
    }
    public Course getIdToDeleteCourseById(Integer id){

        return courseInterfase.getIdToDeleteCourseById(id);
    }

    public Course getLatestUpdated() {


        return courseInterfase.getLatestUpdated();
    }

    public void getDeleteAllCourseCreatedAfterDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Course course = courseInterfase.getDeleteAllCourseCreatedAfterDate(javaDate);
        course.setActive(false);
        courseInterfase.save(course);

    }

    public Course getCourseCreatedAfterDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return courseInterfase.getCourseCreatedAfterDate(datecreated);
    }

    public Course getCourseByCreatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return courseInterfase.getCourseByCreatedDate(datecreated);
    }

    public Course getCourseByUpdatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return courseInterfase.getCourseByUpdatedDate(datecreated);
    }

    public Course getDeletedAllCourse(){

        return courseInterfase.getDeletedAllCourse();
    }

    public void getDeleteCoursesByCreatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Course course = courseInterfase.getDeleteCoursesByCreatedDate(javaDate);
        course.setActive(false);
        courseInterfase.save(course);

    }

    public void getsetDeleteCoursesByUpdatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Course course = courseInterfase.getsetDeleteCoursesByUpdatedDate(javaDate);
        course.setActive(false);
        courseInterfase.save(course);

    }

    public void getDeleteCoursesByCourseName(String CourseName) throws ParseException {

        Course course = courseInterfase.getDeleteCoursesByCourseName(CourseName);
        course.setActive(false);
        courseInterfase.save(course);

    }

    public void setCreatDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Course course = courseInterfase.getCourseById(id);
        course.setCreatedDate(javaDate);
        course.setCourseName("C++");
        courseInterfase.save(course);

    }
}
