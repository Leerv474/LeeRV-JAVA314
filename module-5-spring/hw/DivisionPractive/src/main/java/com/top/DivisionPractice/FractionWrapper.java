package com.top.DivisionPractice;

public class FractionWrapper {
    public Fractions fractionA;
    public Fractions fractionB;

    public Fractions addFractions() {
        Fractions result  = new Fractions();
        result.denominator = commonDenominator(fractionB.denominator, fractionA.denominator);
        result.numerator = fractionB.numerator * result.denominator / fractionB.denominator + fractionA.numerator * result.denominator / fractionA.denominator;
        result.simplifyFraction();
        return result;
    }

    public Fractions subtractFractions() {
        Fractions result  = new Fractions();
        result.denominator = commonDenominator(fractionB.denominator, fractionA.denominator);
        result.numerator = fractionA.numerator * result.denominator / fractionA.denominator - fractionB.numerator * result.denominator / fractionB.denominator;
        result.simplifyFraction();
        return result;
    }


    private int gcd(int a, int b) {
        return b ==0 ? a : gcd(b, a % b);
    }
    private int commonDenominator(int a, int b) {
        return Math.abs(a*b) / gcd(a, b);
    }

    public Fractions multiplyFractions() {
        return new Fractions(fractionA.numerator * fractionB.numerator, fractionA.denominator* fractionB.denominator);
    }

    public Fractions divideFractions() {
        return new Fractions(fractionA.numerator * fractionB.denominator, fractionA.denominator* fractionB.numerator);
    }
}