package fr.zak.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import fr.zak.controleur.FractalControleur;

public class Panneau extends JPanel {
	private BufferedImage buffer;
	private Color couleur;
	private MenuDeroulant menuDeroulant;
	private BoutonRedessiner btnRedessiner;
	private ChangementCouleurListener couleurListener;
	private SourisPositionListener sourisListener;
	private ButtonChoixCouleur btnChoixCouleur;
	private ButtonChoixCouleurListener btButtonChoixCouleurListener;
	private Label label;
	/**
	 * initiliase tous les composant et les ajoutes
	 */
	public Panneau() {
		super();
		setLabel(new Label());
		btButtonChoixCouleurListener=new ButtonChoixCouleurListener(this);
		sourisListener=new SourisPositionListener(this);
		btnChoixCouleur=new ButtonChoixCouleur(btButtonChoixCouleurListener);
		setMenuDeroulant(new MenuDeroulant());
		couleurListener=new ChangementCouleurListener(this);
		btnRedessiner = new BoutonRedessiner(couleurListener);
		buffer = new BufferedImage(500,500, BufferedImage.TYPE_4BYTE_ABGR);
		setCouleur(Color.RED);
		add(getMenuDeroulant());
		add(btnRedessiner);
		addMouseMotionListener(sourisListener);
		add(btnChoixCouleur);
		add(getLabel());
		setSize(400, 500);
		setVisible(true);
	}
	/**
	 * dessine la forme sur le panneau
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		FractalControleur.getInstance().genererFractal(buffer, getCouleur());
		g.drawImage(buffer, 0, 0,null);
	}


	/**
	 * @return the couleur
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the menuDeroulant
	 */
	public MenuDeroulant getMenuDeroulant() {
		return menuDeroulant;
	}

	/**
	 * @param menuDeroulant the menuDeroulant to set
	 */
	public void setMenuDeroulant(MenuDeroulant menuDeroulant) {
		this.menuDeroulant = menuDeroulant;
	}

	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(Label label) {
		this.label = label;
	}

}
