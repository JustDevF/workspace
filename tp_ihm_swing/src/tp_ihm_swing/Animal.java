package tp_ihm_swing;

public abstract class Animal {
	//Les attributs
		private String nom;
		private String espece;
		/**
		 * constructeur par d�faut
		 * **/
		public Animal() {
		}
		
		public Animal(String unNom, String uneEspece) {
			this.nom = unNom;
			this.espece = uneEspece;
		}
		
		//M�thode
		public String dormir() {
			String resultat = "";
			return resultat;
		}
		
		//M�thode
		public String manger() {
			String resultat = "";
			return resultat;
		}
		
		//M�thode
		public String parler() {
			String resultat = "";
			return resultat;
		}
		
		//M�thode
		public String sePresenter() {
			String resultat = "Je me presente : " + this.nom + " " + this.espece + "\n";
			return resultat;
		}
		
		public String nomAnimal() {
			return this.nom;
		}
}
