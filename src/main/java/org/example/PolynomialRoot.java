package org.example;

import java.util.Objects;

final public class PolynomialRoot {
    private final double real;
    private final double imaginary;

    public PolynomialRoot(double real, double imaginary) {
        if (Double.compare(real, -0.0) == 0) {
            real = -real;
        }
        if (Double.compare(imaginary, -0.0) == 0) {
            imaginary = -imaginary;
        }
        this.real      = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PolynomialRoot that)) {
            return false;
        }
        return Double.compare(that.getReal(), getReal()) == 0
               && Double.compare(that.getImaginary(), getImaginary()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReal(), getImaginary());
    }

    @Override
    public String toString() {
        final StringBuffer rootString = new StringBuffer();
        rootString.append("real part: ").append(real);
        rootString.append(", imaginary part: ").append(imaginary);

        return rootString.toString();
    }
}
