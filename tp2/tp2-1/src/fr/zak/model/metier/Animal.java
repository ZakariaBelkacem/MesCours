package fr.zak.model.metier;

public abstract class Animal {
	private static final int ARRIVEE = 100;
	private String nom;
	private int position;
	private int id;

	Animal(String nom, int id) {
		this.id = id;
		position = 0;
		this.nom = nom;
	}

	/**
	 * incremente la position de lanimal
	 */
	public void avancer() {
		position += 1;
	}

	/**
	 * 
	 * @return retourne vrai si la course est fini
	 */
	public boolean estArriver() {
		return position >= ARRIVEE;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

}
