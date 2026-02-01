package test.java.com.example;

import main.java.com.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.calculate(2, 3, "add"));
    }

    @Test
    void testAddAgain() {
        assertEquals(10, calculator.calculate(4, 6, "add-again"));
    }

    @Test
    void testSub() {
        assertEquals(2, calculator.calculate(5, 3, "sub"));
    }

    @Test
    void testSubAgain() {
        assertEquals(1, calculator.calculate(4, 3, "sub-again"));
    }

    @Test
    void testMul() {
        assertEquals(12, calculator.calculate(3, 4, "mul"));
    }

    @Test
    void testDivNormal() {
        assertEquals(4, calculator.calculate(12, 3, "div"));
    }

    @Test
    void testDivByZero() {
        assertEquals(0, calculator.calculate(10, 0, "div"));
    }

    @Test
    void testMod() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
    }

    @Test
    void testPow() {
        assertEquals(8, calculator.calculate(2, 3, "pow"));
    }

    @Test
    void testPowZeroExponent() {
        assertEquals(1, calculator.calculate(5, 0, "pow"));
    }

    @Test
    void testUnknownOperation() {
        assertEquals(0, calculator.calculate(5, 3, "unknown"));
    }

    @Test
    void testSumValues() {
        assertEquals(15, calculator.sumValues(10, 5));
    }
}