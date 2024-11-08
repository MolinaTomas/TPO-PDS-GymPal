package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioView extends JPanel {
    private GymappApplication app;

    public InicioView(GymappApplication app) {
        super(); // Extiende JPanel
        this.app = app;
        this.setLayout(new BorderLayout());

        // Panel para el título y subtítulo
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel("GymPal", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        JLabel subtitleLabel = new JLabel("¡Bienvenido/a a GymPal!", JLabel.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        titlePanel.add(titleLabel);
        titlePanel.add(subtitleLabel);
        this.add(titlePanel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        JButton btnRegistrarse = new JButton("Registrarse");

        buttonPanel.add(btnIniciarSesion);
        buttonPanel.add(btnRegistrarse);

        this.add(buttonPanel, BorderLayout.CENTER);

        // Listeners para la navegación
        btnIniciarSesion.addActionListener(e -> app.mostrarVista("LoginView"));
        btnRegistrarse.addActionListener(e -> app.mostrarVista("SignupView"));
    }
}