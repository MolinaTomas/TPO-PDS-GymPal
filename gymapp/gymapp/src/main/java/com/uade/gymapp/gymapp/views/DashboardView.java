package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardView extends JPanel {
    private static InicioView inicioView;
    private static MedicionView medicionView;
    private static RutinaView rutinaView;
    private static HistorialEntrenamientosView historialEntrenamientosView;
    private static TrofeosView trofeosView;
    private static PerfilView perfilView;

    public static void crearPantalla(SocioController socioController, CardLayout card, JPanel panelCard) {
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        inicioView = new InicioView();
        medicionView = new MedicionView();
        rutinaView = new RutinaView();
        historialEntrenamientosView = new HistorialEntrenamientosView();
        trofeosView = new TrofeosView();
        perfilView = new PerfilView();

        // Título
        JLabel titleLabel = new JLabel("Dashboard", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));

        JButton btnVerMediciones = new JButton("Ver Mediciones");
        JButton btnVerRutina = new JButton("Ver Rutina");
        JButton btnVerHistorial = new JButton("Ver Historial de Entrenamientos");
        JButton btnVerTrofeos = new JButton("Ver Trofeos");
        JButton btnVerPerfil = new JButton("Ver Perfil");

        // Listeners para la navegación
        btnVerMediciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicionView.crearPantalla(card, panelCard);
                card.show(panelCard, "Inicio");
            }
        });
        btnVerRutina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rutinaView.crearPantalla(card, panelCard);
                card.show(panelCard, "Inicio");
            }
        });
        btnVerHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historialEntrenamientosView.crearPantalla(card, panelCard);
                card.show(panelCard, "Inicio");
            }
        });
        btnVerTrofeos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trofeosView.crearPantalla(card, panelCard);
                card.show(panelCard, "Inicio");
            }
        });
        btnVerPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perfilView.crearPantalla(card, panelCard);
                card.show(panelCard, "Inicio");
            }
        });

        buttonPanel.add(btnVerMediciones);
        buttonPanel.add(btnVerRutina);
        buttonPanel.add(btnVerHistorial);
        buttonPanel.add(btnVerTrofeos);
        buttonPanel.add(btnVerPerfil);

        dashboardPanel.add(buttonPanel, BorderLayout.CENTER);

        // Botón de cierre de sesión
        JButton btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicioView.crearPantalla(card, panelCard);
                card.show(panelCard, "Inicio");
            }
        });
        dashboardPanel.add(btnCerrarSesion, BorderLayout.SOUTH);
    }
}