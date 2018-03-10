package fr.zak.controleur;

import java.awt.Color;
import java.awt.image.BufferedImage;

import fr.zak.modele.Fractals;
import fr.zak.vue.FractalsFrame;

public class FractalControleur {
	/**
	 * fractals
	 */
	private Fractals fractals;
	private static FractalControleur instance = new FractalControleur();
	/*
	 * Instancie un Fractal
	 */
	private FractalControleur() {
		fractals = new Fractals();
	}

	/**
	 * @return the instance
	 */
	public static FractalControleur getInstance() {
		return instance;
	}

	/**
	 * generer Fractal
	 */
	public void genererFractal(BufferedImage buffer, Color couleur) {
		fractals.generate(buffer, couleur);
	}

}
