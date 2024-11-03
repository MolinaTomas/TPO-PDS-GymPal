package com.uade.gymapp.model;

public class BajarPeso extends Objetivo {
    private double pesoObjetivo;

    // Constructor
    public BajarPeso () {}

    public BajarPeso(Socio socio) {
        pesoObjetivo = calcularPesoObjetivo(null);
    }

    @Override
    public Rutina generarRutina(Socio socio) {
        if (pesoObjetivo==0.0) {
            pesoObjetivo = calcularPesoObjetivo(socio);
        }


    }

    @Override
    public void calcularProgreso() {
    }

    private double calcularPesoObjetivo(Socio socio) {
        int altura = socio.getAltura();
        double imc = socio.getSexo().equals("hombre") ? 22.5 : 21.5;
        return (imc*(altura*altura));
    }
}
