package com.miko.assignment2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;


@Getter
@Setter
@Entity
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "MV|ADD|SHOW", message = "Operation must be one of the following values: MV, ADD, SHOW")
    private String operation;


    @Size(min = 2, max = 5, message = "Operand1 must be between 2 and 5 characters")
    private String operand1;

    @Size(min = 2, max = 10, message = "Operand2 must be between 2 and 10 characters")
    private String operand2;

}
