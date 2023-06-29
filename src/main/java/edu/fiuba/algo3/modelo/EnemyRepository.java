package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.List;

public interface EnemyRepository {
    List<Enemigo> parsear(int turno, Pasarela pasarelaInicial) throws IOException;
}
