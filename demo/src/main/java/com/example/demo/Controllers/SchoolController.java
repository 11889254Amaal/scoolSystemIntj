package com.example.demo.Controllers;

import com.example.demo.Models.School;
import com.example.demo.RequestObject.SchoolRequest;
import com.example.demo.RequestObject.SchoolRequestForCreateDateUpdate;
import com.example.demo.Services.SchoolServices;
import com.example.demo.slacks.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping(value = "school")
public class SchoolController {
    @Autowired
    SchoolServices schoolServices;
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value="school/getById", method = RequestMethod.GET)
    public School getSchoollById(@RequestParam Integer id){
        School school = schoolServices.getSchoollById(id);
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getName());
        slackClient.sendMessage(school.getActive().toString());
   
        slackClient.sendMessage(school.getCreatedDate().toString());
        slackClient.sendMessage("====================================");

        return school;
    }
    @RequestMapping(value="school/getAll", method = RequestMethod.GET)
    public <schools> List<School> getAllSchool(){
        List<School> schools = schoolServices.getAllSchools();
        for (School s:schools
             ) {
            slackClient.sendMessage(s.getId().toString());
            slackClient.sendMessage(s.getName());
            slackClient.sendMessage(s.getActive().toString());

            slackClient.sendMessage(s.getCreatedDate().toString());
        }

        return schools;
    }

    @RequestMapping(value = "getAllSchoolByIsActive")
    public List<School> getAllActiveSchools(){
        List<School>  activeSchoolsList = schoolServices.getAllActiveSchools();
        for (School s:activeSchoolsList
        ) {
            slackClient.sendMessage(s.getId().toString());
            slackClient.sendMessage(s.getName());
            slackClient.sendMessage(s.getActive().toString());

            slackClient.sendMessage(s.getCreatedDate().toString());
        }
        return activeSchoolsList;
    }

    @RequestMapping(value = "getAllSchoolByIsNotActive")
    public List<School> getAllNotActiveSchools(){
        List<School>  activeSchoolsList = schoolServices.getAllNotActiveSchools();
        for (School s:activeSchoolsList
        ) {
            slackClient.sendMessage(s.getId().toString());
            slackClient.sendMessage(s.getName());
            slackClient.sendMessage(s.getActive().toString());

            slackClient.sendMessage(s.getCreatedDate().toString());
        }
        return activeSchoolsList;
    }

    @RequestMapping(value="getLatest", method = RequestMethod.GET)
    public School getLatestSchool() {
        School schools = schoolServices.getLatestSchool();
        slackClient.sendMessage(schools.getId().toString());
        slackClient.sendMessage(schools.getName());
        slackClient.sendMessage(schools.getActive().toString());

        slackClient.sendMessage(schools.getCreatedDate().toString());
        return schools;
    }

    @RequestMapping(value = "getLatestUpdated", method = RequestMethod.GET)

    public School getLatestUpdated(){
        School school = schoolServices.getLatestUpdated();
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getName());
        slackClient.sendMessage(school.getActive().toString());

        slackClient.sendMessage(school.getCreatedDate().toString());
        return school;

    }

    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public <list>School getSchoolCreatedAfterDate(@RequestParam String date) throws ParseException {
         School  school = schoolServices.getSchoolCreatedAfterDate(date);


            slackClient.sendMessage("Get after Date");
            slackClient.sendMessage(school.getId().toString());
            slackClient.sendMessage(school.getName());
            slackClient.sendMessage(school.getActive().toString());

            slackClient.sendMessage(school.getCreatedDate().toString());


        return school;
    }

    @RequestMapping(value="school/getBySchoolName", method = RequestMethod.GET)
    public School getSchoolByName(@RequestParam String schoolName) {
        School school = schoolServices.getBySchoolName(schoolName);

        slackClient.sendMessage("Get school by name");
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getName());
        slackClient.sendMessage(school.getActive().toString());

        slackClient.sendMessage(school.getCreatedDate().toString());
        return school;
    }



    @RequestMapping(value = "/getSchoolByCreatedDate", method = RequestMethod.GET)
    public School getSchoolByCreatedDate(@RequestParam String date) throws ParseException {

         School school = schoolServices.getSchoolByCreatedDate(date);
        slackClient.sendMessage("Get school by name");
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getName());
        slackClient.sendMessage(school.getActive().toString());

        slackClient.sendMessage(school.getCreatedDate().toString());
         return school;
    }

    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public School getSchoolByUpdatedDate(@RequestParam String date, Integer id) throws ParseException {
        School school = schoolServices.getSchoolByUpdatedDate(date);
        slackClient.sendMessage("Get school by date");
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getName());
        slackClient.sendMessage(school.getActive().toString());
        slackClient.sendMessage(school.getUpdatedDate().toString());
        slackClient.sendMessage(school.getCreatedDate().toString());
        return school;

    }


    ////getSchoolByNumberOfStudents
