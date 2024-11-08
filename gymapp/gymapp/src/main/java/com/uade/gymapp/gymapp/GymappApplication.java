package com.uade.gymapp.gymapp;

import com.uade.gymapp.gymapp.views.DashboardView;
import com.uade.gymapp.gymapp.views.InicioView;
import com.uade.gymapp.gymapp.views.LoginView;
import com.uade.gymapp.gymapp.views.SingupView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class GymappApplication extends JFrame {

	private CardLayout cardLayout;
	private JPanel mainPanel;

	public GymappApplication() {
		super("GymPal");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);

		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);

		// Agregamos las vistas al CardLayout
		mainPanel.add(new InicioView(this), "InicioView");
		mainPanel.add(new LoginView(this), "LoginView");
		mainPanel.add(new SingupView(this), "SignupView");
		mainPanel.add(new DashboardView(this), "DashboardView");

		this.add(mainPanel);
	}

	public void mostrarVista(String nombreVista) {
		cardLayout.show(mainPanel, nombreVista);
	}

	public static void main(String[] args) {
//		SpringApplication.run(GymappApplication.class, args);
		GymappApplication app = new GymappApplication();
		app.setVisible(true);
	}

}
