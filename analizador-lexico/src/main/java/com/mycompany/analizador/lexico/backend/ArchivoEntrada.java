/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador.lexico.backend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author mynordma
 */
public class ArchivoEntrada {
    
    private List<Integer> cantidadPalabrasEnLineas = new ArrayList<>();
    
    public void leerContenido(JFileChooser fileChooser, JTextArea textArea) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(archivoSeleccionado))) {
                textArea.read(reader, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    public String[] separarTokens(String texto) {
        int contadorDePalabras = 0;
        
        ArrayList<String> palabras = new ArrayList<>();
        StringBuilder palabraActual = new StringBuilder(); 
                
        // Iterando por cada caracter en el texto.
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
                
            if (c != ' ' && c != '\n') {
                palabraActual.append(c);
            } else if (palabraActual.length() > 0) {
                if(!palabraActual.toString().startsWith("Square.Color(")){
                    // Verificando si la palabra esta compuesta con parentesis ().
                    ArrayList<String> temp = separarPalabraCompuesta(palabraActual.toString());
                    for (String temp1 : temp) {
                        palabras.add(temp1);
                    }
                    palabraActual.setLength(0); 
                    contadorDePalabras++;
                }else if(palabraActual.toString().startsWith("Square.Color(") && palabraActual.toString().endsWith(")")){
                    ArrayList<String> temp = separarPalabraCompuesta(palabraActual.toString());
                    for (String temp1 : temp) {
                        palabras.add(temp1);
                    }
                    palabraActual.setLength(0); 
                    contadorDePalabras++;
                }
                
            }
            
            if(c == '\n'){
                cantidadPalabrasEnLineas.add(contadorDePalabras);
                contadorDePalabras = 0;
            }
            
            
        }

        // Agregando la ultima palabra.
        if (palabraActual.length() > 0) {
            ArrayList<String> temp = separarPalabraCompuesta(palabraActual.toString());
            for (String temp1 : temp) {
                palabras.add(temp1);
            }
            contadorDePalabras++;
            cantidadPalabrasEnLineas.add(contadorDePalabras);
        }

        return palabras.toArray(String[]::new);
    }
    
    public ArrayList<String> separarPalabraCompuesta(String palabra) {
        ArrayList<String> resultado = new ArrayList<>();

        if (palabra.endsWith("()")) {
            // Caso: identificador + parentesis
            String identificador = palabra.substring(0, palabra.length() - 2);
            if (!identificador.isEmpty()) {
                resultado.add(identificador);
            }
            resultado.add("("); 
            resultado.add(")"); 
        } else if (palabra.equals("()")) {
            // Caso: solo parentesis ()
            resultado.add("("); 
            resultado.add(")");
        } else {
            // Palabra que no sigue la estructura compuesta
            resultado.add(palabra);
        }
        

        return resultado;
    }

    public List<Integer> getCantidadPalabrasEnLineas() {
        return cantidadPalabrasEnLineas;
    }

}
