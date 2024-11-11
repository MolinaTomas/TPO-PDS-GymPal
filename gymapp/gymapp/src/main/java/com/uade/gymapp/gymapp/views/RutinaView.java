package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;
import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Entrenamiento;
import com.uade.gymapp.gymapp.model.Objetivo;
import com.uade.gymapp.gymapp.model.Rutina;
import com.uade.gymapp.gymapp.model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RutinaView {
    public void crearPantalla(CardLayout card, JPanel panelCard, EntrenamientoView entrenamientoView) {
        JPanel rutinaPanel = new JPanel();
        rutinaPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Rutina");
        title.setFont(new Font("Arial", Font.BOLD, 36));

        // Obtener el objetivo actual
        Socio usuarioActual = SocioController.getUsuarioActual();
        if (usuarioActual == null) {
            System.out.println("Usuario actual es null");
            return;
        }

        Objetivo objetivoActual = usuarioActual.getObjetivo();
        String objetivoSeleccionado = "---------";
        if (objetivoActual != null) {
            if (objetivoActual.getClass().getSimpleName().equals("BajarDePeso")) {
                objetivoSeleccionado = "Bajar de Peso";
            } else if (objetivoActual.getClass().getSimpleName().equals("MantenerFigura")) {
                objetivoSeleccionado = "Mantener Figura";
            } else if (objetivoActual.getClass().getSimpleName().equals("TonificarCuerpo")) {
                objetivoSeleccionado = "Tonificar Cuerpo";
            }
        }
        JLabel subtitle = new JLabel("Objetivo: " + objetivoSeleccionado);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));

        // Botón para regresar
        JButton btnRegresar = new JButton("Regresar");
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

        // Panel de calendario
        JPanel calendarPanel = new JPanel(new GridLayout(4, 5));
        Rutina rutina = usuarioActual.getRutina();

        JButton reforzarBtn = new JButton("Reforzar entrenamiento");

        reforzarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rutina.refuerzoRutina();
                GymappApplication.crearPantallasPersonalizadas(card, panelCard);
            }
        });

        topPanel.add(reforzarBtn);

        if (rutina == null) {
            System.out.println("Rutina es null");
            calendarPanel.add(new JLabel("No hay rutina disponible"));
        } else {

            List<Entrenamiento> entrenamientos = rutina.getEntrenamientos();
            if (entrenamientos == null || entrenamientos.isEmpty()) {
                System.out.println("No hay entrenamientos disponibles");
                calendarPanel.add(new JLabel("No hay entrenamientos disponibles"));
            } else {
                int i = 1;
                for (Entrenamiento entrenamiento : entrenamientos) {
                    JButton dia = new JButton("Día " + i);
                    final int y = i;
                    entrenamientoView.crearPantalla(card, panelCard, entrenamiento, i);
                    dia.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            card.show(panelCard, "Entrenamiento " + y);
                        }
                    });
                    calendarPanel.add(dia);
                    i++;
                }
            }
        }

        rutinaPanel.add(calendarPanel, BorderLayout.CENTER);
        panelCard.add(rutinaPanel, "Rutina");
    }
}