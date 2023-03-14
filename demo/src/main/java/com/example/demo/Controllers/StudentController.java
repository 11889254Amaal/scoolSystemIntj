package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.example.demo.RequestObject.StudentRequestForCreateDateUpdate;
import com.example.demo.Services.StudentServices;
import com.example.demo.slacks.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {
    @Autowired
    StudentServices studentServices;
    @Autowired
    SlackClient slackClient;


    @RequestMapping(value="student/getById", method = RequestMethod.GET)
    public Student getStudentById(@RequestParam Integer id){

        Student student = studentServices.getStudentById(id);
        slackClient.sendMessage(student.getId().toString());
        slackClient.sendMessage(student.getStudentName());
        slackClient.sendMessage(student.getActive().toString());

        slackClient.sendMessage(student.getCreatedDate().toString());
        slackClient.sendMessage("====================================");
        return student;
    }
    @RequestMapping(value="student/getAll", method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student> student = studentServices.getAllStudent();
            for (Student s:student
            ) {
                slackClient.sendMessage(s.getId().toString());
                slackClient.sendMessage(s.getStudentName());
                slackClient.sendMessage(s.getActive().toString());

                slackClient.sendMessage(s.getCreatedDate().toString());
            }

        return student;
    }




    @RequestMapping(value = "getAllStudentByIsActive")
    public List<Student> getAllActiveStudents(){
        List<Student>  activeStudentsList = studentServices.getAllActiveStudents();


        for (Student s:activeStudentsList
        ) {
            slackClient.sendMessage(s.getId().toString());
            slackClient.sendMessage(s.getStudentName());
            slackClient.sendMessage(s.getActive().toString());

            slackClient.sendMessage(s.getCreatedDate().toString());
        }

        return activeStudentsList;
    }

    @RequestMapping(value = "getAllNotStudentByIsActive")
    public List<Student> getAllNotActiveStudents(){
        List<Student>  activeStudentsList = studentServices.getAllNotActiveStudents();

        for (Student s:activeStudentsList
        ) {
            slackClient.sendMessage(s.getId().toString());
            slackClient.sendMessage(s.getStudentName());
            slackClient.sendMessage(s.getActive().toString());

            slackClient.sendMessage(s.getCreatedDate().toString());
        }

        return activeStudentsList;
    }

    @RequestMapping(value="getLatest", method = RequestMethod.GET)
    public Student getLatestStudent() {
        Student student = studentServices.getLatestStudent();
        slackClient.sendMessage(student.getId().toString());
        slackClient.sendMessage(student.getStudentName());
        slackClient.sendMessage(student.getActive().toString());

        slackClient.sendMessage(student.getCreatedDate().toString());

        return student;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public Student getLatestUpdated(){
        Student student = studentServices.getLatestUpdated();


        slackClient.sendMessage(student.getId().toString());
        slackClient.sendMessage(student.getStudentName());
        slackClient.sendMessage(student.getActive().toString());

        slackClient.sendMessage(student.getCreatedDate().toString());

        return student;

    }
    @RequestMapping(value = "getStudentCreatedAfterDate", method = RequestMethod.GET)
    public <list>Student getSchoolCreatedAfterDate(@RequestParam String date) throws ParseException {
        Student student = studentServices.getStudentCreatedAfterDate(date);
        slackClient.sendMessage("Get after Date");
        slackClient.sendMessage(student.getId().toString());
        slackClient.sendMessage(student.getStudentName());
        slackClient.sendMessage(student.getActive().toString());

        slackClient.sendMessage(student.getCreatedDate().toString());
        return student;
    }

    @RequestMapping(value="getByStudentName", method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam String studentName) {
        Student student = studentServices.getByStudentName(studentName);


        slackClient.sendMessage("Get school by name");
        slackClient.sendMessage(student.getId().toString());
        slackClient.sendMessage(student.getStudentName());
        slackClient.sendMessage(student.getActive().toString());

        slackClient.sendMessage(student.getCreatedDate().toString());

        return student;
    }

    @RequestMapping(value="getByStudentAge", method = RequestMethod.GET)
    public List<Student> getStudentByStudentAge(@RequestParam Integer studentAge) {
        List<Student> student = studentServices.getStudentsByStudentAge(studentAge);

        for (Student s:student
        ) {

            slackClient.sendMessage(s.getId().toString());
            slackClient.sendMessage(s.getStudentName());
            slackClient.sendMessage(s.getActive().toString());

            slackClient.sendMessage(s.getCreatedDate().toString());
        }
        return student;
    }

    @RequestMapping(value = "student/getStudentsBySchoolid", method = RequestMethod.GET)
    public List<Student> getStudentsBySchoolId(@RequestParam Integer schoolid) {
        Student student = (Student) studentServices.getStudentsBySchoolId(schoolid);

        slackClient.sendMessage(student.getId().toString());
        slackClient.sendMessage(student.getStudentName());
        slackClient.sendMessage(student.getActive().toString());

        slackClient.sendMessage(student.getCreatedDate().toString());
        return (List<Student>) student;
    }




    @RequestMapping(value = "getStudentByCreatedDate", method = RequestMethod.GET)
    public Student getSchoolByCreatedDate(@RequestParam String date) throws ParseException {

        Student  student = studentServices.getStudentByCreatedDate(date);
        slackClient.sendMessage("Get after Date");
        slackClient.sendMessage(student.getId().toString());
        slackClient.sendMessage(student.getStudentName());
        slackClient.sendMessage(student.getActive().toString());

        slackClient.sendMessage(student.getCreatedDate().toString());


        return student;

    }

    @RequestMapping(value = "getStudentByUpdatedDate", method = RequestMethod.GET)
    public Student getStudentByUpdatedDate(@RequestParam String date, Integer id) throws ParseException {


        Student  student = studentServices.getStudentByUpdatedDate(date);
        slackClient.sendMessage("Get after Date");
        slackClient.sendMessage(student.getId().toString());
        slackClient.sendMessage(student.getStudentName());
        slackClient.sendMessage(student.getActive().toString());

        slackClient.sendMessage(student.getCreatedDate().toString());


        return student;
    }


    @RequestMapping(value="getIdToDeleteStudentById", method = RequestMethod.GET)
    public Student getIdToDeleteStudentById(@RequestParam Integer id){
        Student student = studentServices.getIdToDeleteStudentById(id);
        return student;
    }

    @RequestMapping(value="DeletedAllStudent", method = RequestMethod.POST)
    public Student setDeletedAllStudent(){
        Student student = studentServices.getDeletedAllStudent();
        return student;
    }

    @RequestMapping(value = "deleteAllStudentsCreatedAfterDate", method = RequestMethod.POST)
    public void setDeleteAllStudentsCreatedAfterDate(@RequestParam StudentRequestForCreateDateUpdate date) throws ParseException {
        studentServices.setDeleteAllStudentsCreatedAfterDate(date.getDate());

    }

    @RequestMapping(value = "deleteStudentsByStudentName", method = RequestMethod.POST)
    public void setDeleteStudentsByStudentName(@RequestParam String studentName) throws ParseException {
        studentServices.getDeleteStudentsByStudentName(studentName);

    }

    @RequestMapping(value = "deleteStudentsByStudentAge", method = RequestMethod.POST)
    public void setDeleteStudentsByStudentAge(@RequestParam Integer studentAge) throws ParseException {
        studentServices.getDeleteStudentsByStudentAge(studentAge);

    }

    @RequestMapping(value = "deleteStudentsBySchoolId", method = RequestMethod.POST)
    public void setDeleteStudentsBySchoolId(@RequestParam Integer schoolId) throws ParseException {
        studentServices.getDeleteStudentsByStudentId(schoolId);

    }






    @RequestMapping(value = "deleteStudentsByCreatedDate", method = RequestMethod.POST)
    public void setDeleteStudentsByCreatedDate(@RequestParam StudentRequestForCreateDateUpdate date) throws ParseException {
        studentServices.getDeleteStudentsByCreatedDate(date.getDate());

    }

    @RequestMapping(value = "deleteStudentsByUpdatedDate", method = RequestMethod.POST)
    public void setDeleteStudentsByUpdatedDate(@RequestParam StudentRequestForCreateDateUpdate date) throws ParseException {
        studentServices.setDeleteStudentsByUpdatedDate(date.getDate());

    }



    @RequestMapping (value ="addStudent", method = RequestMethod.POST)
    public String addStudent(){
        studentServices.addStudent();
        return "Student Add Successfull";

    }

    @RequestMapping(value="updateCreatedDateByUserInput",method = RequestMethod.POST)
    public void setCreatDateByUserInput(@RequestBody StudentRequestForCreateDateUpdate data) throws ParseException {
        studentServices.setCreatDateByUserInput(data.getDate(), data.getId());
    }

}
