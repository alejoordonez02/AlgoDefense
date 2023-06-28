package edu.fiuba.algo3.modelo;

public class Torre implements Defensa {
    int costo;
    int tiempoDeConstruccion;
    int rangoDeAtaque;
    int danio;
    int turno;
    Posicion posicion;

    public Torre() {
        this.posicion = null;
    }

    public int getCosto() {
        return this.costo;
    }

    public int getTiempoDeConstruccion() {
        return this.tiempoDeConstruccion;
    }

    public int getRangoDeAtaque() {
        return this.rangoDeAtaque;
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

    public void pasarTurno() {
        this.turno++;
    }

    @Override
    public boolean equals(Object o){
        if (this.getClass().equals(o.getClass())) {
            Torre c = (Torre)o;
            return this.getCosto() == (c.getCosto())
                && this.getTiempoDeConstruccion() == (c.getTiempoDeConstruccion())
                && this.getRangoDeAtaque() == (c.getRangoDeAtaque())
                && this.getDanio() == (c.getDanio())
                && this.getTurno() == (c.getTurno())
                && this.getPosicion().equals(c.getPosicion());
        }
            return false;
    }

}