package edu.sdsu.cs160l.calculator;

public class DoubleCalculator implements Calculator<Double> {

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double sub(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double mul(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double div(Double a, Double b) {
        if (b.equals(0.0)) {
            return Double.POSITIVE_INFINITY;
        }
        return a / b;
    }
}
