package fr.zak.vue;

public interface Vue {
	public void afficher(int pos, int value, String nom);

	public void afficher(int pos, int value, String nom, int Classement, long seconde);

	public void afficher(int temps);

	public void afficher();

	public void afficher(String message);
}