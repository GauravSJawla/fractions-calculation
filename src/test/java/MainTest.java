import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;
    String[] falseStatement, trueStatement;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testValidInputStatement() {
        setUp();
        falseStatement = new String[]{"%"};
        trueStatement = new String[]{"?", "1/2", "*", "3_3/4"};
        assertFalse(Main.validInputStatement(falseStatement));
        assertTrue(Main.validInputStatement(trueStatement));
    }

    @Test
    void testConvertInputFromStringToDouble() {
        setUp();
        String inputString = "1/2";
        double expected = 0.5;
        double actual = Main.convertInputFromStringToDouble(inputString);
        assertEquals(expected,actual);
    }

    @Test
    void testConvertFractionToDecimal() {
        setUp();
        String inputString = "1/2";
        double expected = 0.5;
        double actual = Main.convertFractionToDecimal(inputString);
        assertEquals(expected,actual);
    }

    @Test
    void testPerformOperation() {
        setUp();
        double inputOne = 0.5, inputTwo = 0.5;
        String operand = "+";
        double expected = 1.0;
        double actual = Main.performOperation(inputOne,inputTwo,operand);
        assertEquals(expected,actual);
    }

    @Test
    void testConvertDecimalToFraction() {
        setUp();
        double inputDouble = 0.5;
        String expected = "1/2";
        String actual = Main.convertDecimalToFraction(inputDouble);
        assertEquals(expected,actual);
    }

    @Test
    void testToMixedFraction() {
        setUp();
        int numerator = 5;
        int denominator = 2;
        String expected = "2_1/2";
        String actual = Main.toMixedFraction(numerator, denominator);
        assertEquals(expected,actual);
    }
}