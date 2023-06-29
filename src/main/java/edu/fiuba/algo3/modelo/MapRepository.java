package edu.fiuba.algo3.modelo;

//import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface MapRepository {
    Mapa parsear() throws IOException, FormatoJSONInvalido;
}
