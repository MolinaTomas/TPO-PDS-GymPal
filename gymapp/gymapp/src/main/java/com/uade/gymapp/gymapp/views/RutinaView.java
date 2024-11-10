package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Entrenamiento;

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
        JLabel subtitle = new JLabel("Objetivo ---------");
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
        List<Entrenamiento> entrenamientos = SocioController.getUsuarioActual().getRutina().getEntrenamientos();
        int i = 1;

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

//        for (int i=1;i<=20;i++) {
//            JButton dia = new JButton("Día " + String.valueOf(i));
//            dia.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    entrenamientoView.crearPantalla(card, panelCard);
//                    card.show(panelCard, "Entrenamiento");
//                }
//            });
//            calendarPanel.add(dia);
//        }

        rutinaPanel.add(calendarPanel, BorderLayout.CENTER);

        panelCard.add(rutinaPanel, "Rutina");
    }
}