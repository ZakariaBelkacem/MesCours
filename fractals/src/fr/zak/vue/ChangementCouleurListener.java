package fr.zak.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangementCouleurListener implements ActionListener{
	/**
	 * reference vers le panneau
	 */
	private Panneau panneau;
	/**
	 * Construteur qui initilise la reference vers le panneau
	 * @param panneau
	 * 				le panneau
	 */
	public ChangementCouleurListener(Panneau panneau) {
		this.panneau=panneau;
		
	}
	/**
	 * Lorsque le listener est déclenché 
	 * il recupere le nom de la couleur 
	 * et la change et dit au panneau de repeindre la figure
	 * avec la bonne couleur
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("cool");
		switch ((String) panneau.getMenuDeroulant().getSelectedItem()) {
		case Constantes.BLEU:
			panneau.setCouleur(Color.BLUE);
			break;
		case Constantes.RED:
			panneau.setCouleur(Color.RED);
			break;
		case Constantes.GREEN:
			panneau.setCouleur(Color.GREEN);
			break;
		case Constantes.BLACK:
			panneau.setCouleur(Color.BLACK);
			break;
		default:
			break;
		}
		panneau.repaint();
		
	}

}
