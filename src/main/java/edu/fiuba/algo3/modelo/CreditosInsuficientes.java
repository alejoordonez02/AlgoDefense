package edu.fiuba.algo3.modelo;

public class CreditosInsuficientes extends Exception {

    public CreditosInsuficientes(String errorMessage) {
        super(errorMessage);
    }
}