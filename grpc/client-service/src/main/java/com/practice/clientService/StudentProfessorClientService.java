package com.practice.clientService;

import com.google.protobuf.Descriptors;
import com.practice.Professor;
import com.practice.StudentProfessorServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class StudentProfessorClientService {

    @GrpcClient("grpc-practice-server")
    StudentProfessorServiceGrpc.StudentProfessorServiceBlockingStub sychronousClient;

    public Map<Descriptors.FieldDescriptor, Object> getProfessor(int professorId){
        Professor professorRequest = Professor.newBuilder().setProfessorId(professorId).build();
        Professor professorResponse = sychronousClient.getProfessor(professorRequest);
        return professorResponse.getAllFields();
    }
}