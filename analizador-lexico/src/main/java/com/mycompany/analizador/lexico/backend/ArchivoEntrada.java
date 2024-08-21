/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador.lexico.backend;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author mynordma
 */
public class ArchivoEntrada {
    
    public void leerContenido(JFileChooser fileChooser, JTextArea textArea) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(archivoSeleccionado))) {
                textArea.read(reader, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    
    public String[] separarTokens(String texto) {
        ArrayList<String> palabras = new ArrayList<>();
        StringBuilder palabraActual = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c != ' ') {
                palabraActual.append(c);
            } else if (palabraActual.length() > 0) {
                palabras.add(palabraActual.toString());
                palabraActual.setLength(0);
            }
        }

        if (palabraActual.length() > 0) {
            palabras.add(palabraActual.toString());
        }

        return palabras.toArray(String[]::new);
    }
}
