package com.practice.database;

import com.practice.Professor;
import com.practice.Student;

import java.util.ArrayList;
import java.util.List;

public class TemproryDatabase {
    public static List<Professor> getProfessorFromTemproryDatabase(){
        return new ArrayList<Professor>(){
            {
                add(Professor.newBuilder().setProfessorId(1).setProfessorName("Neha").setGender("Female").build());
                add(Professor.newBuilder().setProfessorId(2).setProfessorName("Suvankar").setGender("Male").build());
                add(Professor.newBuilder().setProfessorId(3).setProfessorName("Ashay").setGender("Female").build());

            }
        };
    }
    public static List<Student> getStudentFromTemproryDatabase(){
        return new ArrayList<Student>(){
            {
                add(Student.newBuilder().setStudentId(1).setStudentName("Atiya").setStudentGender("Female").setStudentContact(123456789).build());
                add(Student.newBuilder().setStudentId(2).setStudentName("Abahy").setStudentGender("Male").setStudentContact(987654321).build());
                add(Student.newBuilder().setStudentId(3).setStudentName("Ankit").setStudentGender("Male").setStudentContact(998793662).build());

            }
        };
    }
}