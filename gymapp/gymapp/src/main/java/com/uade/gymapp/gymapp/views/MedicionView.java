package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Medicion;
import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.model.dto.MedicionDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class MedicionView {
    public void crearPantalla(CardLayout card, JPanel panelCard, HistorialMedicionesView historialMedicionesView) {
        JPanel medicionPanel = new JPanel();
        medicionPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Mediciones");
        JLabel subtitle = new JLabel("Registrar nueva medición");
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
        JButton btnVerHistorialMediciones = new JButton("Ver Historial de Mediciones");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnRegistrar = new JButton("Registrar medición");

        // Listeners para la navegación
        btnVerHistorialMediciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Historial de Mediciones");
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario(formPanel);
            }
        });
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime fechaYhora = LocalDateTime.now();
                System.out.println(fechaYhora);
                double peso = Double.parseDouble(pesoField.getText());
                double masaMuscular = Double.parseDouble(masaMuscularField.getText());
                double grasaCorporal = Double.parseDouble(grasaCorporalField.getText());

                MedicionDTO medicionDTO = new MedicionDTO(fechaYhora, peso, grasaCorporal, masaMuscular);
                Socio usuarioActual = SocioController.getUsuarioActual();

                if (usuarioActual != null) {
                    Medicion medicion = new Medicion(medicionDTO.getFechaYhora(), medicionDTO.getPeso(),
                            medicionDTO.getPorcentajeGrasaCorporal(), medicionDTO.getMasaMuscular());
                    usuarioActual.getListaMediciones().add(medicion); // Agregar la medición a la lista del usuario

                    // Imprimir la medición en la consola
                    System.out.println("Nueva medición registrada: Peso: " + medicion.getPeso() +
                            ", Porcentaje de Grasa Corporal: " + medicion.getPorcentajeGrasaCorporal() +
                            ", Masa Muscular: " + medicion.getMasaMuscular());

                    JOptionPane.showMessageDialog(medicionPanel, "Medición registrada exitosamente");
                    usuarioActual.notifyObservers();
                    historialMedicionesView.crearPantalla(card, panelCard);
                    limpiarFormulario(formPanel);
                } else {
                    JOptionPane.showMessageDialog(medicionPanel, "No hay usuario logueado", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(btnVerHistorialMediciones);
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