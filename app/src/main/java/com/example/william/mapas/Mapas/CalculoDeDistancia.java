package com.example.william.mapas.Mapas;

/**
 * Created by william on 24/03/2016.
 */
public class CalculoDeDistancia {

    static final double constante = 180 / Math.PI; // esta constante serve para transformar graus em radianos,
    // pois o valor da latitude e longitude é dado em graus
    static final int raio = 6378100; //raio em metros

    public final double distanciaEntrePontos(double latitude0, double longitude0, double latitude1, double longitude1){
        double distancia = 0;
        double cosD = 0;

        double lat0 = latitude0/constante;
        double lat1 = latitude1/constante;
        double lon0 = longitude0/constante;
        double lon1 = longitude1/constante;

        cosD = Math.sin(lat1)*Math.sin(lat0) + Math.cos(lat1)*Math.cos(lat0)*Math.cos(lon1-lon0);
        distancia = Math.acos(cosD)*raio;

        return distancia;
    }
}
