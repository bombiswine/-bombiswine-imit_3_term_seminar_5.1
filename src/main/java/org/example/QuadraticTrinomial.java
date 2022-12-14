package org.example;

import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.compare;

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

    public PolynomialRoot[] getRoots() {
        PolynomialRoot x1;
        PolynomialRoot x2;
        // initially we assume that Trinomial has got no roots
        PolynomialRoot[] solution = new PolynomialRoot[] { };

        if (compare(coefficients[2], 0.0) != 0) {
            final double discriminant = getDiscriminant();
            if (compare(discriminant, 0.0) >= 0) {
                x1 = new PolynomialRoot (
                    (-coefficients[ 1 ] - Math.sqrt(discriminant)) / (2 * coefficients[ 2 ]),
                    0.0
                );
                x2 = new PolynomialRoot (
                    (-coefficients[ 1 ] + Math.sqrt(discriminant)) / (2 * coefficients[ 2 ]),
                    0.0
                );
            } else {
                x1 = new PolynomialRoot (
                    -coefficients[ 1 ] / (2 * coefficients[ 2 ]),
                    Math.sqrt(-discriminant) / (2 * coefficients[ 2 ])
                );
                x2 = new PolynomialRoot (
                    -coefficients[ 1 ] / (2 * coefficients[ 2 ]),
                    -Math.sqrt(-discriminant) / (2 * coefficients[ 2 ])
                );
            }
            solution = new PolynomialRoot[] { x1, x2 };
        } else if (compare(coefficients[ 1 ], 0.0) != 0) {
            solution = new PolynomialRoot[] {
                new PolynomialRoot(-coefficients[ 0 ] / coefficients[ 1 ], 0.0)
            };
        } else if (compare(coefficients[ 0 ], 0.0) == 0) {
            solution = new PolynomialRoot[] {
                new PolynomialRoot(POSITIVE_INFINITY, POSITIVE_INFINITY)
            };
        }

        return solution;
    }
}
