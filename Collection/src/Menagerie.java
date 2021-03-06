import java.util.ArrayList;

public class Menagerie {
	//Les attributs
	private ArrayList<Animal> listAnimaux;
	
	
	//le constructeur
	public Menagerie() {
		this.listAnimaux = new ArrayList <Animal>();
	}
	
	//m?thode
	public int getNombreAnimaux() {
		return this.listAnimaux.size();
	}
	
	//m?thode to string
	public String presenter() {
		String entete = "**PRESENTATION DE LA MENAGERIE**";
		String resultat = "\n" + "Nombre d'animaux :  " + this.getNombreAnimaux() + "\n";
		if (this.listAnimaux.size() != 0) {
			for (int i = 0; i < this.listAnimaux.size(); i++) {
				resultat += this.listAnimaux.get(i).sePresenter();
			}
		}
		else {
			resultat = "La Managerie ne poss?de aucun animal";
		}
		return entete + resultat;
	}
	
	//m?thode
		public boolean rechercherAnimal(Animal unAnimal) {
			boolean rep = false;
			
			if (this.listAnimaux.contains(unAnimal)){
				rep = true;
			}
			
			return rep;
		}
		
		
		//surcharge de la recherche
		public int rechercheAnimal(String unNom) {
			int rep = -1;
			int i = 0;
			
			if (this.listAnimaux.size() != -1) {
				while(i < this.listAnimaux.size() && this.listAnimaux.get(i).nomAnimal().equals(unNom)) {
					i++;
				}
				
				if (i < this.listAnimaux.size()) {
					rep = i;	
				}
			}
			
			return rep;
		}
		
		
		//m?thode ajouter
		public void arriver(Animal unAnimal) {
			//rechercher l'animal s'il n'existe pas on le rajoute
			//if (!rechercherAnimal(unAnimal)) {
				this.listAnimaux.add(unAnimal);	
			//}		
		}
		
		//surcharge arriver
		//on ne peut pas instancier un animal
		/*
		public void arriver(String unNom, String uneEspece) {
			Animal unAnimal = new Animal(unNom, uneEspece);
			if (! rechercherAnimal(unAnimal)) {
				this.listAnimaux.add(unAnimal);	
			}
		}
		*/
		
		//m?thode supprimer
		public void partir(Animal unAnimal) {
			//rechercher l'animal s'il existe on le supprime
			if (rechercherAnimal(unAnimal)) {
				this.listAnimaux.remove(unAnimal);
			}		
		}
		
		
		//surcharge de partir
		public void partir(int index) {
			this.listAnimaux.remove(index);
		}
		
		//surcharge de partir
		public boolean partir(String unNom) {
			boolean rep = false;
			int index = this.rechercheAnimal(unNom);
			
			if (index != -1){
				this.listAnimaux.remove(index);
				rep = true;
			}
			return rep;
		}

}


