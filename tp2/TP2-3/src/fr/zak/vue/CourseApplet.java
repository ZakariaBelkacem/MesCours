package fr.zak.vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JLabel;
import fr.zak.controleur.Manager;

public class CourseApplet extends JApplet implements Vue {

	private CourseProgressBar[] pb = null;
	JLabel jlb = null;

	public CourseApplet() {
		jlb = new courseLabel();
		pb = new CourseProgressBar[Manager.NBCOUREUR * 2];
		pb[0] = new CourseProgressBar(Color.ORANGE);
		pb[1] = new CourseProgressBar(Color.BLACK);
		pb[2] = new CourseProgressBar(Color.ORANGE);
		pb[3] = new CourseProgressBar(Color.CYAN);
		pb[4] = new CourseProgressBar(Color.ORANGE);
		pb[5] = new CourseProgressBar(Color.pink);
		pb[6] = new CourseProgressBar(Color.ORANGE);
		pb[7] = new CourseProgressBar(Color.red);
		pb[8] = new CourseProgressBar(Color.ORANGE);
		pb[9] = new CourseProgressBar(Color.green);

	}

	@Override
	public void init() {
		setSize(500, 400);
		afficher();
		setLayout(new GridLayout(6, 2));
		Manager.getInstance().demarrer();
		Manager.getInstance().setCourseApplet(this);
		for (CourseProgressBar courseProgressBar : pb) {
			add(courseProgressBar);
		}
		add(jlb);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afficher(int pos, int value, String nom) {
		pb[pos].setValue(value);
		pb[pos].setString(nom);

	}

	@Override
	public void afficher(int pos, int value, String nom, int Classement, long seconde) {
		pb[pos].setValue(value);
		pb[pos].setString(nom + " FINI " + Classement + " en " + seconde + " secondes ");

	}

	@Override
	public void afficher(int temps) {
		jlb.setText("" + temps);
	}

	@Override
	public void afficher() {
		jlb.setText("A VOS MARQUES");
	}

	@Override
	public void afficher(String message) {
		jlb.setText(message);

	}

}
