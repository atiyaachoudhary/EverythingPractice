package com.practice.controller;

import com.google.protobuf.Descriptors;
import com.practice.clientService.StudentProfessorClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@AllArgsConstructor
public class StudentProfessorClientController {

    final StudentProfessorClientService studentProfessorClientService;

    @GetMapping("professor/{professorId}")
    public Map<Descriptors.FieldDescriptor, Object> getProfessor(@PathVariable String professorId){
        return studentProfessorClientService.getProfessor(Integer.parseInt(professorId));
    }
}