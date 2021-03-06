package classesLogiques;

import java.util.ArrayList;

//La classe ménagerie permet gérer les animaux par type d'association de classe
public class Menagerie {
	//Les attributs d'instance
	//collection d'instance des animaux
	private ArrayList<Animal> listAnimaux;
	
	//Méthode de la classe pour éviter d'instancier plusieurs menageries
	public static Menagerie uneMenagerie = new Menagerie();
		
	
	//.....................................................................
	//le constructeur
	public Menagerie() {
		this.listAnimaux = new ArrayList<Animal>();
	}
	
	
	//.....................................................................
	
	//méthodes d'instances 
	
	public int getNombreAnimaux() {
		return this.listAnimaux.size();
	}
	
	//méthode to string pour afficher les animaux présents dans la collection
	@Override
	public String toString() {
		String afficher = "\n Les animaux présents dans la ménagerie : \n";
		afficher += "\n Nombre des animaux : " + this.getNombreAnimaux();
		
		//vérifier que la connection des animaux contient des animaux 
		if(this.getNombreAnimaux() != 0) {
			//boucle pour afficher la méthode toString de chaque instance d'animal dans la connection d'instance des animaux
			for(int i = 0; i < this.listAnimaux.size(); i++) {
				afficher += this.listAnimaux.get(i).toString();
			}
		} else {
			afficher = "La Managerie ne possède aucun animal";
		}
		
		return afficher;
		
	}
	
	
	//accesseurs
	public ArrayList<Animal> getListAnimaux() {
		return listAnimaux;
	}



	//ajouter un animal
	public boolean ajoutAnnimal(Animal unAnimal) {
		boolean verifierAnimal = false;
		//vérifier si l'animal n'existe pas avant de l'ajouter
		if(!this.listAnimaux.contains(unAnimal)) {
			//instancier un chat par transtypage ascendant car la classe animal est abstraite donc elle ne peut pas être instancier
			this.listAnimaux.add(unAnimal);	
			verifierAnimal = true;
		}
			
		return verifierAnimal;
	}
	
	
	
	//rechercher animal
	public boolean rechercherAnimal(Animal unAnimal) {
		boolean rep = false;
		
		if (this.listAnimaux.contains(unAnimal)){
			rep = true;
		}
		
		return rep;
	}
	
	//recherche animal méthode de surcharge renvoie un entier car la collection à besoin d'index de l'instance d'un animal pour le supprimer de la liste grâce à la méthode move()
	public int rechercheAnimal(String unNom) {
		int rep = -1;
		int i = 0;
				
		if (this.listAnimaux.size() != -1) {
			//parcourir la collection pour faire correpondre le saisie saisie à celui des animaux de la collection
			while(i < this.listAnimaux.size() && !this.listAnimaux.get(i).getNom().equals(unNom)) {
				i++;
			}
					
			if (i < this.listAnimaux.size()) {
				rep = i;
			}
			
		}
				
		return rep;
	}
	
	
	//supprimer un animal par son instance
	public void supprimerAnimal(Animal unAnimal) {
		//rechercher l'animal s'il existe on le supprime
		if (rechercherAnimal(unAnimal)) {
			this.listAnimaux.remove(unAnimal);
		}		
	}
	
	//surcharge de la méthode supprimer par son l'index
	public void supprimerAnimal(int index) {
		if(index != -1) {
			this.listAnimaux.remove(index);
		}
		
	}
	
	//surcharge de la méthode supprimer par son nom
	public boolean supprimerAnimal(String unNom) {
		boolean rep = false;
		//rechercher si l'animal existe pour pouvoir le supprimer de la liste de collection
		//appel de la méthode d'instance rechercheAnimal qui renvoie l'index de l'animal ou -1 en cas d'échec
		int index = this.rechercheAnimal(unNom);
		
		if (index != -1){
			this.listAnimaux.remove(index);
			rep = true;
		}
		return rep;
	}

	
	//méthode principal pour lancer l'app et faire des essaies
	
			public static void main(String[] args) {
			
				
				//instanciation d'animal par transtypage ascendant
				//Animal chienVille = new Chien ("bulldog","Mars", "berger Allemand", "Chien millitaire", "Ville");
				//Animal chatFrancais = new Chat ("American curl", "Mimi", " domestique", "gris", "france");
				Animal chienRue = new Chien ("MillitaryDog","Young", "Bouvier Bernois", "Chien millitaire", "Ville");
				Animal chatAllemand = new Chat ("Bobtail japonais", "hitler", " domestique", "blanc", "allemand");
				Animal chatRusse = new Chat ("Bobtail japonais", "Bua", " domestique", "blanc", "allemand");
				
				
				//appel des méthodes 
				
				
				//instancier une nouvelle instance de la classe Menagerie
				Menagerie uneMenagerie = new Menagerie();
				
				
				
			
				//ajouter des animaux dans la liste de collection à partir de méthode d'instance de la classe menagerie
				
				boolean valide = uneMenagerie.ajoutAnnimal(chatAllemand);
				
				uneMenagerie.ajoutAnnimal(chatAllemand);
				uneMenagerie.ajoutAnnimal(chienRue);
				uneMenagerie.ajoutAnnimal(chatRusse);
				
				
				int indexAnimal = uneMenagerie.rechercheAnimal("hitler");
				
				//Afficher
				
				//System.out.println(uneMenagerie.getNombreAnimaux() + " " + valide);
				//System.out.println(uneMenagerie.toString());
				System.out.println(indexAnimal);
				System.out.println(uneMenagerie.getListAnimaux());
				
				
				
			}
	       
	 	

	

	//.....................................................................
	
	
}
