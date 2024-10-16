package com.lucasrznd.mathoperationsapi.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(Double firstNumber, Double secondNumber) {
        verifyIfNumberIsValid(firstNumber, secondNumber);

        return firstNumber + secondNumber;
    }

    public Double subtract(Double firstNumber, Double secondNumber) {
        verifyIfNumberIsValid(firstNumber, secondNumber);

        return firstNumber - secondNumber;
    }

    public Double multiply(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }

    private void verifyIfNumberIsValid(Double firstNumber, Double secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException("Only valid numbers");
        }
    }

}
