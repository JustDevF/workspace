package tp_ihm_swing;

public abstract class Animal {
	//Les attributs
		private String nom;
		private String espece;
		/**
		 * constructeur par défaut
		 * **/
		public Animal() {
		}
		
		public Animal(String unNom, String uneEspece) {
			this.nom = unNom;
			this.espece = uneEspece;
		}
		
		//Méthode
		public String dormir() {
			String resultat = "";
			return resultat;
		}
		
		//Méthode
		public String manger() {
			String resultat = "";
			return resultat;
		}
		
		//Méthode
		public String parler() {
			String resultat = "";
			return resultat;
		}
		
		//Méthode
		public String sePresenter() {
			String resultat = "Je me presente : " + this.nom + " " + this.espece + "\n";
			return resultat;
		}
		
		public String nomAnimal() {
			return this.nom;
		}
}
