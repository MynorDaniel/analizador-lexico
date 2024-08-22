/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador.lexico.backend;

/**
 *
 * @author mynordma
 */
public class Gramatica {
    
    private final String palabra;
    private int index = 0;

    public Gramatica(String palabra) {
        this.palabra = palabra;
    }
    
    public boolean identificador(){
        if(esLetra(charActual())){
            
            while(index != palabra.length()){
                
                if(!(esNumeroOGuionBajo(charActual()) || esLetra(charActual()))){
                    return false;
                }
                index++;
            }
            return true;
        }
        return false;
    }
    
    private char charActual() {
        if (index >= palabra.length()) {
            return '\0'; // Fin de la cadena
        }
        return palabra.charAt(index);
    }
    
    private boolean esLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    
    public boolean esNumeroOGuionBajo(char c) {
    return (c >= '0' && c <= '9') || c == '_';
}


}
