package fr.zak.model.technique;

import java.util.TimerTask;

import fr.zak.controleur.Manager;

public class Comimssaire extends TimerTask {
	/**
	 * temps avant de lancer la course une fois que les coureurs sont arrivés sur la
	 * ligne de départ
	 */
	private final static int TEMPSDECLENCHEUR = 10000;
	/**
	 * temps
	 */
	private int temps;
	/**
	 * retourne true une fois le compte à rebour terminer
	 */
	private boolean decompteFini = false;

	public Comimssaire() {
		temps = TEMPSDECLENCHEUR / 1000;
	}

	/**
	 * decremente le temps jusqu'a 0
	 * 
	 * @return retourne le temps
	 */
	public int compteARebour() {
		while (temps > 0) {
			Manager.getInstance().afficher(temps);
			temps = temps - 1;
			System.out.println(temps);
			return temps;
		}
		if (temps == 0) {
			setDecompteFini(true);
		}
		return temps;
	}

	@Override
	public void run() {
		System.out.println("ok commisaire");
		if (decompteFini) {
			Manager.getInstance().getTimer().cancel();
			Manager.getInstance().afficher("GO!!");
			Manager.getInstance().relancerCourse();
		}
		compteARebour();
	}

	/**
	 * @return the decompteFini
	 */
	public boolean isDecompteFini() {
		return decompteFini;
	}

	/**
	 * @param decompteFini
	 *            the decompteFini to set
	 */
	public void setDecompteFini(boolean decompteFini) {
		this.decompteFini = decompteFini;
	}

}