@RequestMapping(value = "getSchoolByNumberOfStudents", method = RequestMethod.GET)
public List<School> getSchoolByNumberOfStudents(@RequestParam Integer numberOfStudents){

     School school = (School) schoolServices.getSchoolByNumberOfStudents(numberOfStudents);
    slackClient.sendMessage("Get school by date");
    slackClient.sendMessage(school.getId().toString());
    slackClient.sendMessage(school.getName());
    slackClient.sendMessage(school.getActive().toString());
    slackClient.sendMessage(school.getUpdatedDate().toString());
    slackClient.sendMessage(school.getCreatedDate().toString());
    return (List<School>) school;
}


    @RequestMapping(value="getIdToDeleteSchoolById", method = RequestMethod.POST)
    public School setIdToDeleteSchoolById(@RequestParam Integer id){
        School school = schoolServices.getIdToDeleteSchoolById(id);
        slackClient.sendMessage("Get school by id");
        slackClient.sendMessage(school.getId().toString());
        slackClient.sendMessage(school.getName());
        slackClient.sendMessage(school.getActive().toString());
        slackClient.sendMessage(school.getUpdatedDate().toString());
        slackClient.sendMessage(school.getCreatedDate().toString());
        return school;
    }


    @RequestMapping(value="DeletedAllSchool", method = RequestMethod.POST)
    public School setDeletedAllStudent(){
        School school = schoolServices.getDeletedAllSchool();

        return school;
    }

    @RequestMapping(value = "deleteAllSchoolsCreatedAfterDate", method = RequestMethod.POST)
    public void setDeleteAllSchoolsCreatedAfterDate(@RequestParam SchoolRequestForCreateDateUpdate date) throws ParseException {
        schoolServices.getDeleteAllSchoolsCreatedAfterDate(date.getDate());

    }


    @RequestMapping(value = "deleteSchoolsBySchoolName", method = RequestMethod.POST)
    public void setDeleteSchoolsBySchoolName(@RequestParam String schoolName) throws ParseException {
        schoolServices.getDeleteSchoolsBySchoolName(schoolName);

    }


    @RequestMapping(value = "deleteSchoolsByCreatedDate", method = RequestMethod.POST)
    public void setDeleteSchoolsByCreatedDate(@RequestParam SchoolRequestForCreateDateUpdate date) throws ParseException {
        schoolServices.getDeleteSchoolsByCreatedDate(date.getDate());

    }

    @RequestMapping(value = "deleteSchoolsByUpdatedDate", method = RequestMethod.POST)
    public void setDeleteSchoolsByUpdatedDate(@RequestParam SchoolRequestForCreateDateUpdate date) throws ParseException {
        schoolServices.getsetDeleteSchoolsByUpdatedDate(date.getDate());

    }





    @RequestMapping (value ="addSchool", method = RequestMethod.POST)
    public String addSchool(){
        schoolServices.addSchool();
        return "School Add Successfull";

    }

    @RequestMapping(value="updateCreatedDateByUserInput",method = RequestMethod.POST)
    public void setCreatDateByUserInput(@RequestBody SchoolRequestForCreateDateUpdate data) throws ParseException {
        schoolServices.setCreatDateByUserInput(data.getDate(), data.getId());
    }






}
