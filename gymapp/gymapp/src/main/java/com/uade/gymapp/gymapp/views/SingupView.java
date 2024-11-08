package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;
import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import org.springframework.http.ResponseEntity;

import javax.swing.*;
import java.awt.*;

public class SingupView extends JPanel {
    private GymappApplication app;
    private SocioController socioController;

    public SingupView(GymappApplication app, SocioController socioController) {
        super(); // Aseguramos que extienda JPanel
        this.app = app;
        this.socioController = socioController; // Inicializamos el controlador
        this.setLayout(new BorderLayout());

        // Título
        JLabel titleLabel = new JLabel("Registrarse", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(titleLabel, BorderLayout.NORTH);

        // Formulario de registro
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        JTextField nameField = new JTextField();
        JTextField apellidoField = new JTextField();
        JTextField sexoField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField alturaField = new JTextField();
        JTextField mailField = new JTextField();
        JTextField passwordField = new JTextField();

        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Apellido:"));
        formPanel.add(apellidoField);
        formPanel.add(new JLabel("Sexo:"));
        formPanel.add(sexoField);
        formPanel.add(new JLabel("Edad:"));
        formPanel.add(edadField);
        formPanel.add(new JLabel("Altura:"));
        formPanel.add(alturaField);
        formPanel.add(new JLabel("Mail:"));
        formPanel.add(mailField);
        formPanel.add(new JLabel("Contraseña:"));
        formPanel.add(passwordField);

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
        btnRegistrar.addActionListener(e -> {
            // Crear un nuevo SocioDTO con los datos del formulario
            SocioDTO socioDTO = new SocioDTO();
            socioDTO.setName(nameField.getText());
            socioDTO.setApellido(apellidoField.getText());
            socioDTO.setSexo(sexoField.getText());
            socioDTO.setEdad(Integer.parseInt(edadField.getText()));
            socioDTO.setAltura(Integer.parseInt(alturaField.getText()));
            socioDTO.setMail(mailField.getText());
            socioDTO.setPassword(passwordField.getText());
            ResponseEntity<String> response = socioController.register(socioDTO);
            System.out.println(response.getBody());
            app.mostrarVista("DashboardView"); // Cambiar a la vista del dashboard
        });
    }

    private void limpiarFormulario(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
    }
}