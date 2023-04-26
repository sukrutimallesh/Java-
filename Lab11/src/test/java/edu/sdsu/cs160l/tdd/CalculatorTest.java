package edu.sdsu.cs160l.tdd;

import edu.sdsu.cs160l.calculator.Calculator;
import edu.sdsu.cs160l.calculator.SimpleCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Todo write test cases for SimpleCalculator Class
// No need to implement the actual Calculator class just write Test cases as per TDD.
// you need to just write test cases no mocking
// test should cover all methods from calculator and all scenarios, so a minimum of 5 test
// 1 for add
// 1 for subtract
// 1 for multiply
// 2 for divide (1 for normal division, 1 for division by 0)
// make sure all these test cases fail

public class CalculatorTest {
    //Declare variable here
    private Calculator calculator;

    //Add before each here
    @BeforeEach
    void setUp() {
        calculator = new SimpleCalculator();
    }

    //write test cases here
    @Test
    void testAdd(){
        int result = calculator.add(20, 31);
        assertEquals(51, result);
    }

    @Test
    void testSub(){
        int result = calculator.add(30, 3);
        assertEquals(27, result);
    }

    @Test
    void testMul(){
        int result = calculator.add(20, 30);
        assertEquals(600, result);
    }


    @Test
    void testDiv(){
        int result = calculator.add(20, 10);
        assertEquals(2, result);
    }

    @Test
    void testDivByZero(){
        try{
            calculator.div(10, 0);
            fail("Expected ArithmeticException");
        }
        catch (ArithmeticException e){
            //expected
        }
    }


}
