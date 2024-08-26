/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.analizador.lexico.backend;

/**
 * Enumerado que contiene a todos los tipos de tokens.
 * @author mynordma
 */
public enum TipoToken {
    
    IDENTIFICADOR("#FFD300"),
    SUMA("#FF33FF"),
    RESTA("#C19A6B"),
    EXPONENTE("#FCD0B4"),
    DIVISION("#B4D941"),
    MODULO("#D9AB41"),
    MULTIPLICACION("#D80073"),
    IGUAL("#6A00FF"),
    DIFERENTE("#3F2212"),
    MAYOR_QUE("#D9D441"),
    MENOR_QUE("#D94A41"),
    MAYOR_O_IGUAL_QUE("#E3C800"),
    MENOR_O_IGUAL_QUE("#F0A30A"),
    Y("#414ED9"),
    O("#41D95D"),
    NEGACION("#A741D9"),
    ASIGNACION_SIMPLE("#41D9D4"),
    ASIGNACION_COMPUESTA("#FFFFFF"),
    PALABRA_RESERVADA("#60A917"),
    ENTERO("#1BA1E2"),
    DECIMAL("#FFFF88"),
    CADENA("#E51400"),
    BOOLEANO("#FA6800"),
    CARACTER("#0050EF"),
    SQUARE1("#colorEspecial"),
    SQUARE2("#colorEspecial"),
    COMENTARIO("#B3B3B3"),
    PARENTESIS("#9AD8DB"),
    LLAVES("#DBD29A"),
    CORCHETES("#DBA49A"),
    COMA("#B79ADB"),
    PUNTO("#9ADBA6");
    
    private final String color;
    private String colorEspecial = "";

    public String getColorEspecial() {
        return colorEspecial;
    }
    
    TipoToken(String color){
        this.color = color;
    }
    
    public void setColorEspecial(String colorEspecial){
        this.colorEspecial = colorEspecial;
    }

    public String getColor() {
        return color;
    }
}
