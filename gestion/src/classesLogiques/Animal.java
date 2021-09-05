package classesLogiques;

//La classe principle des animaux
public abstract class Animal {
	//Attribut d'instance
	
	//les propriétés communes à tous les animaux 
	private String espece;
	private String nom;
	
	
	//Le constructeur
	public Animal(String uneEspece, String unNom) {
		//initialisation des attributs d'instance
		this.espece = uneEspece;
		this.nom = unNom;
	}
	
	
	//les accesseurs
	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	
	//Méthode de susbtitution de la méthode toString
	
	@Override 
	public String toString() {
		String afficher = "\n Animal :_";
		
		//vérifier que les propriétés d'instance ne sont pas null
		if (this.espece != null & this.nom != null) {
			afficher += "Espece : " + this.espece + "\n Nom : " + this.nom + "\n";
		}
		
		
		return afficher;
	}
	
	//Les méthodes que les enfants héritants de cette classe devront implémenter
	
	//dormir
	public abstract int tempsDormir(); 
	
	//nouriture
	public abstract String nouriture();
	
	
	//parler
	public abstract String  parler();
	
	//nombre de propriétés toal par classe enfant
	public abstract int nombreProprieteTotal();
	

}
