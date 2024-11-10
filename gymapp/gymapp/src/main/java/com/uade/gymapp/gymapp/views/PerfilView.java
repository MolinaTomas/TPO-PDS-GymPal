package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilView {
    public void crearPantalla(CardLayout card, JPanel panelCard) {
        JPanel perfilPanel = new JPanel();
        perfilPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Perfil");
        JLabel subtitle = new JLabel("Información del perfil");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));

        // Botón para regresar
        JButton btnRegresar = new JButton("Regresar");
        topPanel.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Dashboard");
            }
        });

        topPanel.add(btnRegresar);
        topPanel.add(title);
        topPanel.add(subtitle);
        perfilPanel.add(topPanel, BorderLayout.NORTH);

        // información de la cuenta
        Socio socio = SocioController.getUsuarioActual();
        JPanel perfilInfoPanel = new JPanel();
        perfilInfoPanel.setLayout(new BoxLayout(perfilInfoPanel, BoxLayout.Y_AXIS));

        JPanel nombreItemPanel = new JPanel(new FlowLayout());
        nombreItemPanel.add(new JLabel("Nombre: ")); nombreItemPanel.add(new JLabel(socio.getName()));
        JPanel apellidoItemPanel = new JPanel(new FlowLayout());
        apellidoItemPanel.add(new JLabel("Apellido: ")); apellidoItemPanel.add(new JLabel(socio.getApellido()));
        JPanel sexoItemPanel = new JPanel(new FlowLayout());
        sexoItemPanel.add(new JLabel("Sexo: ")); sexoItemPanel.add(new JLabel(socio.getSexo()));
        JPanel edadItemPanel = new JPanel(new FlowLayout());
        edadItemPanel.add(new JLabel("Edad: ")); edadItemPanel.add(new JLabel(String.valueOf(socio.getEdad())));
        JPanel alturaItemPanel = new JPanel(new FlowLayout());
        alturaItemPanel.add(new JLabel("Altura: ")); alturaItemPanel.add(new JLabel(String.valueOf(socio.getAltura())));
        JPanel mailItemPanel = new JPanel(new FlowLayout());
        mailItemPanel.add(new JLabel("Mail: ")); mailItemPanel.add(new JLabel(socio.getMail()));
        JPanel objetivoItemPanel = new JPanel(new FlowLayout());
        objetivoItemPanel.add(new JLabel("Objetivo: ")); objetivoItemPanel.add(new JLabel(socio.getObjetivo().getClass().getSimpleName().toString())); // BAD SMELLS

        perfilInfoPanel.add(nombreItemPanel);
        perfilInfoPanel.add(apellidoItemPanel);
        perfilInfoPanel.add(sexoItemPanel);
        perfilInfoPanel.add(edadItemPanel);
        perfilInfoPanel.add(alturaItemPanel);
        perfilInfoPanel.add(mailItemPanel);
        perfilInfoPanel.add(objetivoItemPanel);

        perfilPanel.add(perfilInfoPanel, BorderLayout.CENTER);

        // botones
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton btnPersonalizar = new JButton("Personalizar Perfil");

        // Listeners para la navegación
        btnPersonalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Personalizar Perfil");
            }
        });
        buttonsPanel.add(btnPersonalizar);

        perfilPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // agregar al card
        panelCard.add(perfilPanel, "Perfil");
    }
}