/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.analizador.lexico.backend;

/**
 *
 * @author mynordma
 */
public class Lexer {
    
    public Token generarToken(String palabra) throws RuntimeException{

        if (esPalabraReservada(palabra)) {
            return new Token(TipoToken.PALABRA_RESERVADA, palabra);
        } else if (esSuma(palabra)) {
            return new Token(TipoToken.SUMA, palabra);
        } else if (esResta(palabra)) {
            return new Token(TipoToken.RESTA, palabra);
        } else if (esExponente(palabra)) {
            return new Token(TipoToken.EXPONENTE, palabra);
        } else if (esDivision(palabra)) {
            return new Token(TipoToken.DIVISION, palabra);
        } else if (esModulo(palabra)) {
            return new Token(TipoToken.MODULO, palabra);
        } else if (esMultiplicacion(palabra)) {
            return new Token(TipoToken.MULTIPLICACION, palabra);
        } else if (esIgual(palabra)) {
            return new Token(TipoToken.IGUAL, palabra);
        } else if (esDiferente(palabra)) {
            return new Token(TipoToken.DIFERENTE, palabra);
        } else if (esMayorQue(palabra)) {
            return new Token(TipoToken.MAYOR_QUE, palabra);
        } else if (esMenorQue(palabra)) {
            return new Token(TipoToken.MENOR_QUE, palabra);
        } else if (esMayorOIgualQue(palabra)) {
            return new Token(TipoToken.MAYOR_O_IGUAL_QUE, palabra);
        } else if (esMenorOIgualQue(palabra)) {
            return new Token(TipoToken.MENOR_O_IGUAL_QUE, palabra);
        } else if (esY(palabra)) {
            return new Token(TipoToken.Y, palabra);
        } else if (esO(palabra)) {
            return new Token(TipoToken.O, palabra);
        } else if (esNegacion(palabra)) {
            return new Token(TipoToken.NEGACION, palabra);
        } else if (esAsignacionSimple(palabra)) {
            return new Token(TipoToken.ASIGNACION_SIMPLE, palabra);
        } else if (esAsignacionCompuesta(palabra)) {
            return new Token(TipoToken.ASIGNACION_COMPUESTA, palabra);
        } else if (esEntero(palabra)) {
            return new Token(TipoToken.ENTERO, palabra);
        } else if (esDecimal(palabra)) {
            return new Token(TipoToken.DECIMAL, palabra);
        } else if (esCadena(palabra)) {
            return new Token(TipoToken.CADENA, palabra);
        } else if (esBooleano(palabra)) {
            return new Token(TipoToken.BOOLEANO, palabra);
        } else if (esCaracter(palabra)) {
            return new Token(TipoToken.CARACTER, palabra);
        } else if (esSquare1(palabra)) {
            return new Token(TipoToken.SQUARE1, palabra);
        } else if (esSquare2(palabra)) {
            return new Token(TipoToken.SQUARE2, palabra);
        } else if (esComentario(palabra)) {
            return new Token(TipoToken.COMENTARIO, palabra);
        } else if (esParentesis(palabra)) {
            return new Token(TipoToken.PARENTESIS, palabra);
        } else if (esLlaves(palabra)) {
            return new Token(TipoToken.LLAVES, palabra);
        } else if (esCorchetes(palabra)) {
            return new Token(TipoToken.CORCHETES, palabra);
        } else if (esComa(palabra)) {
            return new Token(TipoToken.COMA, palabra);
        } else if (esPunto(palabra)) {
            return new Token(TipoToken.PUNTO, palabra);
        } else if (esIdentificador(palabra)) {
            return new Token(TipoToken.IDENTIFICADOR, palabra);
        } else {
            throw new RuntimeException("Token no reconocido: " + palabra);
        }
    }

    
    private boolean esIdentificador(String palabra) {
        Gramatica gramatica = new Gramatica(palabra);
        return gramatica.identificador();
    }

    private boolean esSuma(String palabra) {
        return palabra.equals("+");
    }

    private boolean esResta(String palabra) {
        return palabra.equals("-");
    }

    private boolean esExponente(String palabra) {
        return palabra.equals("^");
    }

    private boolean esDivision(String palabra) {
        return palabra.equals("/");
    }

    private boolean esModulo(String palabra) {
        return palabra.equals("Mod");
    }

    private boolean esMultiplicacion(String palabra) {
        return palabra.equals("*");
    }

    private boolean esIgual(String palabra) {
        return palabra.equals("==");
    }

    private boolean esDiferente(String palabra) {
        return palabra.equals("<>");
    }

    private boolean esMayorQue(String palabra) {
        return palabra.equals(">");
    }

    private boolean esMenorQue(String palabra) {
        return palabra.equals("<");
    }

    private boolean esMayorOIgualQue(String palabra) {
        return palabra.equals(">=");
    }

    private boolean esMenorOIgualQue(String palabra) {
        return palabra.equals("<=");
    }

    private boolean esY(String palabra) {
        return palabra.equals("And");
    }

    private boolean esO(String palabra) {
        return palabra.equals("Or");
    }

    private boolean esNegacion(String palabra) {
        return palabra.equals("Not");
    }

    private boolean esAsignacionSimple(String palabra) {
        return palabra.equals("=");
    }

    private boolean esAsignacionCompuesta(String palabra) {
        return palabra.equals("+=") || palabra.equals("-=") || palabra.equals("*=") || palabra.equals("/=");
    }

    private boolean esPalabraReservada(String palabra) {
        return palabra.equals("Module") || palabra.equals("End") || palabra.equals("Sub") || palabra.equals("Main") || palabra.equals("Dim") || palabra.equals("As") || palabra.equals("Integer") || palabra.equals("String") || palabra.equals("Boolean") || palabra.equals("Double") || palabra.equals("Char") || palabra.equals("Console.WriteLine") || palabra.equals("Console.ReadLine") || palabra.equals("If") || palabra.equals("ElseIf") || palabra.equals("Else") || palabra.equals("Then") || palabra.equals("While") || palabra.equals("Do") || palabra.equals("Loop") || palabra.equals("For") || palabra.equals("To") || palabra.equals("Next") || palabra.equals("Function") || palabra.equals("Return") || palabra.equals("Const");
    }

    private boolean esEntero(String palabra) {
        try {
            Integer.valueOf(palabra);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esDecimal(String palabra) {
        try {
            Double.valueOf(palabra);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esCadena(String palabra) {
        return palabra.length() >= 2 && palabra.startsWith("\"") && palabra.endsWith("\"");
    }

    private boolean esBooleano(String palabra) {
        return palabra.equals("True") || palabra.equals("False");
    }

    private boolean esCaracter(String palabra) {
        return palabra.length() == 3 && palabra.startsWith("'") && palabra.endsWith("'");
    }

    private boolean esSquare1(String palabra) {
        Gramatica gramatica = new Gramatica(palabra);
        return gramatica.square1();
    }

    private boolean esSquare2(String palabra) {
        Gramatica gramatica = new Gramatica(palabra);
        return gramatica.square2();
    }

    private boolean esComentario(String palabra) {
        return palabra.startsWith("'") && !palabra.endsWith("'");
    }

    private boolean esParentesis(String palabra) {
        return palabra.equals("(") || palabra.equals(")");
    }

    private boolean esLlaves(String palabra) {
        return palabra.equals("{") || palabra.equals("}");
    }

    private boolean esCorchetes(String palabra) {
        return palabra.equals("[") || palabra.equals("]");
    }

    private boolean esComa(String palabra) {
        return palabra.equals(",");
    }

    private boolean esPunto(String palabra) {
        return palabra.equals(".");
    }

}
