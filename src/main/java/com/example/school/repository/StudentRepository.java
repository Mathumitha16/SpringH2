package com.example.school.repository;
import java.util.*;
import com.example.school.model.*;
public interface StudentRepository{
    ArrayList<Student> getStudents();
    Student getStudentById(int id);
    Student addStudent(Student s);
    String addBulk(List<Student> ls);
    Student updateStudent(int id,Student s);
    void deleteStudent(int id);
}