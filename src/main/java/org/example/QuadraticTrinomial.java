package org.example;

public class QuadraticTrinomial extends Polynomial {
    public QuadraticTrinomial(double[] givenCoefficients) {
        super(givenCoefficients);
        if (getDegree() > 2) {
            throw new IllegalArgumentException(
                "Created polynomial has got the degree greater than 2"
            );
        }
    }

    public double getDiscriminant() {
        return coefficients[1] * coefficients[1] - 4 * coefficients[2] * coefficients[0];
    }
}
