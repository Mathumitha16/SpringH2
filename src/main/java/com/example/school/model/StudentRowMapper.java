package com.example.school.model;
import com.example.school.model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class StudentRowMapper implements RowMapper<Student>{
    public Student mapRow(ResultSet rs,int row) throws SQLException{
        return new Student(rs.getInt("STUDENTID"), 
        rs.getString("STUDENTNAME"), 
        rs.getString("GENDER"), 
        rs.getInt("STANDARD"));

    }
}
 

