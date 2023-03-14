package com.example.demo.Controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.RequestObject.CourseRequestForCreateDateUpdate;
import com.example.demo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.example.demo.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController {



    @Autowired
    CourseServices courseServices ;

    @RequestMapping(value="course/getById", method = RequestMethod.GET)
    public Course getCourseById(@RequestParam Integer id){
        Course course = courseServices.getCourseById(id);
        return course;
    }

    @RequestMapping(value="course/getAll", method = RequestMethod.GET)
    public List<Course> getAllCourse(){
        List<Course> course = courseServices.getAllCourse();
        return course;
    }



    @RequestMapping(value = "getAllCoursesByIsActive")
    public List<Course> getAllActiveCourses() {
        List<Course> activeCoursesList = courseServices.getAllActiveCourses();
        return activeCoursesList;
    }

    @RequestMapping(value = "getAllNotStudentByIsActive")
    public List<Course> getAllNotActiveCourses(){
        List<Course>  activeCoursesList = courseServices.getAllNotActiveCourses();
        return activeCoursesList;
    }


    @RequestMapping(value="getLatest", method = RequestMethod.GET)
    public Course getLatestCourse() {
        Course course = courseServices.getLatestCourse();
        return course;
    }
    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public Course getLatestUpdated(){
        Course course = courseServices.getLatestUpdated();
        return course;

    }
    @RequestMapping(value = "getCourseCreatedAfterDate", method = RequestMethod.GET)
    public <list>Course getCourseCreatedAfterDate(@RequestParam String date) throws ParseException {
        Course course = courseServices.getCourseCreatedAfterDate(date);
        return course;

    }

    @RequestMapping(value="getByCourseName", method = RequestMethod.GET)
    public Course getCourseByName(@RequestParam String courseName) {
        Course course = courseServices.getByCourseName(courseName);
        return course;
    }



    @RequestMapping(value = "getCourseByCreatedDate", method = RequestMethod.GET)
    public Course getCourseByCreatedDate(@RequestParam String date) throws ParseException {
        return courseServices.getCourseByCreatedDate(date);
    }

    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public Course getCourseByUpdatedDate(@RequestParam String date, Integer id) throws ParseException {
        return courseServices.getCourseByUpdatedDate(date);
    }

    @RequestMapping(value = "getCourseByStudentId", method = RequestMethod.GET)
    public List<Course> getCourseByStudentId(@RequestParam Integer studentid) {

        return courseServices.getCourseByStudentId(studentid);

    }
    @RequestMapping(value = "getAllActiveCoursesForAStudent")
    public List<Course> getAllActiveCoursesForAStudent(Integer studentId) {
        List<Course> activeCoursesList = courseServices.getAllActiveCoursesForAStudent(studentId);
        return activeCoursesList;
    }







    @RequestMapping(value="getIdToDeleteCourseById", method = RequestMethod.GET)
    public Course getIdToDeleteCourseById(@RequestParam Integer id){
        Course Course = courseServices.getIdToDeleteCourseById(id);
        return Course;
    }


    @RequestMapping(value="DeletedAllCourse", method = RequestMethod.POST)
    public Course setDeletedAllStudent(){
        Course course = courseServices.getDeletedAllCourse();
        return course;
    }

    @RequestMapping(value = "deleteAllCoursesCreatedAfterDate", method = RequestMethod.POST)
    public void setDeleteAllCoursesCreatedAfterDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        courseServices.getDeleteAllCourseCreatedAfterDate(date.getDate());

    }

    @RequestMapping(value = "deleteByCourseName", method = RequestMethod.POST)
    public void setdeleteByCourseName(@RequestParam String courseName) throws ParseException {
        courseServices.getDeleteCoursesByCourseName(courseName);

    }




    @RequestMapping(value = "deleteCoursesByCreatedDate", method = RequestMethod.POST)
    public void setDeleteCoursesByCreatedDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        courseServices.getDeleteCoursesByCreatedDate(date.getDate());

    }

    @RequestMapping(value = "deleteCoursesByUpdatedDate", method = RequestMethod.POST)
    public void setDeleteSchoolsByUpdatedDate(@RequestParam CourseRequestForCreateDateUpdate date) throws ParseException {
        courseServices.getsetDeleteCoursesByUpdatedDate(date.getDate());

    }


    @RequestMapping (value ="addCourse", method = RequestMethod.POST)
    public String addCourse(){
        courseServices.addCourse();
        return "Course Insert Successfully";

    }

    @RequestMapping(value="updateCreatedDateByUserInput",method = RequestMethod.POST)
    public void setCreatDateByUserInput(@RequestBody CourseRequestForCreateDateUpdate data) throws ParseException {
        courseServices.setCreatDateByUserInput(data.getDate(), data.getId());
    }
}
