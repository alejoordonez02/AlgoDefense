package edu.fiuba.algo3.modelo;

public class Torre implements Defensa {
    Credito costo;
    int tiempoDeConstruccion;
    Rango rango;
    int danio;
    Posicion posicion;

    public Credito getCosto() {
        return this.costo;
    }

    public int getTiempoDeConstruccion() {
        return this.tiempoDeConstruccion;
    }

    public Rango getRango() {
        return this.rango;
    }

    public int getDanio() {
        return this.danio;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean operativa() {
        return tiempoDeConstruccion <= 0;
    }

    public Credito atacar(Parcela parcela) {
		if (parcela != null){
			return parcela.atacada(this.getDanio());
		}
		
		return new Credito(0);
    }

    public Credito atacar(Mapa mapa) {
        if (this.operativa()) {
            return atacar(this.rango.buscarEnemigo(mapa, this.posicion));
        }

        return new Credito(0);
    }

    public void pasarTurno() {
        this.tiempoDeConstruccion--;
    }

    public void jugarTurno(Mapa mapa, Jugador jugador) {
        jugador.cobrar(this.atacar(mapa));
        this.pasarTurno();
    }

    @Override
    public boolean equals(Object o){

        if (this.getClass().equals(o.getClass())) {
            Torre c = (Torre)o;

            return this.getCosto() == (c.getCosto())
                && this.getTiempoDeConstruccion() == (c.getTiempoDeConstruccion())
                && this.getRango().equals(c.getRango())
                && this.getDanio() == (c.getDanio())
                && this.getPosicion().equals(c.getPosicion());
        }
            return false;
    }

}