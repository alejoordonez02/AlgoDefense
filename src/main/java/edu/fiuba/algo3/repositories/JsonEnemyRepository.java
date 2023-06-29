package edu.fiuba.algo3.repositories;
////import org.json.simple.JSONobject;

import edu.fiuba.algo3.modelo.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonEnemyRepository implements EnemyRepository {
    private String path;

    public JsonEnemyRepository(String p) {
        this.path = p;
    }

    private JSONArray setJSON()throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(this.path);
        Object obj = parser.parse(reader);
        JSONArray jsonArr = (JSONArray) obj;
        reader.close();
        return jsonArr;
    }


    private int turno(int t){

        return ((t-1) % 12) + 1;
    }


    public List<Enemigo> parsear(int t, Pasarela pasarelaInicial) throws IOException {
        
        t = this.turno(t);
        JSONArray map = null;

        try {
            map = setJSON();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<Enemigo> enemigos = new ArrayList<Enemigo>();
        JSONObject turno = (JSONObject) map.get(t-1);
        JSONObject e = (JSONObject) turno.get("enemigos");

        Object hormiga = e.get("hormiga");
        for(int i = 0; i < (Long) hormiga; i++){

            enemigos.add(asignar("hormiga", pasarelaInicial));
        }

        Object arana = e.get("arana");
        for(int i = 0; i < (Long) arana; i++){

            enemigos.add(asignar("arana", pasarelaInicial));

        }

        Object topo = e.get("topo");
        for(int i = 0; i < (Long) topo; i++){

            enemigos.add(asignar("topo", pasarelaInicial));

        }

        Object lechuza = e.get("lechuza");
        for(int i = 0; i < (Long) lechuza; i++){

            enemigos.add(asignar("lechuza", pasarelaInicial));

        }     

        return enemigos;
    }

    private Enemigo asignar(String s, Pasarela pasarelaInicial){
        Enemigo e = null;
        switch (s){
            case "arana":
                e = new Arania(pasarelaInicial);
                break;
            case "hormiga":
                e = new Hormiga(pasarelaInicial);
                break;
            case "topo":
                e = new Topo(pasarelaInicial);
                break;
            case "lechuza":
                e = new Lechuza(pasarelaInicial);
                break;
        }
        return e;
    }

    public void formatoCorrecto() throws IOException, ParseException, JSONVacio, FormatoJSONInvalido {
        JSONArray map = setJSON();

        if(map.isEmpty()) {
            throw new JSONVacio("El archivo JSON de enemigos esta vacio.");
        }

        for(int i = 0; i < map.size(); i++){
            JSONObject turnoData = (JSONObject) map.get(i);
			
            try{
                JSONObject enemigos = (JSONObject) turnoData.get("enemigos");
                Object hormiga = enemigos.get("hormiga");
                Object arana = enemigos.get("arana");
                Object topo = enemigos.get("topo");
                Object lechuza = enemigos.get("lechuza");
            } catch (Exception e){
                throw new FormatoJSONInvalido("El formato del archivo JSON de enemigos esta vacio");
            }
        }
    }
}