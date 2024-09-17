package com.top.sampleRest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @PostMapping("/sumOf/")
    int sumOf(@RequestBody TwoNumbers twoNumbers) {
        return (twoNumbers.numA + twoNumbers.numB);
    }
}

