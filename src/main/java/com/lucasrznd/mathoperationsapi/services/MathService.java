package com.lucasrznd.mathoperationsapi.services;

import com.lucasrznd.mathoperationsapi.dtos.ResultResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public ResultResponseDTO sum(Double firstNumber, Double secondNumber) {
        verifyIfNumberIsValid(firstNumber, secondNumber);

        Double result = firstNumber + secondNumber;
        return new ResultResponseDTO(result);
    }

    public ResultResponseDTO subtract(Double firstNumber, Double secondNumber) {
        verifyIfNumberIsValid(firstNumber, secondNumber);

        Double result = firstNumber - secondNumber;
        return new ResultResponseDTO(result);
    }

    public ResultResponseDTO multiply(Double firstNumber, Double secondNumber) {
        verifyIfNumberIsValid(firstNumber, secondNumber);

        Double result = firstNumber * secondNumber;
        return new ResultResponseDTO(result);
    }

    private void verifyIfNumberIsValid(Double firstNumber, Double secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException("Only valid numbers");
        }
    }

}
