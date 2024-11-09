package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import org.hibernate.boot.model.internal.JPAXMLOverriddenAnnotationReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardView extends JPanel {

    public void crearPantalla(SocioController socioController, CardLayout card, JPanel panelCard) {
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

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
                card.show(panelCard, "Mediciones");
            }
        });
        btnVerRutina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Inicio");
            }
        });
        btnVerHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Inicio");
            }
        });
        btnVerTrofeos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Inicio");
            }
        });
        btnVerPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                card.show(panelCard, "Inicio");
            }
        });
        dashboardPanel.add(btnCerrarSesion, BorderLayout.SOUTH);

        panelCard.add(dashboardPanel, "Dashboard");
    }
}