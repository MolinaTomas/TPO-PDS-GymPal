package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.model.Ejercicio;
import com.uade.gymapp.gymapp.model.Entrenamiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EntrenamientoView {
    public void crearPantalla(CardLayout card, JPanel panelCard, Entrenamiento entrenamiento, int dia) {
        JPanel entrenamientoPanel = new JPanel();
        entrenamientoPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Entrenamiento Día " + dia);
        title.setFont(new Font("Arial", Font.BOLD, 36));

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

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        JLabel subtitle = new JLabel("Información del entrenamiento");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(subtitle);
        infoPanel.add(new JLabel("- duración: " + entrenamiento.getDuracion()));
        infoPanel.add(new JLabel("- fecha: " + entrenamiento.getFecha()));
        JLabel subsubtitle = new JLabel("Ejercicios incluídos");
        subsubtitle.setFont(new Font("Arial", Font.PLAIN, 10));
        infoPanel.add(subtitle);

        topPanel.add(infoPanel);

        entrenamientoPanel.add(topPanel, BorderLayout.NORTH);

        // INFORMACIÓN DEL ENTRENAMIENTO

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel ejerciciosPanel = new JPanel();
        ejerciciosPanel.setLayout(new BoxLayout(ejerciciosPanel, BoxLayout.Y_AXIS));
        ejerciciosPanel.setPreferredSize(new Dimension(600, 400));
        ejerciciosPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        List<Ejercicio> ejercicios = entrenamiento.getEjercicios();
        System.out.println("LISTA DE EJERCICIOS");
        for (Ejercicio ejercicio : ejercicios) {
            System.out.println("EJERCICIO: "+ ejercicio);
            JPanel ejercicioItem = new JPanel();
            ejercicioItem.setLayout(new BoxLayout(ejercicioItem, BoxLayout.Y_AXIS));

            JPanel ejercicioTitlePanel = new JPanel(new FlowLayout());
            ejercicioTitlePanel.add(new JLabel("- nombre: "));
            ejercicioTitlePanel.add(new JLabel(ejercicio.getNombre()));
            JPanel ejercicioDescPanel = new JPanel(new FlowLayout());
            ejercicioDescPanel.add(new JLabel("- descripción: "));
            ejercicioDescPanel.add(new JLabel(ejercicio.getDescripcion()));
            JPanel ejercicioSeriesPanel = new JPanel(new FlowLayout());
            ejercicioSeriesPanel.add(new JLabel("- series: "));
            ejercicioSeriesPanel.add(new JLabel(String.valueOf(ejercicio.getSeries())));
            JPanel ejercicioRepsPanel = new JPanel(new FlowLayout());
            ejercicioRepsPanel.add(new JLabel("- repeticiones: "));
            ejercicioRepsPanel.add(new JLabel(String.valueOf(ejercicio.getRepeticiones())));
            JPanel ejercicioPesoPanel = new JPanel(new FlowLayout());
            ejercicioPesoPanel.add(new JLabel("- peso: "));
            ejercicioPesoPanel.add(new JLabel(String.valueOf(ejercicio.getPeso())));
            JPanel ejercicioNivelAerobicoPanel = new JPanel(new FlowLayout());
            ejercicioNivelAerobicoPanel.add(new JLabel("- nivel aeróbico: "));
            ejercicioNivelAerobicoPanel.add(new JLabel(String.valueOf(ejercicio.getNivelAerobico())));
            JPanel ejercicioExigenciaPanel = new JPanel(new FlowLayout());
            ejercicioExigenciaPanel.add(new JLabel("- exigencia muscular: "));
            ejercicioExigenciaPanel.add(new JLabel(String.valueOf(ejercicio.getExigenciaMuscular())));
            JPanel ejercicioTutorialPanel = new JPanel(new FlowLayout());
            ejercicioTutorialPanel.add(new JLabel("- video tutorial: "));
            ejercicioTutorialPanel.add(new JLabel(ejercicio.getVideoUrl()));
            JPanel blankLine = new JPanel();
            blankLine.add(new JLabel(" "));

            ejercicioItem.add(ejercicioTitlePanel);
            ejercicioItem.add(ejercicioDescPanel);
            ejercicioItem.add(ejercicioSeriesPanel);
            ejercicioItem.add(ejercicioRepsPanel);
            ejercicioItem.add(ejercicioPesoPanel);
            ejercicioItem.add(ejercicioNivelAerobicoPanel);
            ejercicioItem.add(ejercicioExigenciaPanel);
            ejercicioItem.add(ejercicioTutorialPanel);
            ejercicioItem.add(blankLine);
            ejercicioItem.add(blankLine);
            ejercicioItem.add(blankLine);

            ejerciciosPanel.add(ejercicioItem);
        }

        JScrollPane scrollPane = new JScrollPane(ejerciciosPanel);
        //scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        //centerPanel.add(infoPanel);
        centerPanel.add(scrollPane);
        entrenamientoPanel.add(centerPanel, BorderLayout.CENTER);

        // BOTONES
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        JButton reforzarBtn = new JButton("Reforzar entrenamiento");
        reforzarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reforzando entrenamiento...");
            }
        });
        JButton registrarBtn = new JButton("Registrar entrenamiento");
        registrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Registrar Entrenamiento");
            }
        });
        buttonsPanel.add(reforzarBtn);
        buttonsPanel.add(registrarBtn);
        entrenamientoPanel.add(centerPanel, BorderLayout.SOUTH);

        panelCard.add(entrenamientoPanel, "Entrenamiento " + dia);
    }
}