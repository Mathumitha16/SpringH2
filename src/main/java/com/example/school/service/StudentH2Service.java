package com.example.school.service;
import com.example.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.school.model.*;
@Service
public class StudentH2Service implements StudentRepository{
    @Autowired
    private JdbcTemplate db;
    public ArrayList<Student> getStudents(){
        List<Student> st = db.query("SELECT * FROM STUDENT",new StudentRowMapper());
        ArrayList<Student> stud = new ArrayList<>(st);
        return stud;


    }
    public Student getStudentById(int id){
        try{
            Student stud = db.queryForObject("SELECT * FROM STUDENT WHERE STUDENTID=?",new StudentRowMapper(),id);
            return stud;

        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public Student addStudent(Student st){
        db.update("INSERT INTO STUDENT(STUDENTNAME,GENDER,STANDARD) VALUES(?,?,?)",st.getStudentName(),st.getGender(),st.getStandard());
        Student stud = db.queryForObject("SELECT * FROM STUDENT WHERE STUDENTNAME=? AND GENDER=? AND STANDARD=?",new StudentRowMapper(),st.getStudentName(),st.getGender(),st.getStandard());
        return stud;

        
    }
    public Student updateStudent(int id, Student st){
        try{
            if(st.getStudentName()!=null){
                db.update("UPDATE STUDENT SET STUDENTNAME=? WHERE STUDENTID=?",st.getStudentName(),id);
            }
            if(st.getGender()!=null){
                 db.update("UPDATE STUDENT SET GENDER=? WHERE STUDENTID=?",st.getGender(),id);



            }
            if(st.getStandard()>0){
                db.update("UPDATE STUDENT SET STANDARD=? WHERE STUDENTID=?",st.getStandard(),id);
            }
              Student stud = db.queryForObject("SELECT * FROM STUDENT WHERE STUDENTID=?",new StudentRowMapper(),id);
              return stud;


        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public void deleteStudent(int id){
        db.update("DELETE FROM STUDENT WHERE STUDENTID=?",id);
    }
    public String addBulk(List<Student> ls){
        ArrayList<Student> temp = new ArrayList<>(ls);
        int size = temp.size();
        for(Student s : temp){
            addStudent(s);
        }
        String ans ="Successfully added "+size+" students";
        return ans; 


    }

}
 