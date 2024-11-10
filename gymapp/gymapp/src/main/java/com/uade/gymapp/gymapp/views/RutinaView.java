package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Entrenamiento;
import com.uade.gymapp.gymapp.model.Objetivo;
import com.uade.gymapp.gymapp.model.Rutina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RutinaView {
    public void crearPantalla(CardLayout card, JPanel panelCard, EntrenamientoView entrenamientoView) {
        JPanel rutinaPanel = new JPanel();
        rutinaPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Rutina");

        Objetivo objetivoActual = SocioController.getUsuarioActual().getObjetivo();
        String objetivoSeleccionado = "---------";
        if (objetivoActual.getClass().getSimpleName().toString().equals("BajarDePeso")) {
            objetivoSeleccionado = "Bajar de Peso";
        } else if (objetivoActual.getClass().getSimpleName().toString().equals("MantenerFigura")) {
            objetivoSeleccionado = "Mantener Figura";
        } else if (objetivoActual.getClass().getSimpleName().toString().equals("TonificarCuerpo")) {
            objetivoSeleccionado = "Tonificar Cuerpo";
        }

        JLabel subtitle = new JLabel("Objetivo: " + objetivoSeleccionado);
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
        rutinaPanel.add(topPanel, BorderLayout.NORTH);

        JPanel calendarPanel = new JPanel(new GridLayout(4, 5));
        Rutina rutina = SocioController.getUsuarioActual().getRutina();
        List<Entrenamiento> entrenamientos = rutina!=null ? rutina.getEntrenamientos() : null;
        int i = 1;

        if (entrenamientos!=null) {
            for (Entrenamiento entrenamiento : entrenamientos) {
                JButton dia = new JButton("Día " + String.valueOf(i));
                final int y = i;
                entrenamientoView.crearPantalla(card, panelCard, entrenamiento, i);
                dia.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        card.show(panelCard, "Entrenamiento "+y);
                    }
                });
                i++;
            }
        }



        rutinaPanel.add(calendarPanel, BorderLayout.CENTER);

        panelCard.add(rutinaPanel, "Rutina");
    }
}