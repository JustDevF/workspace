package classesLogiques;

//La classe Chient héritante de la classe abstraite Animal 
public class Chien extends Animal {
	//Attribut d'instance propre à la classe chien
	private String race;
	private String typeEducation;
	private String environnement;
	
	//Le constructeur
	public Chien(String uneEspece, String unNom, String uneRace, String unTypeEducation, String unEnvironnement) {
		//parent
		super(uneEspece, unNom);
		//enfant
		this.race = uneRace;
		this.typeEducation = unTypeEducation;
		this.environnement = unEnvironnement;
		
	}
	
	//Les accesseurs
	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getTypeEducation() {
		return typeEducation;
	}

	public void setTypeEducation(String typeEducation) {
		this.typeEducation = typeEducation;
	}

	public String getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
	}
	
	
	//Méthode de susbtitution de la méthode toString
	
	@Override 
	public String toString() {
		String afficher = "\n Chat :_";
			
		//vérifier que les propriétés d'instance ne sont pas null
		if (this.race != null & this.typeEducation != null & this.environnement != null) {
			afficher += "Espece : " + this.getEspece() + "\n Nom : " + this.getNom() + "\n";
			afficher += "Race : " + this.race + "\n Type d'éducation : " + this.typeEducation + "\n";
			afficher += "Environnement : " + this.environnement +"\n";
		}
			
			
			return afficher;
		}
	
	//Les méthodes de la classe parent qui doivent être implementer
	
	//dormir 
	 public  int tempsDormir() {
		 int tempsDodo = 20;
		return tempsDodo;
		 
	}
	
	//nouriture
	 @Override 
	public String nouriture() {
		String nouriture = "les croquettes, pâtés, la viande mélangée avec du riz, des pâtes, des légumes ";
		return nouriture;
		
	}
	 
	 
	//parler
	@Override
	public String parler() {
		String parler = "Les aboiements, les sons, les odeurs et les langage corporel";
		return parler;
	}
	
	//nombre de propriétés toal par classe enfant
	public int nombreProprieteTotal() {
		return 5;
			
	}
	
	
	
	

}
