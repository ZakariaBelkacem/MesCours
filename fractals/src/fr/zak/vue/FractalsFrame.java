package fr.zak.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import fr.zak.controleur.FractalControleur;
import fr.zak.modele.Fractals;

public class FractalsFrame extends JFrame {
	/*
	 * reference vers le paneau
	 */
	private Panneau panneau;
	/**
	 * reference vers le listenner declenche lorsque on ferme la fenetre
	 */
	private FermerFenetreListener fermerFenetreEvent;
	/**
	 * constructeur ajoute le titre de la frame
	 * instancie le listener FractalsFrameEventsListener
	 * initialise la taille de la frame
	 * instancie un nouveau panneau
	 * Ajoute un window Listenner
	 * Rend visible laffichage
	 */
	public FractalsFrame() {
		super("Les FRACTALS de Mandelbrot");
		fermerFenetreEvent = new FermerFenetreListener(this);
		setSize(500, 500);
		panneau = new Panneau();
		add(panneau);
		addWindowListener(fermerFenetreEvent);
		setVisible(true);

	}

}
