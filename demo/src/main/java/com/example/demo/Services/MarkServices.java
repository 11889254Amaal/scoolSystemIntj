package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.CourseInterfase;
import com.example.demo.Repositories.MarkInterfase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MarkServices {

    @Autowired
    MarkInterfase markInterfase;

    @Autowired
    CourseInterfase courseInterfase;


    public void addMark(){
        Mark markToInsert = new Mark();
        markToInsert.setGrade("B");
        markToInsert.setObtainMark(89);
        markInterfase.save(markToInsert);
    }
    public List<Mark> getAllMark(){
        return markInterfase.getAllMark();
    }

    public Mark getMarkById(Integer id){

        return markInterfase.getMarkById(id);
    }

    public List<Mark> getAllActiveMarks(){

        return markInterfase.getAllActiveMarks();
    }

    public List<Mark> getAllNotActiveCourses(){

        return markInterfase.getAllNotActiveMark();
    }

    public List<Mark> getMarksByCourseName(String studentName){
        Course course = courseInterfase.getByCourseName(studentName);
        Integer courseId = course.getId();
        List<Mark> marksList = markInterfase.getMarksByCourseId(courseId);
        return marksList;
    }

    public Mark getLatestMark(){
        return markInterfase.getLatestMark();
    }

    public Mark getLatestUpdated() {


        return markInterfase.getLatestUpdated();
    }

    public List<Mark> getAllByGrade(String grade){
        List<Mark> mark = markInterfase.getAllByGrade(grade);
        return mark;
    }

    public List<Mark> getByObtainedMarksMoreThan(Integer obtainMark){
        List<Mark> mark = markInterfase.getByObtainedMarksMoreThan(obtainMark);
        return mark;
    }

    public List<Mark> getByObtainedMarksLessThan(Integer obtainMark){
        List<Mark> mark = markInterfase.getByObtainedMarksLessThan(obtainMark);
        return mark;
    }
    public List<Mark> getMarksByCourseId(Integer courseid){
        List<Mark> markList = markInterfase.getMarksByCourseId(courseid);
        return markList;
    }
    public void getDeleteAllmarkCreatedAfterDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Mark course = markInterfase.getDeleteAllMarkCreatedAfterDate(javaDate);
        course.setActive(false);
        markInterfase.save(course);

    }

    public Mark getmarkCreatedAfterDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return markInterfase.getMarkCreatedAfterDate(datecreated);
    }



    public Mark getmarkByUpdatedDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreated = format.parse(date);
        return markInterfase.getMarkByUpdatedDate(datecreated);
    }

    public Mark getDeletedAllmark(){

        return markInterfase.getDeletedAllMark();
    }

    public void getDeletemarksByCreatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Mark mark = markInterfase.getDeleteMarkByCreatedDate(javaDate);
        mark.setActive(false);
        markInterfase.save(mark);

    }

    public void getsetDeletemarksByUpdatedDate(String date) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Mark mark = markInterfase.getsetDeleteMarksByUpdatedDate(javaDate);
        mark.setActive(false);
        markInterfase.save(mark);

    }

    public void getDeleteCoursesByCourseid(Integer Courseid) throws ParseException {

        Mark mark = markInterfase.getDeleteMarksByCourseid(Courseid);
        mark.setActive(false);
        markInterfase.save(mark);

    }

    public void setCreatDateByUserInput(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Mark mark = markInterfase.getMarkById(id);
        mark.setCreatedDate(javaDate);
        mark.setGrade("A");
        mark.setObtainMark(95);
        markInterfase.save(mark);

    }

    public Mark getIdToDeleteMarkById(Integer id){

        return markInterfase.getIdToDeleteMarkById(id);
    }

}
