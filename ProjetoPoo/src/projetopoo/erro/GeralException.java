/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo.erro;

/**
 *
 * @author victor
 */ 
public class GeralException extends Exception {
    public GeralException(){
        super();
    }
    
    public GeralException(Exception e){
        super(e);
    }
    
    public GeralException(String x){
        super(x);
    }
}

    

