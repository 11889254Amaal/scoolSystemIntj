package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolInterfase;
import com.example.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServices {

    @Autowired
    StudentInterface studentInterface;
    @Autowired
    SchoolInterfase schoolInterfase;

    public void addStudent(){
        Student studentToInseert = new Student();
        studentToInseert.setStudentName("Ahd Yahya");
        studentToInseert.setStudentAge(29);
        studentInterface.save(studentToInseert);
    }
//    public void deleteStudent(@RequestParam Integer id){
//        Student studentToDelete = studentInterface.findById(id).get();
//        studentInterface.delete(studentToDelete);
//    }
public List<Student> getAllStudent(){

    return studentInterface.getAllStudent();
}

    public Student getStudentById(Integer id){

        return studentInterface.getStudentById(id);
    }

    public Student getByStudentName(String schoolName)
    {
        return studentInterface.getByStudentName(schoolName);
    }
    public List<Student> getStudentsBySchoolName(String schoolName){
        School school = schoolInterfase.getBySchoolName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentInterface.getStudentsBySchoolId(schoolId);
        return studentList;
    }

    public List<Student> getStudentsBySchoolId(Integer schoolid){
        List<Student> studentList = studentInterface.getStudentsBySchoolId(schoolid);
        return studentList;
    }

    public List<Student> getStudentsByStudentAge(Integer studentAge)
    {
        return studentInterface.getByStudentAge(studentAge);
    }

    public List<Student> getAllActiveStudents(){

        return studentInterface.getAllActiveStudent();
    }

    public List<Student> getAllNotActiveStudents(){

        return studentInterface.getAllNotActiveStudent();
    }

    public Student getLatestStudent(){
        return studentInterface.getLatestStudent();
    }
    public Student getIdToDeleteStudentById(Integer id){

        return studentInterface.getIdToDeleteStudentById(id);
    }
    public Student getLatestUpdated() {


        return studentInterface.getLatestUpdated();
    }



    public Student getStudentCreatedAfterDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return studentInterface.getStudentCreatedAfterDate(datecreated);
    }


    public Student getStudentByUpdatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return studentInterface.getStudentByUpdatedDate(datecreated);
    }


    public Student getStudentByCreatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return studentInterface.getStudentByCreatedDate(datecreated);
    }


    public Student getDeletedAllSchool(){

        return studentInterface.getDeletedAllStudent();
    }



    public void setCreatDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Student student = studentInterface.getStudentById(id);
        student.setCreatedDate(javaDate);
        student.setStudentAge(25);
        student.setStudentName("Ahdoonh");
        studentInterface.save(student);

    }

    public Student getDeletedAllStudent(){

        return studentInterface.getDeletedAllStudent();
    }

    public void setDeleteAllStudentsCreatedAfterDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Student student = studentInterface.getDeleteAllStudentsCreatedAfterDate(javaDate);
        student.setActive(false);
        studentInterface.save(student);

    }

    public void getDeleteStudentsByCreatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Student student = studentInterface.getDeleteStudentsByCreatedDate(javaDate);
        student.setActive(false);
        studentInterface.save(student);

    }

    public void setDeleteStudentsByUpdatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Student student = studentInterface.getsetDeleteStudentsByUpdatedDate(javaDate);
        student.setActive(false);
        studentInterface.save(student);

    }

    public void getDeleteStudentsByStudentName(String schoolName) throws ParseException {

        Student student = studentInterface.getDeleteStudentsByStudentName(schoolName);
        student.setActive(false);
        studentInterface.save(student);

    }

    public void getDeleteStudentsByStudentAge(Integer schoolAge) throws ParseException {

        Student student = studentInterface.getDeleteStudentsByStudentAge(schoolAge);
        student.setActive(false);
        studentInterface.save(student);

    }

    public void getDeleteStudentsByStudentId(Integer schoolId) throws ParseException {

        Student student = studentInterface.getDeleteStudentsByStudentId(schoolId);
        student.setActive(false);
        studentInterface.save(student);

    }












}
