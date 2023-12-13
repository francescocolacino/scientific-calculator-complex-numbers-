/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controller;

import model.Calcolatore;
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
        
        instance.substractVar(0);
        assertEquals(oppZero, instance.stack.lastElement());
        assertEquals(4,instance.stack.size());
        assertEquals(null,instance.variables.get(0));
        
        instance.variables.set(0, oppZero);
        instance.substractVar(0);
        assertEquals(oppZero, instance.variables.get(0));
        assertEquals(3,instance.stack.size());
        instance.substractVar(0);
        assertEquals(new NumeroComplesso(0,-10), instance.variables.get(0));
        assertEquals(2,instance.stack.size());
        instance.substractVar(0);
        assertEquals(new NumeroComplesso(-10,-10), instance.variables.get(0));
        assertEquals(1,instance.stack.size());
        instance.substractVar(0);
        assertEquals(new NumeroComplesso(-9,-12), instance.variables.get(0));
        assertEquals(0,instance.stack.size());
        
        instance.substractVar(0);
        assertEquals(new NumeroComplesso(-9,-12), instance.variables.get(0));
        assertEquals(0,instance.stack.size());        
    }

    /**
     * Test of addVar method, of class Controller.
     */
    @Test
    public void testAddVar() {
        System.out.println("addVar");
        
        instance.addVar(0);
        assertEquals(oppZero, instance.stack.lastElement());
        assertEquals(4,instance.stack.size());
        assertEquals(null,instance.variables.get(0));
        
        instance.variables.set(0, oppZero);
        instance.addVar(0);
        assertEquals(oppZero, instance.variables.get(0));
        assertEquals(3,instance.stack.size());
        instance.addVar(0);
        assertEquals(new NumeroComplesso(0,10), instance.variables.get(0));
        assertEquals(2,instance.stack.size());
        instance.addVar(0);
        assertEquals(new NumeroComplesso(10,10), instance.variables.get(0));
        assertEquals(1,instance.stack.size());
        instance.addVar(0);
        assertEquals(new NumeroComplesso(9,12), instance.variables.get(0));
        assertEquals(0,instance.stack.size());
        
        instance.addVar(0);
        assertEquals(new NumeroComplesso(9,12), instance.variables.get(0));
        assertEquals(0,instance.stack.size());
    }

    /**
     * Test of varToStack method, of class Controller.
     */
    @Test
    public void testVarToStack() {
        System.out.println("varToStack");
        int stackSize = instance.stack.size();
        
        instance.varToStack(0);
        assertEquals(oppZero,instance.stack.lastElement());
        assertEquals(stackSize,instance.stack.size());
        
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
        
        int stackSize = instance.stack.size();
        
        NumeroComplesso n = instance.stack.lastElement();
        
        instance.stackToVar(0);
        
        assertEquals(n,instance.variables.get(0));
        assertEquals(stackSize-1,instance.stack.size());
    }

    /**
     * Test of addStack method, of class Controller.
     */
    @Test
    public void testAddStack() {
        System.out.println("addStack");
        
        int size = instance.stack.size();
        
        instance.addStack();
        assertEquals(new NumeroComplesso(0,10), instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.addStack();
        assertEquals(new NumeroComplesso(10,10), instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.addStack();
        assertEquals(new NumeroComplesso(9,12), instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.addStack();
        assertEquals(new NumeroComplesso(9,12), instance.stack.lastElement());
        assertEquals(size,instance.stack.size());
    }

    /**
     * Test of substractStack method, of class Controller.
     */
    @Test
    public void testSubstractStack() {
        System.out.println("substractStack");
        
        int size = instance.stack.size();
        
        instance.substractStack();
        assertEquals(new NumeroComplesso(0,-10), instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.substractStack();
        assertEquals(new NumeroComplesso(-10,-10), instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.substractStack();
        assertEquals(new NumeroComplesso(-9,-12), instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.substractStack();
        assertEquals(new NumeroComplesso(-9,-12), instance.stack.lastElement());
        assertEquals(size,instance.stack.size());
    }

    /**
     * Test of multiplyStack method, of class Controller.
     */
    @Test
    public void testMultiplyStack() {
        System.out.println("multiplyStack");
        
        instance.stack.add(new NumeroComplesso(1,1)) ;
        instance.stack.add(new NumeroComplesso(2,1));
        instance.stack.add(new NumeroComplesso(-1,4));
        instance.stack.add(new NumeroComplesso(8,5));
        instance.stack.add(new NumeroComplesso(0.4,3.2));
        
        int size = instance.stack.size();

        instance.multiplyStack();
        NumeroComplesso aux = Calcolatore.multiply(
                new NumeroComplesso(0.4,3.2), 
                new NumeroComplesso(8,5));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.multiplyStack();
        aux = Calcolatore.multiply(
                aux, 
                new NumeroComplesso(-1,4));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.multiplyStack();
        aux = Calcolatore.multiply(
                aux, 
                new NumeroComplesso(2,1));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.multiplyStack();
        aux = Calcolatore.multiply(
                aux, 
                new NumeroComplesso(1,1));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.multiplyStack();
        aux = Calcolatore.multiply(
                aux, 
                new NumeroComplesso(0,0));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        
        instance.stack.clear();
        instance.stack.add(aux);
        instance.multiplyStack();
        assertEquals(aux,instance.stack.lastElement());
        assertEquals(1,instance.stack.size());
    }

    /**
     * Test of divideStack method, of class Controller.
     */
    @Test
    public void testDivideStack() {
        System.out.println("divideStack");
        
        instance.stack.add(new NumeroComplesso(1,1)) ;
        instance.stack.add(new NumeroComplesso(2,1));
        instance.stack.add(new NumeroComplesso(-1,4));
        instance.stack.add(new NumeroComplesso(8,5));
        instance.stack.add(new NumeroComplesso(0.4,3.2));
        
        int size = instance.stack.size();

        instance.divideStack();
        NumeroComplesso aux = Calcolatore.divide(
                new NumeroComplesso(0.4,3.2), 
                new NumeroComplesso(8,5));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.divideStack();
        aux = Calcolatore.divide(
                aux, 
                new NumeroComplesso(-1,4));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.divideStack();
        aux = Calcolatore.divide(
                aux, 
                new NumeroComplesso(2,1));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.divideStack();
        aux = Calcolatore.divide(
                aux, 
                new NumeroComplesso(1,1));
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(--size,instance.stack.size());
        instance.divideStack();
        assertEquals(aux, instance.stack.lastElement());
        assertEquals(size,instance.stack.size());
        
        instance.stack.clear();
        instance.stack.add(aux);
        instance.divideStack();
        assertEquals(aux,instance.stack.lastElement());
        assertEquals(1,instance.stack.size());
    }

    /**
     * Test of sqrtStack method, of class Controller.
     */
    @Test
    public void testSqrtStack() {
        System.out.println("sqrtStack");
       
        instance.stack.add(new NumeroComplesso(21,-31)) ;
        
        int size = instance.stack.size();
        
        NumeroComplesso n = Calcolatore.sqrt(instance.stack.lastElement());
        instance.sqrtStack();
        assertEquals(n,instance.stack.lastElement());
        assertEquals(size,instance.stack.size());
        
        n = Calcolatore.sqrt(instance.stack.lastElement());
        instance.sqrtStack();
        assertEquals(n,instance.stack.lastElement());
        assertEquals(size,instance.stack.size());
        
        n = Calcolatore.sqrt(instance.stack.lastElement());
        instance.sqrtStack();
        assertEquals(n,instance.stack.lastElement());
        assertEquals(size,instance.stack.size());
        
        instance.stack.add(new NumeroComplesso(0,0));

        n = Calcolatore.sqrt(instance.stack.lastElement());
        instance.sqrtStack();
        assertEquals(n,instance.stack.lastElement());
        assertEquals(size,instance.stack.size());

    }

    /**
     * Test of invertSign method, of class Controller.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        
        instance.stack.add(new NumeroComplesso(21,-31)) ;
        
        int size = instance.stack.size();
        
        NumeroComplesso n = Calcolatore.invertSign(instance.stack.lastElement());
        instance.invertSign();
        assertEquals(n,instance.stack.lastElement());
        assertEquals(size,instance.stack.size());
        
        instance.stack.add(new NumeroComplesso(0,0)) ;
        
        size = instance.stack.size();
        
        n = Calcolatore.invertSign(instance.stack.lastElement());
        instance.invertSign();
        assertEquals(n,instance.stack.lastElement());
        assertEquals(size,instance.stack.size());
    }

    /**
     * Test of inputHandler method, of class Controller.
     */
    @Test
    public void testInputHandler() {
        System.out.println("inputHandler");
    
        instance.stack.clear();
        String aux = "SDLKFLSKDMFL";
        
        instance.inputHandler(aux);
        assertEquals(0,instance.stack.size());

        aux = "8";
        instance.inputHandler(aux);
        assertEquals(new NumeroComplesso(8),instance.stack.lastElement());
        assertEquals(1,instance.stack.size());
        
        aux = "8j";
        instance.inputHandler(aux);
        assertEquals(new NumeroComplesso(0,8),instance.stack.lastElement());
        assertEquals(2,instance.stack.size());
        
        aux = "1+8j";
        instance.inputHandler(aux);
        assertEquals(new NumeroComplesso(1,8),instance.stack.lastElement());
        assertEquals(3,instance.stack.size());
    }
    
}
