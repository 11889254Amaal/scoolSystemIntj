package com.example.demo.Services;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolInterfase;
import com.example.demo.Repositories.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class SchoolServices {

    @Autowired
    StudentInterface studentInterface;

    @Autowired
    SchoolInterfase schoolInterfase;

    public void addSchool(){
        School schoolToInseert = new School();
        schoolToInseert.setName("TechMahindra");
        schoolInterfase.save(schoolToInseert);
    }

    public List<School> getAllSchools(){
       return schoolInterfase.getAllSchools();
    }

    public School getSchoollById(Integer id)
    {
        return schoolInterfase.getSchoolById(id);

    }


    public School getBySchoolName(String schoolName)
    {
        return schoolInterfase.getBySchoolName(schoolName);
    }

    public List<School> getAllActiveSchools(){

        return schoolInterfase.getAllActiveSchools();
    }

    public List<School> getAllNotActiveSchools(){

        return schoolInterfase.getAllNotActiveSchools();
    }

    public School getLatestSchool(){
        return schoolInterfase.getLatestSchools();
    }
    public School getIdToDeleteSchoolById(Integer id){

        return schoolInterfase.getIdToDeleteSchoolById(id);
    }

    public School getDeletedAllSchool(){

        return schoolInterfase.getDeletedAllSchool();
    }




    public void setCreatDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolInterfase.getSchoolById(id);
        school.setCreatedDate(javaDate);
        school.setName("AlMajd School");
        schoolInterfase.save(school);

    }


    public void getDeleteAllSchoolsCreatedAfterDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolInterfase.getDeleteAllSchoolsCreatedAfterDate(javaDate);
        school.setActive(false);

        schoolInterfase.save(school);

    }

    public void getDeleteSchoolsByCreatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolInterfase.getDeleteSchoolsByCreatedDate(javaDate);
        school.setActive(false);
        schoolInterfase.save(school);

    }

    public void getsetDeleteSchoolsByUpdatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolInterfase.getsetDeleteSchoolsByUpdatedDate(javaDate);
        school.setActive(false);
        schoolInterfase.save(school);

    }

    public void getDeleteSchoolsBySchoolName(String schoolName) throws ParseException {

        School school = schoolInterfase.getDeleteSchoolsBySchoolName(schoolName);
        school.setActive(false);
        schoolInterfase.save(school);

    }

    public School getLatestUpdated() {


        return schoolInterfase.getLatestUpdated();
    }

    public School getSchoolCreatedAfterDate(String date) throws ParseException {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date datecreated = format.parse(date);
    return schoolInterfase.getSchoolCreatedAfterDate(datecreated);
    }

    public School getSchoolByCreatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return schoolInterfase.getSchoolByCreatedDate(datecreated);
    }

    public School getSchoolByUpdatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return schoolInterfase.getSchoolByUpdatedDate(datecreated);
    }

    public List<School> getSchoolByNumberOfStudents(Integer numberOfStudents){
        List<Integer> schoolIds = studentInterface.getUniqueSchoolIdsFromStudents();
        HashMap<Integer, Integer> idCountMap = new HashMap<>();
        List<School> listOfSchoolByNumberOfStudent = new ArrayList<>();

        for (Integer id: schoolIds) {
            idCountMap.put(id, studentInterface.getCountOfStudentBySchoolId(id));
        }

        for (Integer id: idCountMap.keySet()) {
            if(idCountMap.get(id) == numberOfStudents){
                listOfSchoolByNumberOfStudent.add(schoolInterfase.getSchoolById(id));
            }
        }

        return listOfSchoolByNumberOfStudent;

    }
}
