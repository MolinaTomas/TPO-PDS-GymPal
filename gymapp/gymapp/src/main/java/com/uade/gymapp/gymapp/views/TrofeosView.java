package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Trofeo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TrofeosView {
    public void crearPantalla(CardLayout card, JPanel panelCard) {
        JPanel trofeosPanel = new JPanel();
        trofeosPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Trofeos");
        JLabel subtitle = new JLabel("Lista de Trofeos Obtenidos por el Usuario");
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
        trofeosPanel.add(topPanel, BorderLayout.NORTH);

        // información
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        List<Trofeo> trofeos = SocioController.getUsuarioActual().getTrofeos();
        if (trofeos != null) {
            for (Trofeo trofeo : trofeos) {
                JPanel item = new JPanel(new FlowLayout());

                JPanel itemFecha = new JPanel(new FlowLayout());
                itemFecha.add(new JLabel("Fecha:"));
                itemFecha.add(new JLabel(trofeo.getFechaYhora().toString()));
                JPanel itemNombre = new JPanel(new FlowLayout());
                itemNombre.add(new JLabel("Fecha:"));
                itemNombre.add(new JLabel(trofeo.getNombre()));
                item.add(itemFecha);
                item.add(itemNombre);

                infoPanel.add(item);
            }
        }

        trofeosPanel.add(infoPanel, BorderLayout.CENTER);

        // agregar al card
        panelCard.add(trofeosPanel, "Trofeos");
    }
}