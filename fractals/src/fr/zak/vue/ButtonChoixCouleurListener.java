package fr.zak.vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

public class ButtonChoixCouleurListener implements ActionListener{
	/**
	 * reference vers le panneau
	 */
	private Panneau panneau;
	
	/**
	 * la couleur
	 */
	private Color couleur;
	/**
	 * Construteur qui initilise la reference vers le panneau
	 * @param panneau
	 * 				le panneau
	 */
	public ButtonChoixCouleurListener(Panneau panneau) {
		this.panneau=panneau;
		
		
	}
	/**
	 * on recupere la couleur choisi dans la palette
	 * on change la figure de couleur
	 * on redessine la figure
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		couleur = PaletteCouleur.showDialog(null, "choisir une couleur", Color.red);
		if(couleur != null)
		{	
			panneau.setCouleur(couleur);
			panneau.repaint();
			
		}else
		{
			System.out.println("Attention");
		}

	}

}
