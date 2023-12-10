/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author gabriel
 */
public class Calcolatore {
    
    public NumeroComplesso add(NumeroComplesso n1, NumeroComplesso n2){
        
        double parte_real = n2.getRealPart() + n1.getRealPart();
        double parte_imaginary = n2.getComplexPart() + n1.getComplexPart();
        NumeroComplesso result = new NumeroComplesso(parte_real, parte_imaginary);
        return(result);
        
    }
    
    public NumeroComplesso substract(NumeroComplesso n1, NumeroComplesso n2){
        
        double parte_real = n2.getRealPart() - n2.getRealPart();
        double parte_imaginary = n2.getComplexPart() - n1.getComplexPart();
        NumeroComplesso result = new NumeroComplesso(parte_real, parte_imaginary);
        return(result);
        
    }
    
    public NumeroComplesso multiply(NumeroComplesso n1, NumeroComplesso n2){
        
        double parte_real = n2.getRealPart() * n1.getRealPart();
        double parte_imaginary = n2.getComplexPart() * n1.getComplexPart();
        NumeroComplesso result = new NumeroComplesso(parte_real, parte_imaginary);
        return(result);
        
    }
    
    public NumeroComplesso divide(NumeroComplesso n1, NumeroComplesso n2){
        
        double parte_real = n2.getRealPart() / n1.getRealPart();
        double parte_imaginary = n2.getComplexPart() / n1.getComplexPart();
        NumeroComplesso result = new NumeroComplesso(parte_real, parte_imaginary);
        return(result);
        
    }
    
    public NumeroComplesso invertSign(NumeroComplesso n1){
        
        int cambio = -1;
        double parte_real = n1.getRealPart()*cambio;
        double parte_imaginary = n1.getComplexPart()*cambio;
        NumeroComplesso result = new NumeroComplesso(parte_real, parte_imaginary);
        return(result);
        
    }
    
    public NumeroComplesso sqrt(NumeroComplesso n1){
        
        double module = Math.sqrt(n1.getModule());
        double arg = n1.getAngle()/2;
        
        double parte_real = module*Math.cos(arg);
        double parte_imaginary = module*Math.sin(arg);
        NumeroComplesso result = new NumeroComplesso(parte_real, parte_imaginary);
        return(result);
        
    }
    
}
