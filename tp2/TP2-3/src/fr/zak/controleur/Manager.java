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
	 * tableau qui contient les coureur
	 */
	private Coureur Lescoureurs[] = null;
	/**
	 * nb max de coureur
	 */
	public static final int NBCOUREUR = 5;
	private static int nbCoureurArriver = 0;
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
		Lescoureurs = new Coureur[NBCOUREUR];
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
		Lescoureurs[1] = new Coureur(2, TypeCoureur.TORTUE);
		Lescoureurs[2] = new Coureur(4, TypeCoureur.LION);
		Lescoureurs[3] = new Coureur(6, TypeCoureur.GAZELLE);
		Lescoureurs[4] = new Coureur(8, TypeCoureur.GIRAFE);
		// timer.schedule(commissaire, 1000);
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
	 * met à jour la vue avec le nom et la position du coureur
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
	 *affiche le message en parametre
	 * 
	 * @param pos
	 * @param value
	 * @param nom
	 */
	public void afficher(String message) {
		if (courseApplet != null) {
			courseApplet.afficher(message);
		}
	}

	/**
	 * met à jour la vue du compte à rebour
	 * 
	 * @param pos
	 * @param value
	 * @param nom
	 */
	public void afficher(int i) {
		if (courseApplet != null) {
			courseApplet.afficher(i);
		}
	}

	/**
	 * met à jour la vue le nom du coureur son classement et le nb seconde depuis
	 * que la course est fini
	 * 
	 * @param pos
	 * @param value
	 * @param nom
	 */

	public void afficher(int pos, int value, String nom, int Classement, long seconde) {
		if (courseApplet != null) {
			courseApplet.afficher(pos, value, nom, Classement, seconde);
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

	/**
	 * une fois que les 5 coureurs sont arrivés sur la ligne de départ on informe le
	 * commisaire
	 */
	public void lancerCommissaire() {
		nbCoureurArriver++;
		if (nbCoureurArriver == NBCOUREUR) {
			timer.schedule(commissaire,0, 1000);
		}
	}

	/**
	 * on relance la course
	 */
	public void relancerCourse() {
		for (Coureur coureur : Lescoureurs) {
			System.out.println("ok relancerCourse");
			coureur.go();
		}
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}
