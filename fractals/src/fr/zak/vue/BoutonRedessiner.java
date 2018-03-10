package fr.zak.vue;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BoutonRedessiner extends JButton {
	/**
	 * bouton redessiner
	 * @param a
	 * 		  le Listener changementCouleur
	 */
	public BoutonRedessiner(ActionListener a) {
		super("Redessiner");
		addActionListener(a);
	}

}
