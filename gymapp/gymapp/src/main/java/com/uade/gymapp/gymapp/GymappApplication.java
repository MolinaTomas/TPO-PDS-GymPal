package com.uade.gymapp.gymapp;

import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.views.DashboardView;
import com.uade.gymapp.gymapp.views.InicioView;
import com.uade.gymapp.gymapp.views.LoginView;
import com.uade.gymapp.gymapp.views.SingupView;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class GymappApplication {
	private static InicioView inicioView;

	public static void main(String[] args) {
		//GymappApplication app = new GymappApplication();
		//app.setVisible(true);

		inicioView = new InicioView();

		JFrame frame = new JFrame("GymPal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		CardLayout card = new CardLayout();
		JPanel panelCard = new JPanel(card);

		// crear pantallas
		inicioView.crearPantalla(card, panelCard);

		// agregar panelCard al frame
		frame.setLayout(new BorderLayout());
		frame.add(panelCard, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}
