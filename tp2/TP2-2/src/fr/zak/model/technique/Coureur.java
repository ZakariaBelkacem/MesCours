package fr.zak.model.technique;

import fr.zak.controleur.Manager;
import fr.zak.model.metier.Animal;
import fr.zak.model.metier.Gazelle;
import fr.zak.model.metier.Girafe;
import fr.zak.model.metier.Lievre;
import fr.zak.model.metier.Lion;
import fr.zak.model.metier.Tortue;
import fr.zak.modele.TypeCoureur;

public class Coureur implements Runnable {

	private Animal animal;
	private Thread thread;
	private long secondeDebut;
	private long secondeFin;

	public Coureur(int id, TypeCoureur tc) {
		switch (tc) {
		case LIEVRE:
			animal = new Lievre(id);
			break;
		case TORTUE:
			animal = new Tortue(id);
			break;
		case LION:
			animal = new Lion(id);
			break;
		case GAZELLE:
			animal = new Gazelle(id);
			break;
		case GIRAFE:
			animal = new Girafe(id);
			break;
		}
		thread = new Thread(this);
	}

	@Override
	public void run() {
		secondeDebut=System.currentTimeMillis()/1000;
		while (!animal.estArriver()) {
			animal.avancer();
			try {
				System.out.println(animal.getNom()+animal.getClassement());
				Manager.getInstance().afficher(animal.getId(), animal.getPosition(), animal.getNom());
				Thread.sleep((long) (500*Math.random()));
			} catch (InterruptedException e) {
				
			}
		}
		animal.setClassement();
		secondeFin=System.currentTimeMillis()/1000;
		secondeFin=secondeFin-secondeDebut;
		Manager.getInstance().afficher(animal.getId(), animal.getPosition(),animal.getNom(),animal.getClassement(),secondeFin);
	}

	public void start() {
		thread.start();
	}

}
