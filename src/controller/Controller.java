/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.NumeroComplesso;
import model.CalcStack;
import model.Calcolatore;

/**
 *
 * @author gabriel
 */
public class Controller {
    
    private ArrayList<NumeroComplesso> variables;
    private CalcStack stack;
    private Calcolatore calcolatore;
    
    private boolean isNumeric(String input){
        
        boolean es_num = false;
        
        if(input!=null && !input.isEmpty() && ((input.charAt(0)>='0'&&input.charAt(0)<='9')
                ||((input.charAt(0)=='+'||input.charAt(0)=='-')&&input.length()>1))){
            
            int contador=0;
            es_num=true;
            String parte_real = "";
            String parte_imaginary = "";
            
            if(input.charAt(0)=='+' || input.charAt(0)=='-'){
                
                parte_real += input.charAt(0);
                contador++;
                
            }
            
            for(int j=contador; input.charAt(j)>='0'&&input.charAt(j)<='9'&&j<input.length();j++){
                
                parte_real += input.charAt(j);
                contador++;
                
                
            }
            
            if(input.charAt(contador)=='j'){
                
                parte_imaginary = parte_real;
                parte_real = "0";
                
            }
            
            if((contador<input.length()&&(input.charAt(contador)=='+'||input.charAt(contador)=='-')
                    &&!parte_real.isEmpty()) || (contador<input.length()&&!parte_real.isEmpty())){
                
                if(input.charAt(contador)=='+' || input.charAt(contador)=='-'){
                    
                    parte_imaginary += input.charAt(contador);
                    contador++;
                    
                }
                
                if(input.charAt(contador)>='0'&&input.charAt(contador)<='9'&&contador<input.length()-1){
                    
                    for(int j=contador; input.charAt(j)>='0'&&input.charAt(j)<='9'&&j<input.length()-1;j++){
                        
                        parte_imaginary += input.charAt(j);
                        contador++;
                        
                    }
                    
                    if(contador!=input.length()||input.charAt(contador)!='j'){
                        
                        es_num = false;
                        
                    }
                    
                } else{
                    
                    es_num = false;
                    
                }
                
            } else{
                
                es_num = false;
                
            }
            
            if(es_num){
                
                if(parte_imaginary.isEmpty()){
                    
                    stack.add(new NumeroComplesso(Double.parseDouble(parte_real)));
                    
                }else{
                    
                    stack.add(new NumeroComplesso(Double.parseDouble(parte_real), Double.parseDouble(parte_imaginary)));
                    
                }
                
            }
            
             
        }
        
        return(es_num);
        
    }
    
    private boolean isCalculatorOpValid(String input){
        
        boolean es_op = false;
        
        if(input!=null && !input.isEmpty()){
            switch(input){
                case "+":
                    addStack();
                    es_op=true;
                    break;
                case "-":
                    substractStack();
                    es_op=true;
                    break;
                case "*":
                    multiplyStack();
                    es_op=true;
                    break;
                case "/":
                    divideStack();
                    es_op=true;
                    break;
                case "sqrt":
                    sqrtStack();
                    es_op=true;
                    break;
                case "+-":
                    invertSign();
                    es_op=true;
                    break;    
                    
            }
            
        }
        
        return(es_op);
        
    }
    
    private boolean isStackOpValid(String input){
        
        boolean es_op = false;
        
        if(input!=null && !input.isEmpty()){
            switch(input){
                case "clear":
                    stack.clear();
                    es_op=true;
                    break;
                case "drop":
                    stack.drop();
                    es_op=true;
                    break;
                case "dup":
                    stack.dup();
                    es_op=true;
                    break;
                case "swap":
                    stack.swap();
                    es_op=true;
                    break;
                case "over":
                    stack.over();
                    es_op=true;
                    break;    
                    
            }
            
        }
        
        return(es_op);
        
    }
    
    private boolean isVarOpValid(String input){
        
        boolean es_op = false;
        
        if(input!=null && !input.isEmpty() && input.length()==2){
            if(input.charAt(0)=='>' && input.charAt(1)=='a' && input.charAt(0)=='z'){
                
                stackToVar(input.charAt(1)-'a');
                es_op = true;
                
            }else if(input.charAt(0)=='<' && input.charAt(1)=='a' && input.charAt(0)=='z'){
                
                varToStack(input.charAt(1)-'a');
                es_op = true;
                
            }else if(input.charAt(0)=='+' && input.charAt(1)=='a' && input.charAt(0)=='z'){
                
                addVar(input.charAt(1)-'a');
                es_op = true;
                
            }else if(input.charAt(0)=='-' && input.charAt(1)=='a' && input.charAt(0)=='z'){
                
                substractVar(input.charAt(1)-'a');
                es_op = true;
                
            }
            
            
        }
        
        return(es_op);
        
    }
    
    private NumeroComplesso getVar(int var){
        
    }
    
    private void setVar(int var, NumeroComplesso n){
        
        
        
    }
    
    public void substractVar(int var){
        
        
        
    }
    
    public void addVar(int var){
        
        
        
    }
    
    public void varToStack(int var){
        
        
        
    }
    
    public void stackToVar(int var){
        
        
        
    }
    
    public void addStack(){
        
        
        
    }
    
    public void substractStack(){
        
        
        
    }
    
    public void multiplyStack(){
        
        
        
    }
    
    public void divideStack(){
        
        
        
    }
    
    public void sqrtStack(){
        
        
        
    }
    
    public void invertSign(){
        
        
        
    }
    
    public void errorHandler(Error error){   
        
    }
    
    public void inputHandler(String s){
        
    }
    
}
