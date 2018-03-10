package fr.zak.vue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class SourisPositionListener implements MouseMotionListener {
	private Panneau panneau;

	public SourisPositionListener(Panneau panneau) {
		this.panneau = panneau;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		panneau.getLabel().setText("X:"+e.getX()+" "+"Y:"+e.getY());
	}

}
