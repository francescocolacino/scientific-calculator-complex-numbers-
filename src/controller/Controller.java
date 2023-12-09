/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import View.MainView;
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
    private CalcStack<NumeroComplesso> stack;
    private Calcolatore calcolatore;
    public MainView mw;
    
    public Controller(){
        mw = new MainView();
        mw.setController(this);
        calcolatore = new Calcolatore();
        stack = new CalcStack<>();
        variables = new ArrayList<>();
    }
    
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
        
        return(variables.get(var));
        
    }
    
    private void setVar(int var, NumeroComplesso n){
        
        variables.set(var, n);
        
    }
    
    public void substractVar(int var){
        
        if(variables.get(var)!=null&&!stack.isEmpty()){
            
            double real = variables.get(var).getRealPart()-stack.lastElement().getRealPart();
            double im = variables.get(var).getComplexPart()-stack.lastElement().getComplexPart();
            NumeroComplesso n = new NumeroComplesso(real, im);
            variables.set(var, n);
            
        }else if(stack.isEmpty()){
            mw.NoValueInStackToMessage();
        }else {
            mw.NoValueInVarToOperateMessage();
        }
        
        
    }
    
    public void addVar(int var){
        
        if(variables.get(var)!=null&&!stack.isEmpty()){
            
            double real = stack.lastElement().getRealPart()+variables.get(var).getRealPart();
            double im = stack.lastElement().getComplexPart()+variables.get(var).getComplexPart();
            NumeroComplesso n = new NumeroComplesso(real, im);
            variables.set(var, n);
            
        }else if(stack.isEmpty()){
            mw.NoValueInStackToOperateMessage();
        }else {
            mw.NoValueInVarToOperateMessage();
        }
        
        
    }
    
    public void varToStack(int var){
        
        NumeroComplesso n = getVar(var);
        
        if(n!=null){
            
            stack.add(n);
            
        }else{
            mw.NoValueInVarToOperateMessage();
        }
        
    }
    
    public void stackToVar(int var){
        
        if(!stack.isEmpty()){
            
            NumeroComplesso n = stack.drop();
            setVar(var, n);
            
        }else{
            mw.NoValueInStackToOperateMessage();
        }
        
    }
    
    public void addStack(){
        
        if(!stack.isEmpty()){
            
            NumeroComplesso n1 = stack.drop();
            
            if(!stack.isEmpty()){
                
                NumeroComplesso n2 = stack.drop();
                stack.add(calcolatore.add(n1,n2));
                
            }else{
                
                stack.add(n1);
                mw.NoValueInStackToOperateMessage();
                
            }
            
            
        }else{
            mw.NoValueInStackToOperateMessage();
        }
        
    }
    
    public void substractStack(){
        
        if(!stack.isEmpty()){
            
            NumeroComplesso n1 = stack.drop();
            
            if(!stack.isEmpty()){
                
                NumeroComplesso n2 = stack.drop();
                stack.add(calcolatore.substract(n1,n2));
                
            }else{
                
                stack.add(n1);
                mw.NoValueInStackToOperateMessage();
                
            }
            
            
        }else{
            mw.NoValueInStackToOperateMessage();
        }
        
    }
    
    public void multiplyStack(){
        
        if(!stack.isEmpty()){
            
            NumeroComplesso n1 = stack.drop();
            
            if(!stack.isEmpty()){
                
                NumeroComplesso n2 = stack.drop();
                stack.add(calcolatore.multiply(n1,n2));
                
            }else{
                
                stack.add(n1);
                mw.NoValueInStackToOperateMessage();
                
            }
            
            
        }else{
            mw.NoValueInStackToOperateMessage();
        }
        
    }
    
    public void divideStack(){
        
        if(!stack.isEmpty()){
            
            NumeroComplesso n1 = stack.drop();
            
            if(!stack.isEmpty()){
                
                NumeroComplesso n2 = stack.drop();
                NumeroComplesso n3 = calcolatore.divide(n1,n2);
                if(n3==null){
                    mw.CantDivideByZeroMessage();
                }else{
                    stack.add(n3);
                }
                
            }else{
                
                stack.add(n1);
                mw.NoValueInStackToOperateMessage();
                
            }
               
        }else{
            mw.NoValueInStackToOperateMessage();
        }
        
    }
    
    public void sqrtStack(){
        
        if(!stack.isEmpty()){
            
            NumeroComplesso n1 = stack.drop();
            stack.add(calcolatore.sqrt(n1));
             
        }else{
            mw.NoValueInStackToOperateMessage();
        }
        
    }
    
    public void invertSign(){
        
        if(!stack.isEmpty()){
            
            NumeroComplesso n1 = stack.drop();
            stack.add(calcolatore.invertSign(n1));
             
        }else{
            mw.NoValueInStackToOperateMessage();
        }
        
    }
    
    public void inputHandler(String s){
        
        boolean is_valid = isNumeric(s);
        if(!is_valid){
            
            is_valid = isCalculatorOpValid(s);
            if(!is_valid){
                
                is_valid = isStackOpValid(s);
                if(!is_valid){
                    
                    is_valid = isVarOpValid(s);
                    if(!is_valid){
                        
                        mw.InputErrorMessage();
                        
                    }
                    
                }
                
            }
            
            
        }
        
    }
    
    
}
