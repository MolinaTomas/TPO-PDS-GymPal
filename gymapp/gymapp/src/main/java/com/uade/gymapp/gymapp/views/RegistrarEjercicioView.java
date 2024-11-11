package com.uade.gymapp.gymapp.views;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Ejercicio;
import com.uade.gymapp.gymapp.model.EjercicioRealizado;
import com.uade.gymapp.gymapp.model.Entrenamiento;
import com.uade.gymapp.gymapp.model.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import static com.uade.gymapp.gymapp.views.EntrenamientoView.cargarEjercicioItem;

public class RegistrarEjercicioView {
    EntrenamientoView entrenamientoView;

    public void crearPantalla(Entrenamiento entrenamiento, Ejercicio ejercicio, int dia, JPanel ejerciciosPanel, Map<Ejercicio, JPanel> ejercicioItemsMap) {
        JFrame registrarEjercicioFrame = new JFrame("Registrar Ejercicio");
        registrarEjercicioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registrarEjercicioFrame.setSize(600, 700);
        registrarEjercicioFrame.setLocationRelativeTo(null);
        JPanel registrarEjercicioPanel = new JPanel();
        registrarEjercicioPanel.setLayout(new BorderLayout());

        // título
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Registrar Ejercicio");
        title.setFont(new Font("Arial", Font.BOLD, 36));

        // Botón para regresar
        JButton btnRegresar = new JButton("Regresar");
        topPanel.add(btnRegresar);
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEjercicioFrame.setVisible(false);
                //card.show(panelCard, "Dashboard");
            }
        });

        topPanel.add(btnRegresar);
        topPanel.add(title);

        registrarEjercicioPanel.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(new JLabel("Nombre: "+ejercicio.getNombre()));
        centerPanel.add(new JLabel("Descripción: "+ejercicio.getDescripcion()));
        centerPanel.add(new JLabel("Series: "+ejercicio.getSeries()));
        centerPanel.add(new JLabel("Repeticiones: "+ejercicio.getRepeticiones()));
        centerPanel.add(new JLabel("Peso: "+ejercicio.getPeso()));

        JPanel seriesInputPanel = new JPanel();
        seriesInputPanel.setLayout(new BoxLayout(seriesInputPanel, BoxLayout.Y_AXIS));
        seriesInputPanel.add(new JLabel("Series Hechas: "));
        JTextField seriesInput = new JTextField();
        seriesInputPanel.add(seriesInput);

        JPanel repeticionesInputPanel = new JPanel();
        repeticionesInputPanel.setLayout(new BoxLayout(repeticionesInputPanel, BoxLayout.Y_AXIS));
        repeticionesInputPanel.add(new JLabel("Repeticiones Hechas: "));
        JTextField repeticionesInput = new JTextField();
        repeticionesInputPanel.add(repeticionesInput);

        JPanel pesoInputPanel = new JPanel();
        pesoInputPanel.setLayout(new BoxLayout(pesoInputPanel, BoxLayout.Y_AXIS));
        pesoInputPanel.add(new JLabel("Peso Levantado (en KG): "));
        JTextField pesoInput = new JTextField();
        pesoInputPanel.add(pesoInput);

        centerPanel.add(seriesInputPanel);
        centerPanel.add(repeticionesInputPanel);
        centerPanel.add(pesoInputPanel);

        centerPanel.setPreferredSize(new Dimension(400, 500));

        registrarEjercicioPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout());

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEjercicioFrame.setVisible(false);
                //card.show(panelCard, "Entrenamiento "+dia);
            }
        });
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Socio usuairo = SocioController.getUsuarioActual();
                List<EjercicioRealizado> realizados = entrenamiento.getEjerciciosRealizados();

                LocalDateTime fecha = entrenamiento.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                int seriesHechas = Integer.parseInt(seriesInput.getText());
                int repeticionesHechas = Integer.parseInt(repeticionesInput.getText());
                double pesoLevantado = Double.parseDouble(pesoInput.getText());

                EjercicioRealizado nuevoEjercicioRealizado = new EjercicioRealizado(entrenamiento, ejercicio, fecha, seriesHechas, repeticionesHechas, pesoLevantado);
                ejercicio.setEjercicioRealizado(nuevoEjercicioRealizado);
                realizados.add(nuevoEjercicioRealizado);

                JPanel ejercicioItem = ejercicioItemsMap.get(ejercicio);
                cargarEjercicioItem(ejercicioItemsMap, ejerciciosPanel, ejercicioItem, ejercicio, false, entrenamiento, dia);
                registrarEjercicioFrame.setVisible(false);
            }
        });

        buttonsPanel.add(btnCancelar);
        buttonsPanel.add(btnRegistrar);

        registrarEjercicioPanel.add(buttonsPanel, BorderLayout.SOUTH);

        registrarEjercicioFrame.setLayout(new BorderLayout());
        registrarEjercicioFrame.add(registrarEjercicioPanel, BorderLayout.CENTER);
        registrarEjercicioFrame.setVisible(true);
        //panelCard.add(registrarEjercicioPanel, "Registrar Ejercicio");
    }
}