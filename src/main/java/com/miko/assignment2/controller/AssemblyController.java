package com.miko.assignment2.controller;

import com.miko.assignment2.model.Program;
import com.miko.assignment2.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assembly")
public class AssemblyController {

    @Autowired
    private final AssemblyService assemblyService;

    @Autowired
    public AssemblyController(AssemblyService assemblyService) {
        this.assemblyService = assemblyService;
    }

    @PostMapping("/execute")
    public ResponseEntity<String> executeAssemblyProgram(
            @RequestBody  Program program
    ) {
        String value = assemblyService.executeProgram(program);
        return new ResponseEntity<>(value,HttpStatus.OK);
    }


}
