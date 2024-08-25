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
    private String filaParametro;
    private String columnaParametro;
    private String colorParametro;

    public Gramatica(String palabra) {
        this.palabra = palabra;
    }
    
    public boolean square1(){
        try {
            if(esSquare()){
            String[] parametros = eliminarEspaciosEnBlanco(palabra.substring(21, palabra.length()-1)).split(",");
                
            if(palabra.charAt(20) != ','){
                return false;
            }else if(!parametrosValidos(parametros)){
                return false;
            }
            
            filaParametro = parametros[0];
            columnaParametro = parametros[1];
            colorParametro = palabra.substring(13, 20);
            return true;
        }
        } catch (Exception e) {
           return false; 
        }
        return false;
        
    }
    
    public boolean square2(){
        if(esSquare()){
            String[] parametros = eliminarEspaciosEnBlanco(palabra.substring(20, palabra.length()-1)).split(",");
            if("".equals(parametros[0])){
                colorParametro = palabra.substring(13, 20);
                return true;
            }
        }
        return false;
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
    
    //Metodos auxiliares
    
    private char charActual() {
        if (index >= palabra.length()) {
            return '\0'; // Fin de la cadena
        }
        return palabra.charAt(index);
    }
    
    private boolean esLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    
    private boolean esNumeroOGuionBajo(char c) {
    return (c >= '0' && c <= '9') || c == '_';
}

    private boolean esSquare() {
    if (palabra.length() >= index + 14) {
        String prefijo = palabra.substring(index, index + 14); 
        return prefijo.equals("Square.Color(#") && palabra.endsWith(")");
    }
    return false;
}

    
    private String eliminarEspaciosEnBlanco(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != ' ') {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }
    
    private boolean parametrosValidos(String[] parametros) {
        if (parametros.length != 2) {
            return false;
        }

        for (String parametro : parametros) {
            try {
                int numero = Integer.parseInt(parametro);
                if (numero <= 0) {
                    return false; 
                }
            } catch (NumberFormatException e) {
                return false; 
            }
        }
        return true; 
    }

    public String getFilaParametro() {
        return filaParametro;
    }

    public String getColumnaParametro() {
        return columnaParametro;
    }

    public String getColorParametro() {
        return colorParametro;
    }


}
