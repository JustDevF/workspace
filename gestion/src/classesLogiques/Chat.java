package classesLogiques;

//La classe Chat héritante de la classe abstraite Animal 
public class Chat extends Animal{
	//Attribut d'instance propre à la classe chat 
	private String race;
	private String couleur;
	private String origine;
	
	
	//Le constructeur
	public Chat(String uneEspece, String unNom, String uneRace, String uneCouleur, String uneOrigine) {
		//init attributs d'instance constructeur classe parent
		super(uneEspece, unNom);
		//init attributs d'instance ce cette classe
		this.race = uneRace;
		this.couleur = uneCouleur;
		this.origine = uneOrigine;
	}


	//Les accesseurs
	public String getRace() {
		return race;
	}


	public void setRace(String race) {
		this.race = race;
	}


	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public String getOrigine() {
		return origine;
	}


	public void setOrigine(String origine) {
		this.origine = origine;
	}
	
	//Méthode de susbtitution de la méthode toString
	
	@Override 
	public String toString() {
		String afficher = "\n Chat :_";
		
		//vérifier que les propriétés d'instance ne sont pas null
		if (this.race != null & this.couleur != null & this.origine != null) {
			afficher += "Espece : " + this.getEspece() + "\n Nom : " + this.getNom() + "\n";
			afficher += "Race : " + this.race + "\n Couleur : " + this.couleur + "\n";
			afficher += "Origine : " + this.origine +"\n";
		}
		
		
		return afficher;
	}
	
	//Les méthodes de la classe parent qui doivent être implementer
	
	////dormir 
	 public  int tempsDormir() {
		 int tempsDodo = 6;
		return tempsDodo;
		 
	}
	
	//nouriture
	 @Override 
	public String nouriture() {
		String nouriture = "La viande, le poisson, de légumes, de riz ou de pâtes";
		return nouriture;
		
	}
	 
	 
	//parler
	@Override
	public String parler() {
		String parler = "Les miaulements et le ronronnement";
		return parler;
	}
	
	//nombre de propriétés toal par classe enfant
	public int nombreProprieteTotal() {
		return 5;
		
	}

}
