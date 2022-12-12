package org.example;

public class Polynomial {
    protected int      degree;

    protected double[] coefficients;

    public Polynomial(final double[] givenCoefficients) {
        if (givenCoefficients == null) {
            throw new IllegalArgumentException(
                "The null passed to the Polynomial constructor"
            );
        }
        if (givenCoefficients.length == 0) {
            throw new IllegalArgumentException(
                "The empty array passed to the Polynomial constructor"
            );
        }

        coefficients = new double[ givenCoefficients.length ];
        for (int i = 0; i < givenCoefficients.length ; i++) {
            coefficients[i] = givenCoefficients[i];
            if (Double.compare(coefficients[i], 0.0) != 0) {
                degree = i;
            }
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

    public double getDerivativeValueAt(final double argument) {
        double result = coefficients[1];
        for (int i = 2; i < coefficients.length; i++) {
            result += i * coefficients[i] * Math.pow(argument, i - 1);
        }

        return result;
    }
}
