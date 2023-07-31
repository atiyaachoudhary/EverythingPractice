package com.practice.ServerService;

import com.practice.Professor;
import com.practice.StudentProfessorServiceGrpc;
import com.practice.database.TemproryDatabase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class StudentProfessorServerService extends StudentProfessorServiceGrpc.StudentProfessorServiceImplBase{
    @Override
    public void getProfessor(Professor request, StreamObserver<Professor> responseObserver) {
        TemproryDatabase.getProfessorFromTemproryDatabase()
                .stream()
                .filter(professor -> professor.getProfessorId() == request.getProfessorId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}