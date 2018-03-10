package fr.zak.model.metier;

public abstract class Animal {
	private static final int ARRIVEE = 100;
	private String nom;
	private int position;
	private static int classement;
	private int id;
	private boolean ok = false;

	Animal(String nom, int id) {
		this.id = id;
		position = 0;
		this.nom = nom;
	}

	/**
	 * incremente la position de lanimal
	 */
	public synchronized void avancer() {
		position += 1;
		/*
		 * while (estArriver()&&!ok) { System.out.println(getNom() + estArriver()); try
		 * { Manager.getInstance().lancerCommissaire(); wait(); ok=true; } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } notify();
		 */

	}

	/**
	 * 
	 * @return retourne vrai si la course est fini
	 */
	public boolean estArriver() {
		return position > ARRIVEE;
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

	public void setId() {
		this.id = getId() + 1;
	}

	public int getClassement() {
		return classement;
	}

	public void setClassement() {
		classement = classement + 1;
	}

}
