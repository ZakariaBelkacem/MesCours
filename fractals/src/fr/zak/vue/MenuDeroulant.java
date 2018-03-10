package fr.zak.vue;

import java.awt.Dimension;

import javax.swing.JComboBox;

public class MenuDeroulant extends JComboBox<String> {
	/**
	 * MenuDeroulant avec le non des couleurs
	 */
	public MenuDeroulant() {
		super();
		addItem(Constantes.BLEU);
		addItem(Constantes.RED);
		addItem(Constantes.GREEN);
		addItem(Constantes.BLACK);
		setPreferredSize(new Dimension(100, 50));
		setOpaque(true);
		setVisible(true);
	}

}
