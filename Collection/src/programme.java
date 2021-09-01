
import java.util.Scanner;

public class programme {
	private static Scanner clavier;

	public static void main(String[] args) {
		clavier = new Scanner(System.in);		
		//instaciation 		
		Menagerie maMenagerie = new Menagerie();
		
		int choix;
		
		//Boucle pour quitter le programme
		do {
			System.out.println("**Bienvenue au Ménagerie**");
			System.out.println("\t 1- Afficher la ménagerie.");
			System.out.println("\t 2- Ajouter un animal.");
			System.out.println("\t 3- Supprimer un animal.");
			System.out.println("\t 4- Rechercher un animal.");
			System.out.println("\t 5- Quitter la Ménagerie.");
			
			System.out.println("\t Saisir votre choix ou 5 pour quitter :");
			//entrer clavier
			choix = clavier.nextInt();
			
			
			switch(choix) {
				case 1: afficherMenagerie(maMenagerie);
					break;
				case 2: ajouterUnAnimal(maMenagerie);
					break;
				case 3: supprimerAnimal(maMenagerie);
					break;
				case 4: rechercherAnimal(maMenagerie);
					break;
				case 5: System.out.println("Fin de programme");
					break;
				default: System.out.println("Ce choix n'exte pas");
					break;	
			}
		}while(choix != 5);
		
		
	}
	
	//sous-programmes
	public static void afficherMenagerie(Menagerie uneMenagerie) {
		System.out.println(uneMenagerie.presenter());
	}
	
	
	//Ajouter un animal
	public static void ajouterUnAnimal(Menagerie uneMenagerie) {
		System.out.println("Choisir l'animal que vous voulez ajouter :");
		System.out.println("1 : Chien");
		System.out.println("2 : Chat");
	
		int choix1 = clavier.nextInt();
		
		switch(choix1) {
			case 1 : ajouterChien( uneMenagerie); 
				break;
			case 2 : ajouterChat(uneMenagerie);
				break; 
		}	
		
	}
	
	
	//ajouter un chien 
	public static void ajouterChien(Menagerie uneMenagerie) {
		 System.out.println("Quel est le nom de votre chien :");
		 String unNom = clavier.nextLine();
		 clavier.nextLine();
		 System.out.println("Quel est l'espèce de votre chien :");
		 String uneEspece = clavier.nextLine();
		 System.out.println("Quel est la race de votre chien :");
		 String uneRace = clavier.nextLine();
		 //on instancie un chien 
		 uneMenagerie.arriver(new Chien(unNom, uneEspece, uneRace));
	}
	
	//ajouter un chat
	public static void ajouterChat(Menagerie uneMenagerie) {
		System.out.println("Quel est le nom de votre chat :");
		 String unNom = clavier.nextLine();
		 clavier.nextLine();
		 System.out.println("Quel est l'espèce de votre chat :");
		 String uneEspece = clavier.nextLine();
		 System.out.println("Quel est la race de votre chat :");
		 String uneRace = clavier.nextLine();
		 //on ajoute un chien 
		 uneMenagerie.arriver(new Chat(unNom, uneEspece, uneRace));
	}
	
	
	
	//Supprimer un Animal
	public static void supprimerAnimal(Menagerie uneMenagerie) {
		System.out.println("Quel est le nom de votre animal à supprimer ?");
		int unIndex= clavier.nextInt();
		uneMenagerie.partir(unIndex);
	}
	
	//Rechercher un Animal
	public static void rechercherAnimal(Menagerie uneMenagerie) {
		System.out.println("Quel est le nom de votre rechercher ?");
		String unNom = clavier.nextLine();
		uneMenagerie.rechercheAnimal(unNom);
	}
	
	
}
