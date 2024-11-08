package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;
import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import org.springframework.http.HttpStatus;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
    private GymappApplication app;
    private SocioController socioController;

    public LoginView(GymappApplication app, SocioController socioController) {
        super(); // Aseguramos que extienda JPanel
        this.app = app;
        this.socioController = socioController;
        this.setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("Iniciar sesión", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titleLabel, BorderLayout.NORTH);

        // Formulario
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();

        formPanel.add(userLabel);
        formPanel.add(userField);
        formPanel.add(passLabel);
        formPanel.add(passField);

        this.add(formPanel, BorderLayout.CENTER);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnIngresar = new JButton("Ingresar");

        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnIngresar);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Listeners para la navegación
        btnCancelar.addActionListener(e -> app.mostrarVista("InicioView"));
        btnIngresar.addActionListener(e -> {
            String usuario = userField.getText();
            String contraseña = new String(passField.getPassword());
            SocioDTO socioDTO = new SocioDTO();
            socioDTO.setMail(usuario);
            socioDTO.setPassword(contraseña);
            if (socioController.login(socioDTO).getStatusCode() == HttpStatus.OK) { // Verificar con SocioController
                app.mostrarVista("DashboardView");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}