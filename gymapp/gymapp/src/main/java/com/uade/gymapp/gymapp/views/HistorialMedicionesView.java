package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Medicion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HistorialMedicionesView {
    public void crearPantalla(CardLayout card, JPanel panelCard) {
        JPanel medicionPanel = new JPanel();
        medicionPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Mediciones");
        JLabel subtitle = new JLabel("Historial de Mediciones del Usuario");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));

        // Botón para regresar
        JButton btnRegresar = new JButton("Regresar");
        topPanel.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.show(panelCard, "Mediciones");
            }
        });

        topPanel.add(btnRegresar);
        topPanel.add(title);
        topPanel.add(subtitle);
        medicionPanel.add(topPanel, BorderLayout.NORTH);

        // información
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        List<Medicion> mediciones = SocioController.getUsuarioActual().getMediciones();

        for (Medicion medicion : mediciones) {
            JPanel item = new JPanel(new FlowLayout());

            JPanel itemFecha = new JPanel(new FlowLayout());
            itemFecha.add(new JLabel("Fecha:"));
            itemFecha.add(new JLabel(medicion.getFechaYhora().toString()));

            JPanel itemPeso = new JPanel(new FlowLayout());
            itemPeso.add(new JLabel("Peso en KG:"));
            itemFecha.add(new JLabel(String.valueOf(medicion.getPeso())));

            JPanel itemMasa= new JPanel(new FlowLayout());
            itemMasa.add(new JLabel("Masa muscular:"));
            itemMasa.add(new JLabel(String.valueOf(medicion.getMasaMuscular())));

            JPanel itemGrasa = new JPanel(new FlowLayout());
            itemGrasa.add(new JLabel("Grasa corporal:"));
            itemGrasa.add(new JLabel(String.valueOf(medicion.getPorcentajeGrasaCorporal())));

            item.add(itemFecha);
            item.add(itemPeso);
            item.add(itemMasa);
            item.add(itemGrasa);

            infoPanel.add(item);

        }

        medicionPanel.add(infoPanel, BorderLayout.CENTER);

        // agregar al card
        panelCard.add(medicionPanel, "Historial de Mediciones");
    }
}