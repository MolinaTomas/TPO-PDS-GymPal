package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.GymappApplication;
import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.*;
import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import org.springframework.http.ResponseEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingupView {
    private SocioController socioController;

    public void crearPantalla(SocioController socioController, CardLayout card, JPanel panelCard) {
        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(new BorderLayout());

        // Botón para regresar
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnRegresar = new JButton("Regresar");
        topPanel.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Inicio");
            }
        });

        // Título
        JLabel titleLabel = new JLabel("Registrarse", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel);
        signupPanel.add(topPanel, BorderLayout.NORTH);

        // Formulario de registro
        JPanel formPanel = new JPanel(new GridLayout(11, 2, 10, 10));
        JTextField nameField = new JTextField();
        JTextField apellidoField = new JTextField();
        JTextField sexoField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField alturaField = new JTextField();
        JTextField mailField = new JTextField();
        JTextField passwordField = new JTextField();
        JTextField pesoField = new JTextField();
        JTextField masaField = new JTextField();
        JTextField grasaField = new JTextField();

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
        formPanel.add(new JLabel("Peso:"));
        formPanel.add(pesoField);
        formPanel.add(new JLabel("Masa muscular:"));
        formPanel.add(masaField);
        formPanel.add(new JLabel("Porcentaje de grasa corporal:"));
        formPanel.add(grasaField);

        String[] objetivos = {"bajar de peso", "mantener figura", "tonificar cuerpo"};
        JComboBox<String> objetivoComboBox = new JComboBox<>(objetivos);
        formPanel.add(new JLabel("Objetivo: "));
        formPanel.add(objetivoComboBox);

        signupPanel.add(formPanel, BorderLayout.CENTER);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnRegistrar = new JButton("Registrar usuario");

        // Listeners para la navegación
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario(formPanel);
            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo SocioDTO con los datos del formulario
                SocioDTO socioDTO = new SocioDTO();
                socioDTO.setName(nameField.getText());
                socioDTO.setApellido(apellidoField.getText());
                socioDTO.setSexo(sexoField.getText());
                socioDTO.setEdad(Integer.parseInt(edadField.getText()));
                socioDTO.setAltura(Integer.parseInt(alturaField.getText()));
                socioDTO.setMail(mailField.getText());
                socioDTO.setPassword(passwordField.getText());

                String objetivoSeleccionado = (String) objetivoComboBox.getSelectedItem();
                Objetivo objetivo;
                if (objetivoSeleccionado.equals("bajar de peso")) {
                    objetivo = new BajarDePeso(Double.parseDouble(pesoField.getText()));
                } else if (objetivoSeleccionado.equals("mantener figura")) {
                    objetivo = new MantenerFigura();
                } else {
                    objetivo = new TonificarCuerpo();
                }

                socioDTO.setObjetivo(objetivo);

                double peso = Double.parseDouble(pesoField.getText());
                double masa = Double.parseDouble(masaField.getText());
                double grasa = Double.parseDouble(grasaField.getText());
                Medicion medicionInicial = new Medicion("2024-12-12", 50.0, 50.0, 50.0);
                medicionInicial.setPeso(peso);
                medicionInicial.setMasaMuscular(masa);
                medicionInicial.setPorcentajeGrasaCorporal(grasa);
                Socio usuarioActual = SocioController.getUsuarioActual();
                usuarioActual.getMediciones().add(medicionInicial);

                ResponseEntity<String> response = socioController.register(socioDTO);
                System.out.println(response.getBody());
                GymappApplication.crearPantallasPersonalizadas(card, panelCard);
                card.show(panelCard, "Dashboard");
            }
        });

        buttonPanel.add(btnLimpiar);
        buttonPanel.add(btnRegistrar);

        signupPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar al panelCard
        panelCard.add(signupPanel, "Signup");
    }

    private static void limpiarFormulario(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
    }
}