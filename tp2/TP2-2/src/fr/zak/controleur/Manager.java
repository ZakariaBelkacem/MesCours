package fr.zak.controleur;

import java.util.Timer;

import fr.zak.model.technique.Comimssaire;
import fr.zak.model.technique.Coureur;
import fr.zak.modele.TypeCoureur;
import fr.zak.vue.CourseApplet;

public class Manager {
	/**
	 * demarreur appele le commisaire
	 */
	private Timer timer = null;
	/**
	 * le commisaire
	 */
	private Comimssaire commissaire = null;
	/**
	 * 
	 */
	/**
	 * tableau qui contient les coureur
	 */
	private Coureur Lescoureurs[] = null;
	/**
	 * nb max de coureur
	 */
	public static final int NBMAX = 5;
	/**
	 * instance du manager
	 */
	private static Manager instance = new Manager();
	/**
	 * reference vers la vue
	 */
	private CourseApplet courseApplet;

	/**
	 * instancie et initiliatise les coureurs
	 */
	private Manager() {
		timer = new Timer();
		commissaire = new Comimssaire();
		Lescoureurs = new Coureur[NBMAX];
		init();
	}

	/**
	 * 
	 * @return
	 */
	public static Manager getInstance() {
		return instance;
	}

	/**
	 * initialise les coureur
	 */
	public void init() {
		Lescoureurs[0] = new Coureur(0, TypeCoureur.LIEVRE);
		Lescoureurs[1] = new Coureur(1, TypeCoureur.TORTUE);
		Lescoureurs[2] = new Coureur(2, TypeCoureur.LION);
		Lescoureurs[3] = new Coureur(3, TypeCoureur.GAZELLE);
		Lescoureurs[4] = new Coureur(4, TypeCoureur.GIRAFE);
		timer.schedule(commissaire, 10000);
	}

	/**
	 * demare le thread des coureurs
	 */
	public void demarrer() {
		for (Coureur coureur : Lescoureurs) {
			coureur.start();
		}
	}

	/**
	 * 
	 * @return retourne la reference de la vue
	 */
	public CourseApplet getCourseApplet() {
		return courseApplet;
	}

	/**
	 * met à jour la vue
	 * 
	 * @param pos
	 * @param value
	 * @param nom
	 */
	
	public void afficher(int pos, int value, String nom) {
		if (courseApplet != null) {
			courseApplet.afficher(pos, value, nom);
		}
	}
	
	/**
	 * met à jour la vue
	 * 
	 * @param pos
	 * @param value
	 * @param nom
	 */
	
	public void afficher(int pos, int value, String nom,int Classement,long seconde) {
		if (courseApplet != null) {
			courseApplet.afficher(pos, value, nom,Classement,seconde);
		}
	}

	/**
	 * 
	 * @param courseApplet
	 *            met à jour la reference de la vue
	 */
	public void setCourseApplet(CourseApplet courseApplet) {
		this.courseApplet = courseApplet;
	}
}
