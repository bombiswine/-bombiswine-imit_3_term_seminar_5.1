package org.example;

public class Polynomial {
    protected int      degree;

    protected double[] coefficients;
    public Polynomial(final double[] coefficients) {
        if (coefficients == null) {
            throw new IllegalArgumentException(
                "The null passed to the Polynomial constructor"
            );
        }
        if (coefficients.length == 0) {
            throw new IllegalArgumentException(
                "The empty array passed to the Polynomial constructor"
            );
        }

        this.degree       = coefficients.length - 1;
        this.coefficients = new double[ coefficients.length ];
        for (int i = 0; i <= degree ; i++) {
            this.coefficients[i] = coefficients[i];
        }
    }

    public int getDegree() {
        return degree;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double getValueAt(final double argument) {
        double result = coefficients[0];
        for (int i = 1; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(argument, i);
        }

        return result;
    }
}
