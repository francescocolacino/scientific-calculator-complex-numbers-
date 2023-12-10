/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gabriel
 */
public class NumeroComplesso {
    
    private double realPart;
    private double imaginaryPart;
    
    public NumeroComplesso(double real){
        
        realPart = real;
        imaginaryPart = 0;
        
    }
            
    public NumeroComplesso(double real,double imaginary){
        
        realPart = real;
        imaginaryPart = imaginary;
        
    }
    
    public NumeroComplesso(NumeroComplesso n){
        
        realPart = n.realPart;
        imaginaryPart = n.imaginaryPart;
        
    }
    
    public double getRealPart(){
        
        return(realPart);
        
    }
    
    public double getComplexPart(){
        
        return(imaginaryPart);
        
    }
    
    public String toString(){
        
        String sign = "+";
        String realpart = "";
        String imaginarypart = "";
        
        if(imaginaryPart < 0){
            sign = "-";
        }else if(imaginaryPart == 0)
            sign = "";
        
        if(realPart != 0){
            realpart = String.valueOf(realPart);
        }
        
        if(imaginaryPart != 0){
            imaginarypart = String.valueOf(Math.abs(imaginaryPart)) + "j";
        }
        
        return(realpart + sign + imaginarypart);
        
    }
}
