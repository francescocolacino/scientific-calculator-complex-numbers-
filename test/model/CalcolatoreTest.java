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
    
    NumeroComplesso opp1;
    NumeroComplesso opp2;
    NumeroComplesso oppReal;
    NumeroComplesso oppComplex;
    NumeroComplesso oppZero;
    
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
        opp1 = new NumeroComplesso(-1,2);
        opp2 = new NumeroComplesso(2,-3);
        oppReal = new NumeroComplesso(10);
        oppComplex = new NumeroComplesso(0,10);
        oppZero = new NumeroComplesso(0);
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
        assertEquals(new NumeroComplesso(1, -1), Calcolatore.add(opp1, opp2));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(9, 2), Calcolatore.add(opp1, oppReal));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(-1, 12), Calcolatore.add(opp1, oppComplex));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(opp1, Calcolatore.add(opp1, oppZero));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(10, 10), Calcolatore.add(oppReal, oppComplex));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substract method, of class Calcolatore.
     */
    @Test
    public void testSubstract() {
        System.out.println("substract");
        assertEquals(new NumeroComplesso(3, -5), Calcolatore.substract(opp1, opp2));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(11, -2), Calcolatore.substract(opp1, oppReal));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(1, 8), Calcolatore.substract(opp1, oppComplex));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(1,-2), Calcolatore.substract(opp1, oppZero));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(-10, 10), Calcolatore.substract(oppReal, oppComplex));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Calcolatore.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        assertEquals(new NumeroComplesso(4, 7), Calcolatore.multiply(opp1, opp2));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(9, 2), Calcolatore.multiply(opp1, oppReal));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(-1, 12), Calcolatore.multiply(opp1, oppComplex));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(opp1, Calcolatore.multiply(opp1, oppZero));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        assertEquals(new NumeroComplesso(10, 10), Calcolatore.multiply(oppReal, oppComplex));
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
