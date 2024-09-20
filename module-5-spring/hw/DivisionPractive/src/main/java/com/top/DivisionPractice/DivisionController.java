package com.top.DivisionPractice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivisionController {

    @PostMapping("/isRegularFraction")
    String irregularityCheck(@RequestBody Fractions fraction) {
        return fraction.isRegularFraction() ? "Правильная" : "Неправильная";
    }

    @PostMapping("/simplifyFraction")
    Fractions simplifyFraction(@RequestBody Fractions fraction) {
        fraction.simplifyFraction();
        return fraction;
    }

    @PostMapping("/addUpFractions")
    Fractions addUpFractions(@RequestBody FractionWrapper fractions) {
        return fractions.addFractions();
    }

    @PostMapping("/subtractFractions")
    Fractions subtractFractions(@RequestBody FractionWrapper fractions) {
        return fractions.subtractFractions();
    }

    @PostMapping("/multiplyFractions")
    Fractions multiplyFractions(@RequestBody FractionWrapper fractions) {
        return fractions.multiplyFractions();
    }

    @PostMapping("/divideFractions")
    Fractions divideFractions(@RequestBody FractionWrapper fractions) {
        return fractions.divideFractions();
    }
}