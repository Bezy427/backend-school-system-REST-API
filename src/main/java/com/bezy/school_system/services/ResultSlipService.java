package com.bezy.school_system.services;

import com.bezy.school_system.dtos.RegisterResultRequest;
import com.bezy.school_system.dtos.ResultDto;
import com.bezy.school_system.dtos.UpdateResultRequest;
import com.bezy.school_system.entities.Result;
import com.bezy.school_system.mappers.ResultMapper;
import com.bezy.school_system.repositories.ResultRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ResultSlipService {
    private ResultRepository resultRepository;
    private ResultMapper resultMapper;

    public ResponseEntity<?> createResultSlip(
            @RequestBody RegisterResultRequest request
    ){
        Result result = new Result();
        result.setMarks(request.getMarks());
        result.setGrade(request.getGrade());
        result.setStatus(request.getStatus());
        resultRepository.save(result);
        return ResponseEntity.ok(result);
    }

    public Iterable<ResultDto> getAllResults() {
        return resultRepository.findAll()
                .stream()
                .map(resultMapper::toDto)
                .toList();
    }

    public ResponseEntity<?> getResultById(
            @PathVariable Long id
    ){
        var result = resultRepository.findById(id);
        if(result == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(result);
    }

    public ResponseEntity<?> updateResultById(
            @PathVariable Long id,
            @RequestBody UpdateResultRequest request
    ){
        var result = resultRepository.findById(request.getId()).orElse(null);
        if(result == null){
            return ResponseEntity.notFound().build();
        }

        resultMapper.update(request, result);
        resultRepository.save(result);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> deleteResultById(
            @PathVariable Long id
    ){
        var result = resultRepository.findById(id).orElse(null);
        if(result == null){
            return ResponseEntity.notFound().build();
        }
        resultRepository.delete(result);
        return ResponseEntity.ok().build();
    }
}
