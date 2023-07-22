package com.example.school.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.school.model.*;
import com.example.school.service.StudentH2Service;
@RestController
public class StudentController{
    @Autowired
    public StudentH2Service td;
    @GetMapping("/students")
    public ArrayList<Student> getTodo(){
        return td.getStudents();

    }
    @GetMapping("/students/{id}")
    public Student getTodoById(@PathVariable("id") int id){
        return td.getStudentById(id);

    }
    @PostMapping("/students")
    public Student addTodo(@RequestBody Student t){
        return td.addStudent(t);
    }
    @PostMapping("/students/bulk")
    public String addTodos(@RequestBody List<Student> t){
        return td.addBulk(t);
    }
    @PutMapping("/students/{id}")
    public Student updateTodo(@PathVariable("id") int id,@RequestBody Student t){
        return td.updateStudent(id,t);
    }
    @DeleteMapping("/students/{id}")
    public void DeleteTodo(@PathVariable("id") int id){
        td.deleteStudent(id);
    }


}
 


