/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador.lexico.backend;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mynordma
 */
public class Automata {
    
    private final String texto;

    public Automata(String texto) {
        this.texto = texto;
    }
    
    public void mostrarAutomata(String lexema) {
        try {
            // Crear archivo DOT a partir del lexema
            String dotPath = generarArchivoDOT(lexema);
            
            // Generar imagen PNG usando Graphviz
            String pngPath = generarImagenAutomata(dotPath, lexema);
            
            // Mostrar la imagen en un JDialog
            mostrarImagen(pngPath, dotPath);
            
        } catch (IOException e) {
            System.out.println("Error al crear el automata");
        }
    }

    private String generarArchivoDOT(String lexema) throws IOException {
        
        StringBuilder dotContent = new StringBuilder();
        dotContent.append("digraph Automata {\n");
        dotContent.append("    rankdir=LR;\n");
        dotContent.append("    node [shape = circle];\n");

        // Generar los estados y transiciones
        for (int i = 0; i < lexema.length(); i++) {
            dotContent.append("    q").append(i).append(" -> q").append(i + 1)
                      .append(" [label=\"").append(lexema.charAt(i)).append("\"];\n");
        }
        dotContent.append("    q").append(lexema.length())
                  .append(" [shape=doublecircle];\n"); // Estado final
        dotContent.append("}\n");

        // Guardar el archivo DOT
        String filePath = "automata" + lexema + ".dot";
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(dotContent.toString());
        }
        
        return filePath;
    }

    private String generarImagenAutomata(String dotPath, String lexema) throws IOException {
        
        String outputPngPath = "automata" + lexema + ".png";
        String comando = "dot -Tpng " + dotPath + " -o " + outputPngPath;

        // Ejecutar el comando Graphviz
        Runtime.getRuntime().exec(comando);

        // Dar tiempo para que se genere la imagen
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Error al generar la imagen");
        }
        
        return outputPngPath;
    }

    private void mostrarImagen(String pngPath, String dotPath) {
        // Esperar a que el archivo PNG se genere
        File pngFile = new File(pngPath);
        while (!pngFile.exists()) {
            try {
                Thread.sleep(100); // Esperar 100 ms
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }

        // Crear un JDialog para mostrar la imagen
        JDialog dialog = new JDialog();
        dialog.setTitle("Automata");

        JPanel panel = new JPanel(new BorderLayout());

        // Crear un JLabel para el texto
        JLabel textoLabel = new JLabel(texto, JLabel.CENTER);
        panel.add(textoLabel, BorderLayout.NORTH);

        // Cargar la imagen y mostrarla en un JLabel
        ImageIcon icon = new ImageIcon(pngPath);
        JLabel imagenLabel = new JLabel(icon);
        panel.add(imagenLabel, BorderLayout.CENTER); 

        dialog.add(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // Eliminar el archivo DOT y la imagen PNG después de mostrar
        pngFile.delete();
        new File(dotPath).delete();
    }


}

