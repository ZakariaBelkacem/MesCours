package fr.zak.vue;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JApplet;

import fr.zak.controleur.Manager;

public class CourseApplet extends JApplet implements Vue {

	private CourseProgressBar pb[];

	public CourseApplet() {
		pb = new CourseProgressBar[Manager.NBMAX];
		pb[0] = new CourseProgressBar(Color.BLACK);
		pb[1] = new CourseProgressBar(Color.YELLOW);
		pb[2] = new CourseProgressBar(Color.pink);
		pb[3] = new CourseProgressBar(Color.red);
		pb[4] = new CourseProgressBar(Color.green);
	}

	@Override
	public void init() {
		setLayout(new GridLayout(5, 1));
		Manager.getInstance().setCourseApplet(this);
		for (CourseProgressBar courseProgressBar : pb) {
			add(courseProgressBar);
		}
		
		// pb.setVisible(true);
		//setLayout(new FlowLayout());

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
	public void afficher(int pos, int value, String nom, int Classement,long seconde) {
		pb[pos].setValue(value);
		pb[pos].setString(nom+" FINI "+Classement+" en "+seconde+" secondes ");
		
	}

}
