package com.uade.gymapp.gymapp.model;

import com.uade.gymapp.gymapp.model.dto.RutinaDTO;
import com.uade.gymapp.gymapp.model.observer.TrofeoObserver;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Rutina {
    private List<Entrenamiento> entrenamientos;
    private Objetivo objetivo;
    private List<TrofeoObserver> Observadores;

    public Rutina(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public RutinaDTO toDto() {
        return new RutinaDTO(entrenamientos.stream().map(Entrenamiento::toDto).toList(), objetivo.toDto());
    }

    public void refuerzoRutina() {
        if (getEntrenamientos() == null) {
            System.out.println("entrenamientos no disponibles");
            return;
        }

        for (Entrenamiento entrenamiento : getEntrenamientos()) {
            for (Ejercicio ejercicio : entrenamiento.getEjercicios()) {
                // Incrementar repeticiones, series y peso a cada ejercicio
                ejercicio.setRepeticiones(ejercicio.getRepeticiones() + 1);
                ejercicio.setSeries(ejercicio.getSeries() + 1);
                ejercicio.setPeso(ejercicio.getPeso() + 2.5);
            }
        }
    }

    public void registrarProgreso(Socio socio) {
        notifyObservers(socio);
    }

    public void suscribirObservador(TrofeoObserver observador) {
        this.Observadores.add(observador);
    }

    public void eliminarObservador(TrofeoObserver observador) {
        this.Observadores.remove(observador);
    }

    public void notifyObservers(Socio socio) {
        for (TrofeoObserver observer : Observadores) {
            observer.otorgarTrofeo(socio);
        }
    }

    // Recordar agregar socio en notifyObservers y reforzarRutina cuando se codee

    public void generarEntrenamientos() {

        for (int i = 0; i < 5; i++) {
            List<Ejercicio> ejerciciosSeleccionados = new ArrayList<>();

            if (this.objetivo instanceof BajarDePeso) {
                ejerciciosSeleccionados.add(new Ejercicio("Running", "Correr en cinta", 3, 4, 10.0, 5,
                        ExigenciaMuscular.BAJO, "url_video_running"));
                ejerciciosSeleccionados.add(new Ejercicio("Bicicleta", "Bicicleta fija", 3, 3, 15.0, 4,
                        ExigenciaMuscular.BAJO, "url_video_bicicleta"));
                ejerciciosSeleccionados.add(new Ejercicio("Elíptico", "Ejercicio en elíptico", 3, 3, 20.0, 5,
                        ExigenciaMuscular.BAJO, "url_video_eliptico"));
                ejerciciosSeleccionados.add(new Ejercicio("Salto de soga", "Saltos de soga", 3, 3, 5.0, 5,
                        ExigenciaMuscular.BAJO, "url_video_soga"));
                ejerciciosSeleccionados.add(new Ejercicio("Natación", "Nadar en piscina", 3, 3, 30.0, 4,
                        ExigenciaMuscular.BAJO, "url_video_natacion"));
            } else if (this.objetivo instanceof TonificarCuerpo) {
                ejerciciosSeleccionados.add(new Ejercicio("Press de banca", "Press de banca con barra", 4, 4, 20.0, 2,
                        ExigenciaMuscular.ALTO, "url_video_press_banca"));
                ejerciciosSeleccionados.add(new Ejercicio("Sentadillas", "Sentadillas con barra", 4, 4, 25.0, 3,
                        ExigenciaMuscular.ALTO, "url_video_sentadillas"));
                ejerciciosSeleccionados.add(new Ejercicio("Peso muerto", "Peso muerto con barra", 4, 4, 30.0, 2,
                        ExigenciaMuscular.ALTO, "url_video_peso_muerto"));
                ejerciciosSeleccionados.add(new Ejercicio("Dominadas", "Dominadas en barra", 4, 4, 15.0, 2,
                        ExigenciaMuscular.ALTO, "url_video_dominadas"));
                ejerciciosSeleccionados.add(new Ejercicio("Flexiones", "Flexiones de brazos", 4, 4, 10.0, 4,
                        ExigenciaMuscular.ALTO, "url_video_flexiones"));
            } else if (this.objetivo instanceof MantenerFigura) {
                ejerciciosSeleccionados.add(new Ejercicio("Yoga", "Sesión de yoga", 2, 3, 0.0, 2,
                        ExigenciaMuscular.MEDIO, "url_video_yoga"));
                ejerciciosSeleccionados.add(new Ejercicio("Pilates", "Clase de pilates", 2, 3, 0.0, 2,
                        ExigenciaMuscular.MEDIO, "url_video_pilates"));
                ejerciciosSeleccionados.add(new Ejercicio("Caminata", "Caminata ligera", 2, 3, 5.0, 3,
                        ExigenciaMuscular.MEDIO, "url_video_caminata"));
                ejerciciosSeleccionados.add(new Ejercicio("Ciclismo", "Ciclismo moderado", 2, 3, 10.0, 3,
                        ExigenciaMuscular.MEDIO, "url_video_ciclismo"));
                ejerciciosSeleccionados.add(new Ejercicio("Natación suave", "Nadar suavemente", 2, 3, 15.0, 3,
                        ExigenciaMuscular.MEDIO, "url_video_natacion_suave"));
            }

            Entrenamiento entrenamiento = new Entrenamiento();
            entrenamiento.setEjercicios(ejerciciosSeleccionados);
            this.entrenamientos.add(entrenamiento);
        }
    }
}
