package fr.zak.model.technique;

import java.util.TimerTask;

import fr.zak.controleur.Manager;

public class Comimssaire extends TimerTask {
	public Comimssaire() {

	}

	@Override
	public void run() {
		Manager.getInstance().demarrer();
	}

}
