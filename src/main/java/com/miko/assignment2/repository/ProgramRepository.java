package com.miko.assignment2.repository;

import com.miko.assignment2.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends  JpaRepository<Program, Long>{

}
