package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;
import com.uade.gymapp.gymapp.controller.SocioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioView {
    private SocioController socioController;

    public void crearPantalla(CardLayout card, JPanel panelCard) {
        JPanel inicioPanel = new JPanel();
        inicioPanel.setLayout(new BorderLayout());

        this.socioController = new SocioController();

        // Panel para el título y subtítulo
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel("GymPal", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        JLabel subtitleLabel = new JLabel("¡Bienvenido/a a GymPal!", JLabel.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        titlePanel.add(titleLabel);
        titlePanel.add(subtitleLabel);
        inicioPanel.add(titlePanel, BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        JButton btnRegistrarse = new JButton("Registrarse");
        buttonPanel.add(btnIniciarSesion);
        buttonPanel.add(btnRegistrarse);
        inicioPanel.add(buttonPanel, BorderLayout.CENTER);

        // Listeners para la navegación
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Login");
            }
        });
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Signup");
            }
        });

        // Agregar al panelCard
        panelCard.add(inicioPanel, "Inicio");
    }
}