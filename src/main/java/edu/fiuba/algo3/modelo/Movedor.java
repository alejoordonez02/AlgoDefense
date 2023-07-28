package edu.fiuba.algo3.modelo;

public interface Movedor {

	public Parcela getParcela();

    public Parcela mover(Enemigo enemigo);

	public void ralentizado(int ralentizacion);

}
