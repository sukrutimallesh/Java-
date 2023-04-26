package edu.sdsu.cs160l.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.Suite;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;

//TODO add Extension for Mockito and Test Suite
@ExtendWith(MockitoExtension.class)
@Suite()
class MathOperationsTest {

    //TODO add annotation for injecting mocks
    @InjectMocks
    private MathOperations mathOperations;

    //TODO add annotation for Mock
    @Mock
    private SimpleCalculator calculator;

    /**
     * Any test function is always "public void <testScenarioName>()"
     * and annotated with @Test
     * the general syntax for stubbing a mock is
     * doAnswer(invocation -> {
     * // mock logic goes here
     * }).when(<mockobject>).functionCall()
     */
    @Test
    public void testFactorial() {
        doAnswer(invocation -> {
            int a = invocation.getArgument(0);
            int b = invocation.getArgument(1);
            return a * b;
        })
                .when(calculator)
                .mul(anyInt(), anyInt());
        assertEquals(6, mathOperations.factorial(3));
    }

    @Test
    public void testAverage() {
        doAnswer(invocation -> {
            int[] arr = invocation.getArgument(0);
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            return (double) sum / arr.length;
        })
                .when(calculator)
                .add(anyInt(), anyInt());

        //TODO add stub for making the average method work in mathOperations class
        assertEquals(2, mathOperations.average(new int[]{1, 2, 3}));
    }

    @Test
    public void testPower() {
        doAnswer(invocation -> {
            int a = invocation.getArgument(0);
            int b = invocation.getArgument(1);
            int result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }
            return result;
        })
                .when(calculator)
                .mul(anyInt(), anyInt());

        //TODO add stub for making the average method work in mathOperations class
        assertEquals(8, mathOperations.power(2, 3));
    }

    @Test
    public void testMidValue() {
        doAnswer(invocation -> {
            int a = invocation.getArgument(0);
            int b = invocation.getArgument(1);
            return (a + b) / 2;
        })
                .when(calculator)
                .add(anyInt(), anyInt());

        //TODO add stub for making the average method work in mathOperations class
        assertEquals(10, mathOperations.midValue(5, 15));
    }

    @Test
    public void testFToC() {
        doAnswer(invocation -> {
            int fahrenheit = invocation.getArgument(0);
            return (fahrenheit - 32) * 5 / 9;
        })
                .when(calculator)
                .div(anyInt(), anyInt());

        //TODO add stub for making the average method work in mathOperations class
        assertEquals(0, mathOperations.fahrenheitToCelsius(32));
    }


}