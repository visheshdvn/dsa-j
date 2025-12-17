package com.dsa.basics.oops;

import com.dsa.utils.Test;

class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}


public class FractionUse {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(10, 15);
        Test t = new Test();

        System.out.println(f1.getNumerator() + t.testingVar);
    }
    
}