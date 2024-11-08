package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardView extends JPanel {
    private GymappApplication app; // Referencia a la clase principal para cambiar vistas

    public DashboardView(GymappApplication app) {
        super(); // Aseguramos que extienda JPanel
        this.app = app;
        this.setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("Dashboard", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titleLabel, BorderLayout.NORTH);

        // Panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));

        JButton btnVerMediciones = new JButton("Ver Mediciones");
        JButton btnVerRutina = new JButton("Ver Rutina");
        JButton btnVerHistorial = new JButton("Ver Historial de Entrenamientos");
        JButton btnVerTrofeos = new JButton("Ver Trofeos");
        JButton btnVerPerfil = new JButton("Ver Perfil");

        buttonPanel.add(btnVerMediciones);
        buttonPanel.add(btnVerRutina);
        buttonPanel.add(btnVerHistorial);
        buttonPanel.add(btnVerTrofeos);
        buttonPanel.add(btnVerPerfil);

        this.add(buttonPanel, BorderLayout.CENTER);

        // Botón de cierre de sesión
        JButton btnCerrarSesion = new JButton("Cerrar sesión");
        this.add(btnCerrarSesion, BorderLayout.SOUTH);

        // Listeners para la navegación
        btnVerMediciones.addActionListener(e -> app.mostrarVista("MedicionView"));
        btnVerRutina.addActionListener(e -> app.mostrarVista("RutinaView"));
        btnVerHistorial.addActionListener(e -> app.mostrarVista("HistorialEntrenamientosView"));
        btnVerTrofeos.addActionListener(e -> app.mostrarVista("TrofeosView"));
        btnVerPerfil.addActionListener(e -> app.mostrarVista("PerfilView"));

        btnCerrarSesion.addActionListener(e -> app.mostrarVista("InicioView"));
    }
}