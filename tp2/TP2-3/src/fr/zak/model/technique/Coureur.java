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
	/**
	 * un animal
	 */
	private Animal animal;
	/**
	 * un thread
	 */
	private Thread thread;
	/**
	 * nb de seconde depuis que le programe à debuté
	 */
	private long secondeDebut;
	/**
	 * nb de seconde depuis le programme est fini
	 */
	private long secondeFin;
	private boolean ok = false;

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

		while (!animal.estArriver()) {

			try {

				Manager.getInstance().afficher(animal.getId(), animal.getPosition(), animal.getNom());
				Thread.sleep((long) (100 * Math.random()));
			} catch (InterruptedException e) {

			}
			animal.avancer();
			arriverLigneDepart();
		}

		animal.setClassement();
		secondeFin = System.currentTimeMillis() / 1000;
		secondeFin = secondeFin - secondeDebut;
		Manager.getInstance().afficher(animal.getId(), animal.getPosition(), animal.getNom(), animal.getClassement(),
				secondeFin);
	}

	public void start() {
		thread.start();
	}

	public synchronized void arriverLigneDepart() {
		while (animal.estArriver() && !ok) {
			System.out.println(animal.getNom() + animal.estArriver());
			try {
				Manager.getInstance().lancerCommissaire();
				wait();
				ok = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void lancerCoureur() {
		notify();
	}

	/**
	 * met la position à 0 fait courir les coureur incremnte l'id pour l'affichage
	 */
	public void go() {
		animal.setPosition(0);
		secondeDebut = System.currentTimeMillis() / 1000;
		System.out.println(secondeDebut);
		animal.avancer();
		setId();
		lancerCoureur();
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId() {
		animal.setId();
	}

}
