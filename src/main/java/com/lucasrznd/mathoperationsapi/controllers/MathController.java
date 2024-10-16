package com.lucasrznd.mathoperationsapi.controllers;

import com.lucasrznd.mathoperationsapi.services.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService service;

    public MathController(MathService service) {
        this.service = service;
    }

    @GetMapping("/sum")
    public ResponseEntity<Double> getSum(@RequestParam Double firstNumber,
                                         @RequestParam Double secondNumber) {
        return ResponseEntity.ok().body(service.sum(firstNumber, secondNumber));
    }

    @GetMapping("/subtract")
    public ResponseEntity<Double> getSubtraction(@RequestParam Double firstNumber,
                                         @RequestParam Double secondNumber) {
        return ResponseEntity.ok().body(service.subtract(firstNumber, secondNumber));
    }

    @GetMapping("/multiply")
    public ResponseEntity<Double> getMultiply(@RequestParam Double firstNumber,
                                                 @RequestParam Double secondNumber) {
        return ResponseEntity.ok().body(service.multiply(firstNumber, secondNumber));
    }

}
