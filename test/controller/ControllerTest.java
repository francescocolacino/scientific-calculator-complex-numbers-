/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controller;

import model.NumeroComplesso;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gabriel
 */
public class ControllerTest {    
    NumeroComplesso opp1;
    NumeroComplesso oppReal;
    NumeroComplesso oppComplex;
    NumeroComplesso oppZero;
    Controller instance;
    
    public ControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new Controller();
        
        opp1 = new NumeroComplesso(-1,2);
        oppReal = new NumeroComplesso(10);
        oppComplex = new NumeroComplesso(0,10);
        oppZero = new NumeroComplesso(0);
        
        instance.inputHandler(opp1.toString());
        instance.inputHandler(oppReal.toString());
        instance.inputHandler(oppComplex.toString());
        instance.inputHandler(oppZero.toString());
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of substractVar method, of class Controller.
     */
    @Test
    public void testSubstractVar() {
        System.out.println("substractVar");
        instance.variables.set(0, oppZero);
        instance.substractVar(0);
        assertEquals(oppZero, instance.variables.get(0));
        assertEquals(4,instance.stack.size());
        instance.stack.drop();
        instance.substractVar(0);
        assertEquals(new NumeroComplesso(0,-10), instance.variables.get(0));
        assertEquals(3,instance.stack.size());
         instance.stack.drop();
        instance.substractVar(0);
        assertEquals(new NumeroComplesso(-10,-10), instance.variables.get(0));
        assertEquals(2,instance.stack.size());
         instance.stack.drop();
        instance.substractVar(0);
        assertEquals(new NumeroComplesso(-9,-12), instance.variables.get(0));
        assertEquals(1,instance.stack.size());
        
    }

    /**
     * Test of addVar method, of class Controller.
     */
    @Test
    public void testAddVar() {
        System.out.println("addVar");
        
        instance.variables.set(0, oppZero);
        instance.addVar(0);
        assertEquals(oppZero, instance.variables.get(0));
        assertEquals(4,instance.stack.size());
        instance.stack.drop();
        instance.addVar(0);
        assertEquals(new NumeroComplesso(0,10), instance.variables.get(0));
        assertEquals(3,instance.stack.size());
         instance.stack.drop();
        instance.addVar(0);
        assertEquals(new NumeroComplesso(10,10), instance.variables.get(0));
        assertEquals(2,instance.stack.size());
         instance.stack.drop();
        instance.addVar(0);
        assertEquals(new NumeroComplesso(9,12), instance.variables.get(0));
        assertEquals(1,instance.stack.size());
    }

    /**
     * Test of varToStack method, of class Controller.
     */
    @Test
    public void testVarToStack() {
        System.out.println("varToStack");
        int stackSize = instance.stack.size();
        instance.variables.set(0, oppReal);
        instance.varToStack(0);
        assertEquals(oppReal,instance.stack.lastElement());
        assertEquals(stackSize+1,instance.stack.size());
    }

    /**
     * Test of stackToVar method, of class Controller.
     */
    @Test
    public void testStackToVar() {
        System.out.println("stackToVar");
        int var = 0;
        Controller instance = new Controller();
        instance.stackToVar(var);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStack method, of class Controller.
     */
    @Test
    public void testAddStack() {
        System.out.println("addStack");
        Controller instance = new Controller();
        instance.addStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substractStack method, of class Controller.
     */
    @Test
    public void testSubstractStack() {
        System.out.println("substractStack");
        Controller instance = new Controller();
        instance.substractStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplyStack method, of class Controller.
     */
    @Test
    public void testMultiplyStack() {
        System.out.println("multiplyStack");
        Controller instance = new Controller();
        instance.multiplyStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divideStack method, of class Controller.
     */
    @Test
    public void testDivideStack() {
        System.out.println("divideStack");
        Controller instance = new Controller();
        instance.divideStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrtStack method, of class Controller.
     */
    @Test
    public void testSqrtStack() {
        System.out.println("sqrtStack");
        Controller instance = new Controller();
        instance.sqrtStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invertSign method, of class Controller.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        Controller instance = new Controller();
        instance.invertSign();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inputHandler method, of class Controller.
     */
    @Test
    public void testInputHandler() {
        System.out.println("inputHandler");
        String s = "";
        Controller instance = new Controller();
        instance.inputHandler(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finish method, of class Controller.
     */
    @Test
    public void testFinish() {
        System.out.println("finish");
        int i = 0;
        Controller instance = new Controller();
        instance.finish(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
