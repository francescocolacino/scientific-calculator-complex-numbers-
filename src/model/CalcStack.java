/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Stack;

/**
 *
 * @author gabriel
 */
public class CalcStack<T> extends Stack<T>{
    
    
    
    public T drop(){
        return this.pop();
    }
    
    public boolean dup(){
        boolean canDup = false;
        if(!this.isEmpty()){
            canDup = true;
            this.add(this.lastElement());
        }
        
        return canDup;
    }
    
    public boolean swap(){
        boolean canSwap = false;
        
        if(this.size() >= 2){
            canSwap = true;
            
            T aux = this.drop();
            T aux2 = this.drop();
            this.add(aux);
            this.add(aux2);
        }
        
        return canSwap;
    }
    
    public boolean over(){
        boolean canOver = false;
        
        if(this.size() >= 2){
            canOver = true;
            
            T aux = this.drop();
            T aux2 = this.lastElement();
            
            this.add(aux);
            this.add(aux2);
        }
        
        return canOver;
    }
}
