package fr.zak.vue;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class FermerFenetreListener extends WindowAdapter {
	/**
	 * reference vers la frame
	 */
	FractalsFrame frame;
	/**
	 * initiliase la reference vers la frame
	 * @param frame
	 */
	public FermerFenetreListener(FractalsFrame frame) {
		super();
		this.frame = frame;

	}
	/**
	 * Creer une boite de dialogue Sortie
	 * et qui effectue des actions seulon les reponses
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		int reponse = 0;
		reponse = PanneauOption.showOptionDialog(frame, "voulez vous vraiment sortir ?", "SORTIE",
				PanneauOption.YES_NO_CANCEL_OPTION, PanneauOption.QUESTION_MESSAGE, null, null, null);
		switch (reponse) {
		case PanneauOption.YES_OPTION:
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			break;
		case PanneauOption.NO_OPTION:
			frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
			break;
		case PanneauOption.CANCEL_OPTION:
			frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		}
	}
}
