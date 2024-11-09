package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.model.dto.SocioDTO;
import org.springframework.http.ResponseEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicionView {
    public void crearPantalla(CardLayout card, JPanel panelCard) {
        JPanel medicionPanel = new JPanel();
        medicionPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Mediciones");
        JLabel subtitle = new JLabel("Registrar nueva medición");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
        topPanel.add(title);
        topPanel.add(subtitle);
        medicionPanel.add(topPanel, BorderLayout.NORTH);

        // formulario
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 2));
        JTextField pesoField = new JTextField();
        JTextField masaMuscularField = new JTextField();
        JTextField grasaCorporalField = new JTextField();

        formPanel.add(new JLabel("Peso en KG:"));
        formPanel.add(pesoField);
        formPanel.add(new JLabel("Porcentaje de masa muscular:"));
        formPanel.add(masaMuscularField);
        formPanel.add(new JLabel("Porcentaje de grasa corporal:"));
        formPanel.add(grasaCorporalField);
        medicionPanel.add(formPanel, BorderLayout.CENTER);

        // botones
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnRegistrar = new JButton("Registrar medición");

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
                limpiarFormulario(formPanel);
            }
        });
        buttonPanel.add(btnLimpiar);
        buttonPanel.add(btnRegistrar);

        medicionPanel.add(buttonPanel, BorderLayout.SOUTH);

        // agregar al card
        panelCard.add(medicionPanel, "Mediciones");
    }

    private static void limpiarFormulario(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JTextField) {
                ((JTextField) comp).setText("");
            }
        }
    }
}