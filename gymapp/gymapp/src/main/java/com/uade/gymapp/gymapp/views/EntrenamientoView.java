package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;
import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class EntrenamientoView {
    private Map<Ejercicio, JPanel> ejercicioItemsMap = new HashMap<>();
    private static RegistrarEjercicioView registrarEjercicioView;

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
                card.show(panelCard, "Rutina");
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
        //ejerciciosPanel.setPreferredSize(new Dimension(550, 500));
        ejerciciosPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        List<Ejercicio> ejercicios = entrenamiento.getEjercicios();
        for (Ejercicio ejercicio : ejercicios) {
            JPanel ejercicioItem = new JPanel();
            ejercicioItem.setLayout(new BoxLayout(ejercicioItem, BoxLayout.Y_AXIS));

            cargarEjercicioItem(ejercicioItemsMap, ejerciciosPanel, ejercicioItem, ejercicio, false, entrenamiento, dia);
        }

        JScrollPane scrollPane = new JScrollPane(ejerciciosPanel);
        //scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(550, 500));

        //centerPanel.add(infoPanel);
        centerPanel.add(scrollPane);
        entrenamientoPanel.add(centerPanel, BorderLayout.CENTER);

        // BOTONES
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        JButton reforzarBtn = new JButton("Reforzar entrenamiento");
        JButton finalizarBtn = new JButton("Finalizar entrenamiento");
        JButton comenzarBtn = new JButton("Comenzar entrenamiento");

        reforzarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reforzando entrenamiento...");
            }
        });
        comenzarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entrenamiento.setEstado(new EstadoEntrenamientoEnCurso());
                entrenamiento.setFecha(new Date());

                topPanel.removeAll();
                topPanel.revalidate();
                topPanel.repaint();
                topPanel.add(title);
                topPanel.add(infoPanel);

                ejerciciosPanel.removeAll();
                ejerciciosPanel.revalidate();
                ejerciciosPanel.repaint();
                for (Ejercicio ejercicio : ejercicios) {
                    JPanel ejercicioItem = new JPanel();
                    ejercicioItem.setLayout(new BoxLayout(ejercicioItem, BoxLayout.Y_AXIS));

                    cargarEjercicioItem(ejercicioItemsMap, ejerciciosPanel, ejercicioItem, ejercicio, true, entrenamiento, dia);
                }

                JScrollPane scrollPane = new JScrollPane(ejerciciosPanel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setPreferredSize(new Dimension(550, 500));
                centerPanel.removeAll();
                centerPanel.revalidate();
                centerPanel.repaint();
                centerPanel.add(scrollPane);

                buttonsPanel.removeAll();
                buttonsPanel.revalidate();
                buttonsPanel.repaint();
                buttonsPanel.add(finalizarBtn);
            }
        });
        finalizarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isEntrenamientoFinalizable(entrenamiento)) {
                    entrenamiento.setEstado(new EstadoEntrenamientoFinalizado());

                    topPanel.removeAll();
                    topPanel.revalidate();
                    topPanel.repaint();
                    topPanel.add(btnRegresar);
                    topPanel.add(title);
                    topPanel.add(infoPanel);

                    buttonsPanel.removeAll();
                    buttonsPanel.revalidate();
                    buttonsPanel.repaint();
                    buttonsPanel.add(new JLabel("Entrenamiento finalizado"));

                    Socio usuario = SocioController.getUsuarioActual();
                    usuario.getRutina().notifyObservers(usuario);
                    GymappApplication.crearPantallasPersonalizadas(card, panelCard);
                }
            }
        });
        buttonsPanel.add(reforzarBtn);
        buttonsPanel.add(comenzarBtn);
        entrenamientoPanel.add(buttonsPanel, BorderLayout.SOUTH);

        panelCard.add(entrenamientoPanel, "Entrenamiento " + dia);
    }

    private boolean isEntrenamientoFinalizable(Entrenamiento entrenamiento) {
        List<Ejercicio> ejercicios = entrenamiento.getEjercicios();
        boolean corresponde = true;

        for (Ejercicio ejercicio : ejercicios) {
            if (ejercicio.getEjercicioRealizado()==null) {
                corresponde = false;
            }
        }

        return corresponde;
    }

    public static void cargarEjercicioItem(Map<Ejercicio, JPanel> ejercicioItemsMap, JPanel ejerciciosPanel, JPanel ejercicioItem, Ejercicio ejercicio, boolean registrarBtn, Entrenamiento entrenamiento, int dia) {
        ejercicioItem.removeAll();
        ejercicioItem.revalidate();
        ejercicioItem.repaint();

        JPanel ejercicioTitlePanel = new JPanel(new FlowLayout());
        ejercicioTitlePanel.add(new JLabel("- nombre: "+ejercicio.getNombre()));
        JPanel ejercicioDescPanel = new JPanel(new FlowLayout());
        ejercicioDescPanel.add(new JLabel("- descripción: "+ejercicio.getDescripcion()));
        JPanel ejercicioSeriesPanel = new JPanel(new FlowLayout());
        ejercicioSeriesPanel.add(new JLabel("- series: "+ejercicio.getSeries()));
        JPanel ejercicioRepsPanel = new JPanel(new FlowLayout());
        ejercicioRepsPanel.add(new JLabel("- repeticiones: "+ejercicio.getRepeticiones()));
        JPanel ejercicioPesoPanel = new JPanel(new FlowLayout());
        ejercicioPesoPanel.add(new JLabel("- peso: "+ejercicio.getPeso()));
        JPanel ejercicioNivelAerobicoPanel = new JPanel(new FlowLayout());
        ejercicioNivelAerobicoPanel.add(new JLabel("- nivel aeróbico: "+ejercicio.getNivelAerobico()));
        JPanel ejercicioExigenciaPanel = new JPanel(new FlowLayout());
        ejercicioExigenciaPanel.add(new JLabel("- exigencia muscular: "+ejercicio.getExigenciaMuscular()));
        JPanel ejercicioTutorialPanel = new JPanel(new FlowLayout());
        ejercicioTutorialPanel.add(new JLabel("- video tutorial: "+ejercicio.getVideoUrl()));
        JButton btnRegistrarEjercicio = new JButton("Registrar ejercicio");
        btnRegistrarEjercicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEjercicioView = new RegistrarEjercicioView();
                registrarEjercicioView.crearPantalla(entrenamiento, ejercicio, dia, ejerciciosPanel, ejercicioItemsMap);
            }
        });
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

        if (registrarBtn) {
            ejercicioItem.add(btnRegistrarEjercicio);
        }

        ejercicioItem.add(blankLine);
        ejercicioItem.add(blankLine);
        ejercicioItem.add(blankLine);

        ejerciciosPanel.add(ejercicioItem);
        ejercicioItemsMap.put(ejercicio, ejercicioItem);
    }
}