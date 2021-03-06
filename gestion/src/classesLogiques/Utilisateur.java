package classesLogiques;


import java.util.ArrayList;

//Classe  pour gèrer la connexio net l'inscription 
public class Utilisateur {
	//Attributs d'instance
	private String adresseMail;
	private String motDePasse;
	private ArrayList<Utilisateur> listDesUtilisateur;
	
	//Le constructeur 
	public Utilisateur(String uneAdresseMail, String unMdp) {
		this.listDesUtilisateur = new ArrayList<Utilisateur>();
		this.adresseMail = uneAdresseMail; 
		this.motDePasse = unMdp; 
			
	}
	
	
	//les accesseurs
	public String getAdresseMail() {
		return adresseMail;
	}


	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	
	//Méthodes d'instances
	
	public int getNombreUtilisateur() {
		return this.listDesUtilisateur.size();
	}
		
	
	//Inscription utilisateur
	public boolean inscriptionUtilisateur(Utilisateur unUtilisateur) {
		boolean verifierAnimal = false;
		//vérifier si l'utilisateur existe  avant de l'ajouter
		if(!this.listDesUtilisateur.contains(unUtilisateur)) {
			//instancier un chat par transtypage ascendant car la classe animal est abstraite donc elle ne peut pas être instancier
			this.listDesUtilisateur.add(unUtilisateur);	
		}
				
		return verifierAnimal;
	}
	
	
	//Inscription utilisateur méthode de surcharge
	public boolean inscriptionUtilisateur(String adressMailUser, String motDePasseUser) {
			//Variables
			boolean verification= false;
			
			
			//vérifier que les paramètres ne sont pas vides
			if(adressMailUser != null & motDePasseUser != null ) {
				//vérifier si l'utilisateur a déja un compte pour se connecter
				if(!connexionUtilisateur(adressMailUser, motDePasseUser)) {
					//ajouter
					Utilisateur unUtilisateur = new Utilisateur(adressMailUser, motDePasseUser );
					this.listDesUtilisateur.add(unUtilisateur);
					verification = true;
				}
				
			}
			
			return verification;
			
	}
	
	
	//Connexion utilisateur
	public boolean connexionUtilisateur(String adressMail, String mdp) {
		//Variables locales
		boolean verificationSaisie= false;
		int index = -1;
		
		//vérifier que les paramètres ne sont pas vides
		if(adressMail != null & mdp != null ) {
			//chercher l'utilisateur par son adresse mail 
			index = this.rechercherUtilisateur(adressMail, mdp);
			if(index != -1) {
				verificationSaisie = true;
			}
			//vérifier la correspondances 
			
		}
		return verificationSaisie;
		
	}
	
	
	//rechercher utilisateur
	public boolean rechercherUtilisateur(Utilisateur unUtilisateur) {
		boolean rep = false;
			
		if (this.listDesUtilisateur.contains(unUtilisateur)){
			rep = true;
		}
			
		return rep;
	}
	
	
	//recherche utilisateur méthode de surcharge
	public int rechercherUtilisateur(String uneAdresseMail, String motPasse) {
		int rep = -1;
		int i = 0;
	
		
		if (this.listDesUtilisateur.size() != -1) {
			//parcourir la collection pour faire correpondre le saisie
			while(i < this.listDesUtilisateur.size() && this.listDesUtilisateur.get(i).getAdresseMail().equals(uneAdresseMail) && this.listDesUtilisateur.get(i).getMotDePasse().equals(motPasse)) {
				i++;
			}
						
			if (i < this.listDesUtilisateur.size()) {
				rep = i;	
			}
		}
					
		return rep;
		}
	
	//afficher
	@Override 
	public String toString() {
		String afficher = "\n Utilisateur : ";
			
		//vérifier que les propriétés d'instance ne sont pas null
		if (this.adresseMail != null & this.motDePasse != null) {
			afficher += "Adresse mail : " + this.adresseMail + "\n Nom : " + this.motDePasse + "\n";
		}	
		return afficher;
	}
	
	
	
	//méthode principal pour lancer l'app et faire des essaies
	public static void main(String[] args) {
		
		//instanciation un utilisateur
		Utilisateur unUser = new Utilisateur ("dieu@gmail.com", "123456");
		Utilisateur unAutreUser = new Utilisateur ("erwan@gmail.com", "123456");
		
		//ajouter les utilisateur 
		unUser.inscriptionUtilisateur(unUser);
		unUser.inscriptionUtilisateur(unAutreUser);
		
		boolean rl = unUser.connexionUtilisateur("dieu@gmail.com", "123456");
		
		
		
		//appel des méthodes 
		int rsl = unUser.rechercherUtilisateur("dieu@gmail.com", "123456");
		
	
		
		
		//Afficher
		
		System.out.println(unUser.getNombreUtilisateur());
		System.out.println(unUser.toString());
		System.out.println(rsl + "" + rl);
	}
	
}
