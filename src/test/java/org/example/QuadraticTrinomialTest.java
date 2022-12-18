package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.testng.Assert.*;

public class QuadraticTrinomialTest {
    @Test(dataProvider = "quadraticTrinomialConstructor_PositiveCase_Data")
    public static void quadraticTrinomialConstructor_PositiveCase_Test(
        final double[] coefficients
    ) {
        QuadraticTrinomial polynomial = new QuadraticTrinomial(coefficients);
        assertNotNull(polynomial);
        assertEquals(polynomial.getCoefficients(), coefficients);
        assertTrue(polynomial.getDegree() <= 2);
    }

    @DataProvider
    public static Object[][] quadraticTrinomialConstructor_PositiveCase_Data() {
        return new Object[][] {
            { new double[] { -5.0, 4.0, 1.2 } },
            { new double[] { 0.0, 0.0, 10.0 } },
            { new double[] { 0.0, 10.0 } },
            { new double[] { 10.0 } },
            { new double[] { 0.0, 17.0, 0.0 } },
            { new double[] { 5.0, 0.0, 0.0 } },
            { new double[] { 0.0, 0.0, 0.0 } },
            { new double[] { 1.0, 17.0, 1.0, 0.0 } },
            { new double[] { 0.0, 17.0, 1.0, 0.0, 0.0 } },
        };
    }

    @Test(
        dataProvider = "quadraticTrinomialConstructor_ThrowsIllegalArgumentException_Data",
        expectedExceptions = IllegalArgumentException.class
    )
    public static void quadraticTrinomialConstructor_ThrowsIllegalArgumentException_Test(
        final double[] coefficients
    ) {
        new QuadraticTrinomial(coefficients);
    }

    @DataProvider
    public static Object[][] quadraticTrinomialConstructor_ThrowsIllegalArgumentException_Data() {
        return new Object[][] {
            { new double[] { 1.0, 3.0, 3.0, 1.0 } },
            { new double[] { 0.0, 17.0, 0.0, 0.0, -11.0 } },
        };
    }

    @Test(dataProvider = "getRoots_Data")
    public static void getRoots_Test(
        final QuadraticTrinomial polynomial,
        final PolynomialRoot... expectedRoots
    ) {
        PolynomialRoot[] actualRoots = polynomial.getRoots();
        assertEquals(actualRoots, expectedRoots);
    }

    @DataProvider
    public static Object[][] getRoots_Data() {
        return new Object[][] {
            {
                new QuadraticTrinomial(new double[] { -5.0, 4.0, 1.0 }),
                new PolynomialRoot(-5.0, 0.0),
                new PolynomialRoot(1.0, 0.0)
            }, {
                new QuadraticTrinomial(new double[] { 5.0, 4.0, 1.0 }),
                new PolynomialRoot(-2.0, 1.0),
                new PolynomialRoot(-2.0, -1.0)
            }, {
                new QuadraticTrinomial(new double[] { 1.0, 2.0, 1.0 }),
                new PolynomialRoot(-1.0, 0.0),
                new PolynomialRoot(-1.0, 0.0)
            }, {
                new QuadraticTrinomial(new double[] { 1.0, 2.0, 0.0 }),
                new PolynomialRoot(-0.5, 0.0)
            }, {
                new QuadraticTrinomial(new double[] { 0.0, 0.0, 0.0 }),
                new PolynomialRoot(POSITIVE_INFINITY, POSITIVE_INFINITY)
            }, {
                new QuadraticTrinomial(new double[] { 1.0, 0.0, 0.0 }),
                new PolynomialRoot[] { }
            },
        };
    }
}
