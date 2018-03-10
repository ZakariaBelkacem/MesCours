package fr.zak.vue;

public interface Vue {
	public void afficher(int pos, int value, String nom);
	public void afficher(int pos, int value, String nom,int Classement,long seconde);
}