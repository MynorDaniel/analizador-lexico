/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador.lexico.backend;

/**
 *
 * @author mynordma
 */
public class Token {
    private final TipoToken tipo;
    private final String lexema;
    private int filaEditor;
    private int columnaEditor;

    public Token(TipoToken tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setFilaEditor(int filaEditor) {
        this.filaEditor = filaEditor;
    }

    public void setColumnaEditor(int columnaEditor) {
        this.columnaEditor = columnaEditor;
    }

    public int getFilaEditor() {
        return filaEditor;
    }

    public int getColumnaEditor() {
        return columnaEditor;
    }
    
    
}
