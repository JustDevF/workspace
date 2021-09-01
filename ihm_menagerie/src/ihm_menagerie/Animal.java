package ihm_menagerie;

public abstract class  Animal {
	// ATTRIBUT
	private String espece;
	private String nom;
	
	//CONSTRUCTEUR

	public Animal() {
	}

	public Animal(String uneEspece, String unNom) {
		this.espece = uneEspece;
		this.nom = unNom;
	}
	
	//ACCESSEURS

	public String getEspece() {
		return this.espece;
	}
	public void setEspece(String uneEspeces) {
		this.espece = uneEspeces;
	}
	
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String unNom) {
		this.nom = unNom;
	}
	

	
	public String toString() {
		String chaine="\nAnimal : \n";
		if (this.espece != null ) {
			chaine = chaine +" Espece : " + this.espece + " \n";
		}
		if ( this.nom != null ) {
			chaine = chaine +" Nom : " +this.nom + " \n";
		}
		return chaine;
	}

	public  String sePresenter() {
		// TODO Auto-generated method stub
		return null;
	}

	
}