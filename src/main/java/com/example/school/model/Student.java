package com.example.school.model;
public class Student{
    private int studentId;
    private String studentName;
    private String gender;
    private int standard;
    public Student(int id,String name,String gender,int std){
        this.studentId=id;
        this.studentName=name;
        this.gender=gender;
        this.standard=std;
    }
    public int getStudentId(){
        return this.studentId;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public String getGender(){
        return this.gender;
    }
    public int getStandard(){
        return this.standard;
    }
    public void setStudentId(int id){
        this.studentId=id;

    }
    public void setStudentName(String name){
        this.studentName=name;
    }
    public void setGender(String g){
        this.gender=g;
    }
    public void setStandard(int std){
        this.standard=std;
    }

}