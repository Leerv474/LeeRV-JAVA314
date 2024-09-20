package com.top.DivisionPractice;

public class Fractions {
    public int numerator;
    public int denominator;

    public Fractions(){}
    public Fractions(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public boolean isRegularFraction() {
        for (int i = 2; i <= numerator && i <= denominator; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void simplifyFraction() {
        for (int i = Math.min(numerator, denominator); i > 1; i--) {
            if (numerator % i == 0 && denominator % i == 0) {
                denominator /= i;
                numerator /= i;
                return;
            }
        }
    }
}