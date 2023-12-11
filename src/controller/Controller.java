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
    public MainView mw;
    
    public Controller(){
        mw = new MainView();
        mw.setController(this);
        stack = new CalcStack<>();
        variables = new ArrayList<>();
        for(int i = 'a'; i <= 'z'; ++i){
            variables.add(null);
        }
    }
    
    private boolean isNumeric(String input){
        
        boolean es_num = false;
        
        if(input!=null && !input.isEmpty() && 
                ((input.charAt(0)>='0'&&input.charAt(0)<='9')
                ||((input.charAt(0)=='+'||input.charAt(0)=='-')&&input.length()>1))){
            
            int contador=0;
            es_num=true;
            String parte_real = "";
            String parte_imaginary = "";
            
            if(input.charAt(0)=='+' || input.charAt(0)=='-'){
                parte_real += input.charAt(0);
                contador++;
            }
            
            if(input.charAt(contador)<'0'|| input.charAt(contador)>'9'){
                es_num = false;
            }
            
            for(; input.charAt(contador)>='0'&&input.charAt(contador)<='9' && contador <input.length()-1;contador++){
                parte_real += input.charAt(contador);
            }
            
            if(input.charAt(contador)>='0'&&input.charAt(contador)<='9'){
                parte_real += input.charAt(contador);
                contador++;
            }
            
            if(contador < input.length()){
                if(input.charAt(contador)=='j'){
                
                    parte_imaginary = parte_real;
                    parte_real = "0";
                    ++contador;

                }
            }
            
            if(contador<input.length() && es_num){
                if(((input.charAt(contador)=='+'||input.charAt(contador)=='-')
                    &&!parte_real.isEmpty()) || (!parte_real.isEmpty())){
                
                    if(input.charAt(contador)=='+' || input.charAt(contador)=='-'){

                        parte_imaginary += input.charAt(contador);
                        contador++;

                    }
                    
                    if(contador<input.length()){
                        if(input.charAt(contador)>='0'&&input.charAt(contador)<='9'){

                            for(; input.charAt(contador)>='0'&&input.charAt(contador)<='9'&&contador<input.length()-1;contador++){
                                parte_imaginary += input.charAt(contador);
                            }
                            
                            if(input.charAt(contador)>='0'&&input.charAt(contador)<='9'){
                                parte_imaginary += input.charAt(contador);
                                ++contador;
                            }

                            if(contador!=input.length()-1||input.charAt(contador)!='j'){

                                es_num = false;

                            }

                        } else{

                            es_num = false;

                        }
                    }
                    
                } else{

                    es_num = false;

                }
            }
            
            
            if(es_num){
                if(parte_imaginary.isEmpty()){
                    stack.add(new NumeroComplesso(Double.parseDouble(parte_real)));
                }else{
                    stack.add(new NumeroComplesso(Double.parseDouble(parte_real), Double.parseDouble(parte_imaginary)));
                }
                
                mw.addToStack(stack.lastElement().toString());
                
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
                    mw.cleanStack();
                    break;
                case "drop":
                    stack.drop();
                    es_op=true;
                    mw.drop();
                    break;
                case "dup":
                    stack.dup();
                    es_op=true;
                    mw.dup(stack.lastElement().toString());
                    break;
                case "swap":
                    NumeroComplesso n1 = stack.lastElement();
                    stack.swap();
                    es_op=true;
                    mw.swap(n1.toString(), stack.lastElement().toString());
                    break;
                case "over":
                    stack.over();
                    es_op=true;
                    mw.over(stack.lastElement().toString());
                    break;    
                    
            }
            
        }
        
        return(es_op);
        
    }
    
    private boolean isVarOpValid(String input){
        
        boolean es_op = false;
        
        if(input!=null && !input.isEmpty() && input.length()==2){
            if(input.charAt(0)=='>' && input.charAt(1)>='a' && input.charAt(0)<='z'){
                
                stackToVar(input.charAt(1)-'a');
                es_op = true;
                
            }else if(input.charAt(0)=='<' && input.charAt(1)>='a' && input.charAt(0)<='z'){
                
                varToStack(input.charAt(1)-'a');
                es_op = true;
                
            }else if(input.charAt(0)=='+' && input.charAt(1)>='a' && input.charAt(0)<='z'){
                
                addVar(input.charAt(1)-'a');
                es_op = true;
                
            }else if(input.charAt(0)=='-' && input.charAt(1)>='a' && input.charAt(0)<='z'){
                
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
        mw.setVar(var, n.toString());
        mw.removeFromStack();            
        mw.updateView();
        
    }
    
    public void substractVar(int var){
        
        if(variables.get(var)!=null&&!stack.isEmpty()){
            NumeroComplesso n1 = variables.get(var);
            NumeroComplesso n2 = stack.lastElement();
            
            NumeroComplesso n = Calcolatore.substract(n1,n2);
            this.setVar(var, n);
            
        }else if(stack.isEmpty()){
            mw.NoValueInStackToOperateMessage();
        }else {
            mw.NoValueInVarToOperateMessage();
        }
        
        
    }
    
    public void addVar(int var){
        
        if(variables.get(var)!=null&&!stack.isEmpty()){
            NumeroComplesso n1 = stack.lastElement();
            NumeroComplesso n2 = variables.get(var);

            NumeroComplesso n = Calcolatore.add(n1, n2);
            this.setVar(var, n);
            
        }else if(stack.isEmpty()){
            mw.NoValueInStackToOperateMessage();
        }else {
            mw.NoValueInVarToOperateMessage();
        }
        
        
    }
    
    public void varToStack(int var){
        
        NumeroComplesso n = getVar(var);
        if(n!=null){
            mw.addToStack(n.toString());
            stack.add(n);
            mw.setVar(var, Character.toString(var+'a'));           
            mw.updateView();
            
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
                stack.add(Calcolatore.add(n1,n2));
                mw.processBinaryOp(stack.lastElement().toString());
                
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
                stack.add(Calcolatore.substract(n1,n2));
                mw.processBinaryOp(stack.lastElement().toString());
                
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
                stack.add(Calcolatore.multiply(n1,n2));
                System.out.print("Mult: " + stack.lastElement().toString());
                mw.processBinaryOp(stack.lastElement().toString());
                
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
                if(n2.getRealPart() == 0 && n2.getComplexPart() == 0){
                    mw.CantDivideByZeroMessage();
                    stack.add(n2);
                    stack.add(n1);
                }else{
                    NumeroComplesso n3 = Calcolatore.divide(n1,n2);
                    stack.add(n3);
                    mw.processBinaryOp(stack.lastElement().toString());
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
            stack.add(Calcolatore.sqrt(n1));
            mw.processUnaryOp(stack.lastElement().toString());
             
        }else{
            mw.NoValueInStackToOperateMessage();
        }
        
    }
    
    public void invertSign(){
        if(!stack.isEmpty()){
            
            NumeroComplesso n1 = stack.drop();
            stack.add(Calcolatore.invertSign(n1));
            mw.processUnaryOp(stack.lastElement().toString());
             
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
    
    public void finish (int i) {
        if (mw.confirmExitMessage()) {
          System.exit(i);
        }
    }
    
    
}
