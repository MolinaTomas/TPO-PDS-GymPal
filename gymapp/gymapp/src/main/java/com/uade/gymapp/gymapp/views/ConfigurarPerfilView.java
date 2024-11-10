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

public class ConfigurarPerfilView {
    public void crearPantalla(CardLayout card, JPanel panelCard) {
        JPanel configurarPerfilPanel = new JPanel();
        configurarPerfilPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Personalizar Perfil");
        JLabel subtitle = new JLabel("Cambiar Configuración del perfil");
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
        configurarPerfilPanel.add(topPanel, BorderLayout.NORTH);

        // información de la cuenta
        Socio socio = SocioController.getUsuarioActual();
        JPanel perfilInfoPanel = new JPanel();
        perfilInfoPanel.setLayout(new BoxLayout(perfilInfoPanel, BoxLayout.Y_AXIS));

        JPanel nombreItemPanel = new JPanel(new FlowLayout());
        nombreItemPanel.add(new JLabel("Nombre: "));
        JTextField nombreItemInput = new JTextField();
        nombreItemInput.setText(SocioController.getUsuarioActual().getName());
        nombreItemPanel.add(nombreItemInput);

        JPanel apellidoItemPanel = new JPanel(new FlowLayout());
        apellidoItemPanel.add(new JLabel("Apellido: "));
        JTextField apellidoItemInput = new JTextField();
        apellidoItemInput.setText(SocioController.getUsuarioActual().getApellido());
        apellidoItemPanel.add(apellidoItemInput);

        JPanel sexoItemPanel = new JPanel(new FlowLayout());
        sexoItemPanel.add(new JLabel("Sexo: "));
        JTextField sexoItemInput = new JTextField();
        sexoItemInput.setText(SocioController.getUsuarioActual().getSexo());
        sexoItemPanel.add(sexoItemInput);

        JPanel edadItemPanel = new JPanel(new FlowLayout());
        edadItemPanel.add(new JLabel("Edad: "));
        JTextField edadItemInput = new JTextField();
        edadItemInput.setText(String.valueOf(SocioController.getUsuarioActual().getEdad()));
        edadItemPanel.add(edadItemInput);

        JPanel alturaItemPanel = new JPanel(new FlowLayout());
        alturaItemPanel.add(new JLabel("Altura: "));
        JTextField alturaItemInput = new JTextField();
        alturaItemInput.setText(String.valueOf(SocioController.getUsuarioActual().getAltura()));
        alturaItemPanel.add(alturaItemInput);

        JPanel mailItemPanel = new JPanel(new FlowLayout());
        mailItemPanel.add(new JLabel("Mail: "));
        JTextField mailItemInput = new JTextField();
        mailItemInput.setText(SocioController.getUsuarioActual().getMail());
        mailItemPanel.add(mailItemInput);

        JPanel passwordItemPanel = new JPanel(new FlowLayout());
        passwordItemPanel.add(new JLabel("Mail: "));
        JTextField passwordItemInput = new JTextField();
        passwordItemInput.setText(SocioController.getUsuarioActual().getPassword());
        passwordItemPanel.add(mailItemInput);

        JPanel objetivoItemPanel = new JPanel(new FlowLayout());
        objetivoItemPanel.add(new JLabel("Objetivo: "));
        String[] objetivos = {"bajar de peso", "mantener figura", "tonificar cuerpo"};
        JComboBox<String> objetivoComboBox = new JComboBox<>(objetivos);
        Objetivo objetivoActual = SocioController.getUsuarioActual().getObjetivo();
        int index = 0;
        if (objetivoActual.getClass().getSimpleName().toString().equals("MantenerFigura")) { // BAD SMELLS
            index = 1;
        } else if (objetivoActual.getClass().getSimpleName().toString().equals("TonificarCuerpo")) { // BAD SMELLS
            index = 2;
        }
        objetivoComboBox.setSelectedIndex(index);
        objetivoItemPanel.add(objetivoComboBox);

        perfilInfoPanel.add(nombreItemPanel);
        perfilInfoPanel.add(apellidoItemPanel);
        perfilInfoPanel.add(sexoItemPanel);
        perfilInfoPanel.add(edadItemPanel);
        perfilInfoPanel.add(alturaItemPanel);
        perfilInfoPanel.add(passwordItemPanel);
        perfilInfoPanel.add(objetivoItemPanel);

        configurarPerfilPanel.add(perfilInfoPanel, BorderLayout.CENTER);

        // botones
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnGuardar = new JButton("Guardar");

        // Listeners para la navegación
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Perfil");
            }
        });
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo SocioDTO con los datos del formulario
                SocioDTO socioDTO = new SocioDTO();
                socioDTO.setName(nombreItemInput.getText());
                socioDTO.setApellido(apellidoItemInput.getText());
                socioDTO.setSexo(sexoItemInput.getText());
                socioDTO.setEdad(Integer.parseInt(edadItemInput.getText()));
                socioDTO.setAltura(Integer.parseInt(alturaItemInput.getText()));
                socioDTO.setMail(mailItemInput.getText());
                socioDTO.setPassword(passwordItemInput.getText());

                String objetivoSeleccionado = (String) objetivoComboBox.getSelectedItem();
                Objetivo objetivo;
                if (objetivoSeleccionado.equals("bajar de peso")) {
                    objetivo = new BajarDePeso();
                } else if (objetivoSeleccionado.equals("mantener figura")) {
                    objetivo = new MantenerFigura();
                } else {
                    objetivo = new TonificarCuerpo();
                }
                socioDTO.setObjetivo(objetivo);
                SocioController.updateUsuarioActual(socioDTO);

                GymappApplication.crearPantallasPersonalizadas(card, panelCard);
                card.show(panelCard, "Perfil");
            }
        });
        buttonsPanel.add(btnCancelar);
        buttonsPanel.add(btnGuardar);

        configurarPerfilPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // agregar al card
        panelCard.add(configurarPerfilPanel, "Personalizar Perfil");
    }
}