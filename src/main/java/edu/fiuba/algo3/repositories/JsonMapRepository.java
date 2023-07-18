package edu.fiuba.algo3.repositories;

import java.io.FileReader;
import java.io.IOException;

import edu.fiuba.algo3.modelo.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;
import java.util.ArrayList;

/*MapaParser parser = new MapaParser(mapa.json);
Mapa mapa = new Mapa (parser.parsear());*/

public class JsonMapRepository implements MapRepository {
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

    private Posicion buscarPasarelaSiguiente(boolean[][] pasarelas, Posicion posicion, Posicion anterior) {
        List<Posicion> posiciones = new ArrayList<Posicion>();

        posiciones.add(posicion.sumar(new Posicion(-1,0)));
        posiciones.add(posicion.sumar(new Posicion(0,1)));
        posiciones.add(posicion.sumar(new Posicion(1,0)));
        posiciones.add(posicion.sumar(new Posicion(0,-1)));

        for (Posicion p : posiciones)  {
			int posX = p.x();
			int posY = p.y();

			if (posX < 0) {
				posX = 0;
			}
			if (posX > pasarelas.length - 1) {
				posX = pasarelas.length - 1;
			}
			if (posY < 0) {
				posY = 0;
			}
			if (posY > pasarelas.length - 1) {
				posY = pasarelas.length - 1;
			}
			p = new Posicion(posX, posY);

            if(pasarelas[posX][posY] && !(p.equals(posicion))) {
				if (anterior == null) {
					return p;
				}
				if (!(p.equals(anterior))) {
					return p;
				}
            }
        }

        return null;
    }

    public Mapa parsear() throws IOException, FormatoJSONInvalido {
        JSONObject jsonObj = null;

        try {
            jsonObj = setJSON();
        } catch (ParseException e) {

            throw new RuntimeException(e);
        }

        JSONObject map = (JSONObject) jsonObj.get("Mapa");
        Parcela[][] mapa = new Parcela[map.size()][map.size()];
        boolean[][] pasarelas = new boolean[map.size()][map.size()];

        Pasarela pasarelaInicial = null;
        Pasarela pasarelaFinal = null;

        for (int x = 0; x < map.size(); x++) {
            JSONArray line = (JSONArray) map.get(Integer.toString(x + 1));

            for (int y = 0; y < map.size(); y++) {
                Parcela parcela = asignar((String) line.get(y), x, y);
                mapa[x][y] = parcela;
                if (("Pasarela".equals(line.get(y)))) {
                    pasarelaFinal = (Pasarela) parcela;
                    pasarelas[x][y] = true;

                    if (pasarelaInicial == null) {
                        pasarelaInicial = (Pasarela) parcela;
                    }
                } else {
                    pasarelas[x][y] = false;
                }
            }

        }

        Posicion posicionEncontrada = buscarPasarelaSiguiente(pasarelas, pasarelaInicial.getPosicion(), null);
		Pasarela pasarelaAnterior = pasarelaInicial;
		Pasarela pasarelaSiguiente = (Pasarela) mapa[posicionEncontrada.x()][posicionEncontrada.y()];
        pasarelaInicial.setSiguiente(pasarelaSiguiente);
		posicionEncontrada = buscarPasarelaSiguiente(pasarelas, pasarelaSiguiente.getPosicion(), pasarelaAnterior.getPosicion());
		while (posicionEncontrada != null) {
			pasarelaAnterior = pasarelaSiguiente;
			pasarelaSiguiente = (Pasarela) mapa[posicionEncontrada.x()][posicionEncontrada.y()];
			pasarelaAnterior.setSiguiente(pasarelaSiguiente);
			posicionEncontrada = buscarPasarelaSiguiente(pasarelas, pasarelaSiguiente.getPosicion(), pasarelaAnterior.getPosicion());
		}

        Mapa m = new Mapa(mapa, pasarelaInicial, pasarelaFinal);

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

            for (int x = 0; x < map.size(); x++) {
                JSONArray line = (JSONArray) map.get(Integer.toString(x + 1));

                for (int y = 0; y < map.size(); y++) {
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


