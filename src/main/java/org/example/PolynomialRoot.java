package org.example;

final class PolynomialRoot {
    private final double real;
    private final double imaginary;

    PolynomialRoot(final double real, final double imaginary) {
        this.real      = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}
