package fr.zak.vue;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonChoixCouleur extends JButton {
	/**
	 *bouron pour choisir une couleur
	 * @param l
	 *			l'action listener qui affiche une palette
	 */
	public ButtonChoixCouleur(ActionListener l) {
		super("Couleur Palette");
		addActionListener(l);
	}

}
