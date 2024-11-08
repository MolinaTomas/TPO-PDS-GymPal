package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;

import javax.swing.*;
import java.awt.*;

public class SingupView extends JPanel {
    private GymappApplication app;

    public SingupView(GymappApplication app) {
        super(); // Aseguramos que extienda JPanel
        this.app = app;
        this.setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("Registrarse", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titleLabel, BorderLayout.NORTH);

        // Formulario de registro
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Apellido:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Sexo:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Edad:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Altura:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Mail:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Objetivo:"));
        JComboBox<String> objetivoCombo = new JComboBox<>(new String[]{"Bajar de peso", "Mantener figura", "Tonificar cuerpo"});
        formPanel.add(objetivoCombo);

        this.add(formPanel, BorderLayout.CENTER);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnRegistrar = new JButton("Registrar usuario");

        buttonPanel.add(btnLimpiar);
        buttonPanel.add(btnRegistrar);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Listeners para la navegación
        btnLimpiar.addActionListener(e -> limpiarFormulario(formPanel));
        btnRegistrar.addActionListener(e -> app.mostrarVista("DashboardView"));
    }

    private void limpiarFormulario(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
    }
}