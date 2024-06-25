package com.miko.assignment2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String programText;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Instruction> instructions;
}
