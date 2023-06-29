package edu.fiuba.algo3.modelo;

public class Torre implements Defensa {
    int costo;
    int tiempoDeConstruccion;
    Rango rango;
    int danio;
    int turno;
    Posicion posicion;

    public Torre() {
        this.turno = 0;
    }

    public int getCosto() {
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

    public int getTurno() {
        return this.turno;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public boolean operativa() {
        return turno >= tiempoDeConstruccion;
    }

    public int atacar(Parcela parcela) {
		if (parcela != null){
			return parcela.atacada(this.getDanio());
		}
		
		return 0;
    }

    public int atacar(Mapa mapa) {
        if (this.operativa()) {
            return atacar(this.rango.buscarEnemigo(mapa, this.posicion));
        }

        return 0;
    }

    public void pasarTurno() {
        this.turno++;
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
                && this.getTurno() == (c.getTurno())
                && this.getPosicion().equals(c.getPosicion());
        }
            return false;
    }

}