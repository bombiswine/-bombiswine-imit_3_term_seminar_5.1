package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PolynomialTest {
    @Test(dataProvider = "polynomialConstructor_PositiveCase_Data")
    public static void polynomialConstructor_PositiveCase_Test(
        final double[] coefficients,
        final int expectedDegree
    ) {
        Polynomial polynomial = new Polynomial(coefficients);
        assertNotNull(polynomial);
        assertEquals(polynomial.getCoefficients(), coefficients);
        assertEquals(polynomial.getDegree(), expectedDegree);
    }

    @DataProvider
    public static Object[][] polynomialConstructor_PositiveCase_Data() {
        return new Object[][] {
            { new double[] { 1.0, 3.0, 3.0, 1.0 }, 3 },
            { new double[] { 0.0, 0.0, 10.0 }, 2 },
            { new double[] { 5.0, 0.0, 0.0 }, 0 },
            { new double[] { 0.0, 17.0, 0.0 }, 1 },
            { new double[] { 0.0, 17.0, 0.0, 0.0, -11.0 }, 4 },
        };
    }
}
