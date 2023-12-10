/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DecimalFormat;

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
        DecimalFormat numberFormat = new DecimalFormat("#.###");

        
        if((int)(imaginaryPart*1000) < 0){
            sign = "-";
        }else if((int)(imaginaryPart*1000) == 0)
            sign = "";
        
        if((int)(realPart*1000) != 0){
            realpart = numberFormat.format(realPart);
        }
        else if((int)(this.imaginaryPart*1000) == 0){
            realpart = "0";
        }
        
        if((int)(imaginaryPart*1000) != 0){
            System.out.print("imaginari part: " + imaginaryPart);
            imaginarypart = numberFormat.format(Math.abs(imaginaryPart)) + "j";
        }
        
        return(realpart + sign + imaginarypart);
        
    }
    
    public double getModule(){
        
        return(Math.sqrt((realPart*realPart)+(imaginaryPart*imaginaryPart)));
        
    }
    
    public double getAngle(){
        
        double angle;
        
        if(realPart==0&&imaginaryPart==0){
            angle=0;
        }else if(realPart==0){
            if(imaginaryPart>0){
                angle = Math.PI/2;
            }else{
                angle = (3*Math.PI)/2;
            }
        }else if(realPart>0&&imaginaryPart>0){
            angle=Math.atan(imaginaryPart/realPart);
        }else if(realPart<0&&imaginaryPart>0){
            angle=Math.PI - Math.atan(imaginaryPart/Math.abs(realPart));
        }else if(realPart<0&&imaginaryPart<0){
            angle=Math.PI + Math.atan(Math.abs(imaginaryPart)/Math.abs(realPart));
        }else{
            angle=2*Math.PI + Math.atan(Math.abs(imaginaryPart)/realPart);
        }
        
        return(angle);
        
    }
    
}
