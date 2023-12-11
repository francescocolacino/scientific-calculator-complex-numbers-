/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jaimecrz3
 */
public class CalcolatoreTest {
    
    public CalcolatoreTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of add method, of class Calcolatore.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        NumeroComplesso n1 = null;
        NumeroComplesso n2 = null;
        NumeroComplesso expResult = null;
        NumeroComplesso result = Calcolatore.add(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substract method, of class Calcolatore.
     */
    @Test
    public void testSubstract() {
        System.out.println("substract");
        NumeroComplesso n1 = null;
        NumeroComplesso n2 = null;
        NumeroComplesso expResult = null;
        NumeroComplesso result = Calcolatore.substract(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Calcolatore.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        NumeroComplesso n1 = null;
        NumeroComplesso n2 = null;
        NumeroComplesso expResult = null;
        NumeroComplesso result = Calcolatore.multiply(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class Calcolatore.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        NumeroComplesso n1 = null;
        NumeroComplesso n2 = null;
        NumeroComplesso expResult = null;
        NumeroComplesso result = Calcolatore.divide(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invertSign method, of class Calcolatore.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        NumeroComplesso n1 = null;
        NumeroComplesso expResult = null;
        NumeroComplesso result = Calcolatore.invertSign(n1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class Calcolatore.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        NumeroComplesso n1 = null;
        NumeroComplesso expResult = null;
        NumeroComplesso result = Calcolatore.sqrt(n1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
