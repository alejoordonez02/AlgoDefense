package edu.fiuba.algo3.repositories;

import java.io.FileReader;
import java.io.IOException;

import edu.fiuba.algo3.modelo.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/*MapaParser parser = new MapaParser(mapa.json);
Mapa mapa = new Mapa (parser.parsear());*/

public class JsonMapRepository implements MapRepository {
    final int SIZE = 15;
    private String path;

    public JsonMapRepository(String p) {
        this.path = p;
    }

    private JSONObject setJSON() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.path);
        Object obj = parser.parse(reader);
        JSONObject jsonObj = (JSONObject) obj;
        reader.close();
        return jsonObj;
    }

    public Mapa parsear() throws IOException, FormatoJSONInvalido {
        JSONObject jsonObj = null;

        try {
            jsonObj = setJSON();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject map = (JSONObject) jsonObj.get("Mapa");
        Parcela[][] mapa = new Parcela[SIZE][SIZE];

        for (int x = 0; x < SIZE; x++) {
            JSONArray line = (JSONArray) map.get(Integer.toString(x + 1));

            for (int y = 0; y < SIZE; y++) {
                mapa[x][y] = asignar((String) line.get(x), x, y);
            }
        }

        Mapa m = new Mapa(mapa);

        return m;
    }

    private Parcela asignar(String s, int x, int y) throws FormatoJSONInvalido {
        Parcela parcela = null;

        switch (s) {
            case "Tierra":
                parcela = new Tierra(new Posicion(x, y));
                break;
            case "Rocoso":
                parcela = new Roca(new Posicion(x, y));
                break;
            case "Pasarela":
                parcela = new Pasarela(new Posicion(x, y));
                break;
            default:
                throw new FormatoJSONInvalido("El formato del archivo JSON es incorrecto");
        }
		
        return parcela;
    }

    public void formatoCorrecto() throws IOException, ParseException, JSONVacio, FormatoJSONInvalido {
        JSONObject jsonObj = setJSON();

        if (jsonObj.isEmpty()) {
            throw new JSONVacio("El archivo JSON de enemigos esta vacio.");
        }

        try {
            JSONObject map = (JSONObject) jsonObj.get("Mapa");

            for (int x = 0; x < SIZE; x++) {
                JSONArray line = (JSONArray) map.get(Integer.toString(x + 1));

                for (int y = 0; y < SIZE; y++) {
                    String s = (String) line.get(y);

                    if (!s.equals("Tierra") && !s.equals("Rocoso") && !s.equals("Pasarela")) {
                        throw new FormatoJSONInvalido("El formato del archivo JSON de enemigos esta vacio");
                    }
                }
            }
        } catch (Exception e) {
            throw new FormatoJSONInvalido("El formato del archivo JSON de enemigos esta vacio");
        }
    }

}


