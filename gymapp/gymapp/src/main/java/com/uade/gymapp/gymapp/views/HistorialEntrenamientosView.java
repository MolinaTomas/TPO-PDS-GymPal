package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HistorialEntrenamientosView {
    public void crearPantalla(CardLayout card, JPanel panelCard) { // ES HISTORIAL DE EJERCICIOS, A EXTENDER
        JPanel historialEntrenamientosPanel = new JPanel();
        historialEntrenamientosPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Historial de Entrenamientos");
        JLabel subtitle = new JLabel("Entrenamientos y Ejercicios Realizados por el Usuario");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));

        // Botón para regresar
        JButton btnRegresar = new JButton("Regresar");
        topPanel.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Dashboard");
            }
        });

        topPanel.add(btnRegresar);
        topPanel.add(title);
        topPanel.add(subtitle);
        historialEntrenamientosPanel.add(topPanel, BorderLayout.NORTH);

        // información
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        Rutina rutinaActual = SocioController.getUsuarioActual().getRutina();
        List<Entrenamiento> entrenamientosActuales = rutinaActual.getEntrenamientos();

        for (Entrenamiento entrenamiento : entrenamientosActuales) {
            if (entrenamiento.getEstado() instanceof EstadoEntrenamientoFinalizado) {
                JPanel itemPanel = new JPanel();
                itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));

                JPanel line1 = new JPanel(); line1.add(new JLabel("Fecha: "+entrenamiento.getFecha())); itemPanel.add(line1);
                JPanel line2 = new JPanel(); line2.add(new JLabel("Duración: "+entrenamiento.getDuracion())); itemPanel.add(line2);
                JPanel line3 = new JPanel(); line3.add(new JLabel("Ejercicios Realizados ese Día:")); itemPanel.add(line3);

                JPanel ejerciciosRealizadosPanel = new JPanel();
                ejerciciosRealizadosPanel.setLayout(new BoxLayout(ejerciciosRealizadosPanel, BoxLayout.Y_AXIS));
                List<EjercicioRealizado> ejercicioRealizados = entrenamiento.getEjerciciosRealizados();
                for (EjercicioRealizado ejercicio : ejercicioRealizados) {
                    JPanel ejercicioItemPanel = new JPanel();
                    ejercicioItemPanel.setLayout(new BoxLayout(ejercicioItemPanel, BoxLayout.Y_AXIS));

                    String nombre = ejercicio.getEjercicio().getNombre();
                    String descripcion = ejercicio.getEjercicio().getDescripcion();
                    int nivelAerobico = ejercicio.getEjercicio().getNivelAerobico();
                    ExigenciaMuscular exigenciaMuscular = ejercicio.getEjercicio().getExigenciaMuscular();
                    String tutorial = ejercicio.getEjercicio().getVideoUrl();

                    int series = ejercicio.getEjercicio().getSeries();
                    int repeticiones = ejercicio.getEjercicio().getRepeticiones();
                    double peso = ejercicio.getEjercicio().getPeso();
                    int seriesHechas = ejercicio.getSeriesRealizadas();
                    int repeticionesHechas = ejercicio.getRepeticionesHechas();
                    double pesoLevantado = ejercicio.getPesoLevantado();

                    JPanel ejercicioLine1 = new JPanel(); ejercicioLine1.add(new JLabel("Nombre: "+nombre)); ejercicioItemPanel.add(ejercicioLine1);
                    JPanel ejercicioLine2 = new JPanel(); ejercicioLine2.add(new JLabel("Descripción: "+descripcion)); ejercicioItemPanel.add(ejercicioLine2);
                    JPanel ejercicioLine3 = new JPanel(); ejercicioLine3.add(new JLabel("Nivel Aeróbico: "+nivelAerobico)); ejercicioItemPanel.add(ejercicioLine3);
                    JPanel ejercicioLine4 = new JPanel(); ejercicioLine4.add(new JLabel("Exigencia muscular: "+exigenciaMuscular.name())); ejercicioItemPanel.add(ejercicioLine4);
                    JPanel ejercicioLine5 = new JPanel(); ejercicioLine5.add(new JLabel("Video Tutorial: "+tutorial)); ejercicioItemPanel.add(ejercicioLine5);
                    JPanel ejercicioLine6 = new JPanel(); ejercicioLine6.add(new JLabel("Series: "+series+" - Hechas: "+seriesHechas)); ejercicioItemPanel.add(ejercicioLine6);
                    JPanel ejercicioLine7 = new JPanel(); ejercicioLine7.add(new JLabel("Repeticiones: "+repeticiones+" - Hechas: "+repeticionesHechas)); ejercicioItemPanel.add(ejercicioLine7);
                    JPanel ejercicioLine8 = new JPanel(); ejercicioLine8.add(new JLabel("Peso:"+peso+" - Levantado: "+pesoLevantado)); ejercicioItemPanel.add(ejercicioLine8);

                    ejerciciosRealizadosPanel.add(ejercicioItemPanel);
                }
                JScrollPane ejerciciosRealizadosScrollPane = new JScrollPane(ejerciciosRealizadosPanel);
                ejerciciosRealizadosScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                ejerciciosRealizadosScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                itemPanel.add(ejerciciosRealizadosScrollPane);
                infoPanel.add(itemPanel);
            }

        }
        JScrollPane infoPanelScrollPane = new JScrollPane(infoPanel);
        infoPanelScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        infoPanelScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        historialEntrenamientosPanel.add(infoPanelScrollPane, BorderLayout.CENTER);

        // agregar al card
        panelCard.add(historialEntrenamientosPanel, "Historial de Entrenamientos");
    }
}