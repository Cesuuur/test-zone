package com.company;

public class stackTrace {

    public static int divide(int numerador, int denominador) {

        return numerador/denominador;

    }

    public static void main(String[] args) {

        divide(100, 0); // divide entre cero para que de error

    }
}
