package com.miko.assignment2.service;

import com.miko.assignment2.model.Instruction;
import com.miko.assignment2.model.Program;
import com.miko.assignment2.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AssemblyService {

private final ProgramRepository programRepository;

    private final Map<String, Integer> registers = new HashMap<>();


    public AssemblyService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public String executeProgram(Program program) {
        List<Instruction> instructions = program.getInstructions();
        String operand1 = "";
        String operand2 = "";
        String operation = "";
        for (Instruction instruction : instructions) {
            operation = instruction.getOperation();
            operand1 = instruction.getOperand1();
            operand2 = instruction.getOperand2();

            switch (operation) {
                case "MV":
                    int value = Integer.parseInt(operand2.substring(1));
                    registers.put(operand1, value);
                    break;
                case "ADD":
                    if (operand2.startsWith("#")) {
                        int constant = Integer.parseInt(operand2.substring(1));
                        registers.put(operand1, registers.getOrDefault(operand1, 0) + constant);
                    } else {
                        registers.put(operand1, registers.getOrDefault(operand1, 0) + registers.getOrDefault(operand2, 0));
                    }
                    break;
                case "SHOW":
                    System.out.println(operand1 + " = " + registers.getOrDefault(operand1, 0));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported operation: " + operation);
            }
        }

        programRepository.save(program);
        return operand1 + " = " + registers.getOrDefault(operand1, 0);
    }

}
