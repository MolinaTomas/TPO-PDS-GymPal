package com.uade.gymapp.gymapp;

import com.uade.gymapp.gymapp.controller.RutinaController;
import com.uade.gymapp.gymapp.controller.SocioController;
import com.uade.gymapp.gymapp.model.Socio;
import com.uade.gymapp.gymapp.views.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.query.JSqlParserUtils;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class GymappApplication {
	private static SocioController socioController;
	private static RutinaController rutinaController;

	private static InicioView inicioView;
	private static LoginView loginView;
	private static SingupView signupView;
	private static DashboardView dashboardView;
	private static PerfilView perfilView;
	private static ConfigurarPerfilView configurarPerfilView;
	private static MedicionView medicionView;
	private static HistorialMedicionesView historialMedicionesView;
	private static RutinaView rutinaView;
	private static EntrenamientoView entrenamientoView;
	private static HistorialEntrenamientosView historialEntrenamientosView;
	private static RegistrarEntrenamientoView registrarEntrenamientoView;
	private static TrofeosView trofeosView;


	public static void main(String[] args) {
		//GymappApplication app = new GymappApplication();
		//app.setVisible(true);

		socioController = new SocioController();
		rutinaController = new RutinaController();

		inicioView = new InicioView();
		loginView = new LoginView();
		signupView = new SingupView();
		dashboardView = new DashboardView();
		perfilView = new PerfilView();
		configurarPerfilView = new ConfigurarPerfilView();
		medicionView = new MedicionView();
		historialMedicionesView = new HistorialMedicionesView();
		rutinaView = new RutinaView();
		entrenamientoView = new EntrenamientoView();
		historialEntrenamientosView = new HistorialEntrenamientosView();
		registrarEntrenamientoView = new RegistrarEntrenamientoView();
		trofeosView = new TrofeosView();

		JFrame frame = new JFrame("GymPal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 700);
		frame.setLocationRelativeTo(null);
		CardLayout card = new CardLayout();
		JPanel panelCard = new JPanel(card);

		// crear pantallas
		inicioView.crearPantalla(card, panelCard);
		dashboardView.crearPantalla(socioController, card, panelCard);
		loginView.crearPantalla(socioController, card, panelCard);
		signupView.crearPantalla(socioController, card, panelCard);
		medicionView.crearPantalla(card, panelCard, historialMedicionesView);
		registrarEntrenamientoView.crearPantalla(card, panelCard);

		// agregar panelCard al frame
		frame.setLayout(new BorderLayout());
		frame.add(panelCard, BorderLayout.CENTER);
		card.show(panelCard, "Inicio");
		frame.setVisible(true);
	}

	public static void crearPantallasPersonalizadas(CardLayout card, JPanel panelCard) {
		perfilView.crearPantalla(card, panelCard);
		configurarPerfilView.crearPantalla(card, panelCard);

		Socio socioActual = SocioController.getUsuarioActual();
		rutinaController.crearRutina(socioActual, socioActual.getObjetivo());

		rutinaView.crearPantalla(card, panelCard, entrenamientoView);
		historialEntrenamientosView.crearPantalla(card, panelCard);
		historialMedicionesView.crearPantalla(card, panelCard);
		trofeosView.crearPantalla(card, panelCard);
	}

	// Método para devolver esta instancia de socioController
	public static SocioController getSocioController() {
		return socioController;
	}
}