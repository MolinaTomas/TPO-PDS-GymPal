package com.uade.gymapp.gymapp.views;

import com.mysql.cj.log.Log;
import com.uade.gymapp.gymapp.GymappApplication;
import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import org.springframework.http.HttpStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LoginView {

    public void crearPantalla(SocioController socioController, CardLayout card, JPanel panelCard) {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        // Sección NORTH

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
        JLabel titleLabel = new JLabel("Iniciar sesión", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel);
        loginPanel.add(topPanel, BorderLayout.NORTH);

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

        loginPanel.add(formPanel, BorderLayout.CENTER);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnIngresar = new JButton("Ingresar");

        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnIngresar);

        // Listeners para la navegación
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Inicio");
            }
        });
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String contraseña = new String(passField.getPassword());
                SocioDTO socioDTO = new SocioDTO();
                socioDTO.setMail(usuario);
                socioDTO.setPassword(contraseña);
                if (socioController.login(socioDTO).getStatusCode() == HttpStatus.OK) { // Verificar con SocioController
                    Socio socio = obtenerSocio(usuario);
                    SocioController.setUsuarioActual(socio);
                    GymappApplication.crearPantallasPersonalizadas(card, panelCard);
                    card.show(panelCard, "Dashboard");
                } else {
                    JOptionPane.showMessageDialog(loginPanel, "Usuario o contraseña incorrectos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar al panelCard
        panelCard.add(loginPanel, "Login");
    }

    private Socio obtenerSocio(String mail) {
        SocioController socioController = GymappApplication.getSocioController();
        List<Socio> usuarios = socioController.getUsuariosRegistrados();

        for (Socio usuario : usuarios) {
            if (usuario.getMail().equals(mail)) {
                return usuario;
            }
        }
        return null;
    }
}