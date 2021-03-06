package connection;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//Connexion à la base de données
public class Connexion {
	//Constant pour la méthode rechercheClient / nombre fixe de colonne du tableau
	private static final int nbrColonne = 13;
	// Propriétés privés de connexion à la base de données
    private String urlDbase = "jdbc:mysql://localhost:3306/commandes?serverTimezone=UTC";
    private String user = "justin";
    private String password = "123456";
  
    
   //propriété de connexion
    public  Connection con = null;
    
    // constructeur
    public Connexion() {
    	//initialisation de la connexion à la base de données
    	try {
			this.con = DriverManager.getConnection(this.urlDbase, this.user, this.password);
			
			//Le chargement du pilote
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
   
    }
    
    
	//Méthode d'instance pour fermer la connexion
    public void fermerConnexion() {
		if (this.con != null ){
			try {
				this.con.close();
				this.con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      }
	}
	
    
	//Méthode permettant de connecter un utilisateur
	public boolean connexionUtilisateur(String adressMail, String mdp) {
		//Variables locales
		boolean verificationSaisie= false;
		String adressMailCorrect = "";
		String motDePasseCorrect = "";
		ResultSet resultat = null;
		
		
		//Utilisation de requêtes préparées
		//L'utilisation d'un objet de type PreparedStatement permet l'exécution répétée d'une même requête avec des paramètres différents
		
		//1. vérification de l'adresse email et de mot de passe
		try {
			PreparedStatement rechercheAdress = this.con.prepareStatement("SELECT*  FROM user WHERE email_address = ?");
			
			//vérifier que les paramètres ne sont pas vides
			if(adressMail != null & mdp != null ) {
				//lier le paramètre à la requête préparée
				rechercheAdress.setString(1, adressMail);
				resultat = rechercheAdress.executeQuery();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Requête préparée échouée");
		}
		
		//parcourir les résultats 
		try {
			//permet d'aller à la line suivante du résultat
		  boolean encore = resultat.next();
	      while (encore) {
	    	  //on récupères les données selon leur type getXX
	    	  
	    	  //récupération de l'adresss mail
	    	 adressMailCorrect = resultat.getString(4);
	    	 //récupération de mdp
	    	 motDePasseCorrect = resultat.getString(5);
	    	 encore = resultat.next();
	      }  
	      resultat.close();
	    } catch (SQLException e) {
	      System.out.println(e.getMessage());
	    }
		
		
		//comparer les résultats
	    if(adressMailCorrect.equals(adressMail) & motDePasseCorrect.equals(mdp)) {
 			verificationSaisie = true;
	    }
		return verificationSaisie;
		
	}
	
	
	//Méthode pour inscrire un utilisteur
	public boolean inscriptionUtilisateur(String nom, String prenom, String adressMailUser, String motDePasseUser) {
		//Variables
		boolean verification= false;
		double idUtilisateur = Math.random() * 100;
		String date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
		int resultat = 0;
		
		
		//Utilisation de requêtes préparées
		
		//requête préparée d'insertion à la base de données
		
		//vérifier si l'utilisateur existe déja dans la base de donnée

		if (this.connexionUtilisateur(adressMailUser, motDePasseUser)) {
			//System.out.println("Utilisateur existe déja dans la base de donnée");
		} else {
			//inscrire l'utilisateur
			//vérifier que les champs ne sont pas vides
			if (nom != null & prenom != null & adressMailUser != null  & motDePasseUser != null) {
				try {
					String rSql = "INSERT INTO user (user_id, first_name, last_name, email_address, password, register_date )";
					rSql += "VALUES(?, ?, ?, ?, ?, ?)";
		
					PreparedStatement ajoutUtilisateur = this.con.prepareStatement(rSql);
					
					//lier les paramètres à la requête préparée
					ajoutUtilisateur.setDouble(1, idUtilisateur);
					ajoutUtilisateur.setString(2, nom);
					ajoutUtilisateur.setString(3, prenom);
					ajoutUtilisateur.setString(4, adressMailUser);
					ajoutUtilisateur.setString(5, motDePasseUser);
					ajoutUtilisateur.setString(6, date);
					
					//exécuter la rqt
					resultat = ajoutUtilisateur.executeUpdate();
					
					if (resultat != 0) {
						verification = true;
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Requête préparée échouée");
				}
			}
			
		}
		
		return verification;
		
	}
	
	
	
	//Clients 
	
	//Méthode pour ajouter un client
	public boolean ajouterClient(String prenomClient, String nomClient, String adresseClient, String codePostalClient, String villeClient, String phoneFixeClient, String phoneMobileCient, String adressMailClient, String remarquesClient) { 
		//variables locales
		boolean verifierAjoutClient = false;
		double idClient = Math.random() * 100;
		String dateClient = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
		int resultat = 0;
		
		//vérifier que les champs ne sont aps vides 
		if(prenomClient != null & nomClient != null & adresseClient != null & codePostalClient != null & villeClient != null &  phoneFixeClient != null & phoneMobileCient != null & adressMailClient != null &  remarquesClient != null ) {
			//vérifier si client existe déja dans la base de donnée
			
			/*
			if(///à faire chercherClient(prenomClient, nomClient) ) {
				
			}
			*/
			//Utilisation de requêtes préparées
			try {
				String rSql = "INSERT INTO client (clientId, prenom, nom, adresse, codePostal,ville,phoneFixe, phoneMobile,adressMail,remarques,dateCreation)";
				rSql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
				PreparedStatement ajoutClient = this.con.prepareStatement(rSql);
				
				//lier les paramètres à la requête préparée
				ajoutClient.setDouble(1, idClient);
				//ajoutClient.setDouble(2, idUserClient); //a revoir
				ajoutClient.setString(2, prenomClient);
				ajoutClient.setString(3, nomClient);
				ajoutClient.setString(4, adresseClient);
				ajoutClient.setString(5, codePostalClient);
				ajoutClient.setString(6, villeClient);
				ajoutClient.setString(7, phoneFixeClient);
				ajoutClient.setString(8, phoneMobileCient);
				ajoutClient.setString(9, adressMailClient);
				ajoutClient.setString(10, remarquesClient);
				ajoutClient.setString(11, dateClient);
				
				//exécuter la rqt
				resultat = ajoutClient.executeUpdate();
				
				if (resultat != 0) {
					verifierAjoutClient = true;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Requête préparée échouée");
			}
			
		}
		
		
	       return verifierAjoutClient;
    }
	

	
	//Méthode pour chercher un client
	public String[] chercherClient(String prenomClient, String nomClient, String adressMailClient) { 
		//Variables locales
		String[] tabInfoClient = new String[nbrColonne];
		ResultSet resultat = null;
		
		//Utilisation de requêtes préparées
		
		////vérifier que les paramètres ne sont pas vides
		if(prenomClient != null & nomClient != null &  adressMailClient != null) {
			//requête preparée
			//1. vérification de prenom, nom et de l'adresse mail
			try {
				PreparedStatement chercheClient = this.con.prepareStatement("SELECT*  FROM client WHERE adressMail = ?");
				//lier le paramètre à la requête préparée
				chercheClient.setString(1, adressMailClient);
				//exécuter la rqt
				resultat = chercheClient.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//parcourir les résultats 
			try {
			  ResultSetMetaData rsmd = (ResultSetMetaData) resultat.getMetaData();
			  int nbCols = rsmd.getColumnCount();
			  boolean encore = resultat.next();
			  //boucle 
		      while (encore) {
		    	  //boucle
		    	  for (int i = 1; i <= nbCols; i++)
		    	  //on récupères les données selon leur type getXX et leur colonne sur le table dans le tableau  / le type non string afficheront null
		    		  tabInfoClient[i] = resultat.getString(i);	  
		    	 encore = resultat.next();
		      }  
		      resultat.close();
		    } catch (SQLException e) {
		      System.out.println(e.getMessage());
		    }
		}
		return tabInfoClient;
    }
	
	//Surcharge méthode de recherche
	//Méthode pour chercher un client données pour JTable dans un tableau 2D
	public Object[][] chercherClient(String prenomClient, String nomClient, String adressMailClient, String telMobile) throws SQLException { 
			//Variables locales
			ResultSet resultat = null;
			Object[][] data = new Object[1][12];
		
				 
			//Utilisation de requêtes préparées
			
			////vérifier que les paramètres ne sont pas vides
			if(prenomClient != null & nomClient != null &  adressMailClient != null & telMobile != null) {
				//requête preparée
				//1. vérification de prenom, nom et de l'adresse mail
				try {
					PreparedStatement chercheClient = this.con.prepareStatement("SELECT*  FROM client WHERE adressMail = ?");
					//lier le paramètre à la requête préparée
					chercheClient.setString(1, adressMailClient);
					//exécuter la rqt
					resultat = chercheClient.executeQuery();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				//parcourir les résultats
				try {      
					 boolean encore = resultat.next();
					 //ResultSetMetaData rsmd = (ResultSetMetaData) resultat.getMetaData();
					 //int nbCols = rsmd.getColumnCount();
					  
					 //boucle
					 while(encore) {
						//initialiser l'objet tableau de deux dimension
						data[0][0] =  resultat.getInt(1);
						data[0][1] =  resultat.getInt(2);
						data[0][2] =  resultat.getString(3);
						data[0][3] =  resultat.getString(4);
						data[0][4] =  resultat.getString(5);
						data[0][5] =  resultat.getString(6);
						data[0][6] =  resultat.getString(7);
						data[0][7] =  resultat.getString(8);
						data[0][8] =  resultat.getString(9);
						data[0][9] =  resultat.getString(10);
						data[0][10] =  resultat.getString(11);
						encore = resultat.next();
					}
					 resultat.close();
					 
					}catch(SQLException e) {
						e.printStackTrace();
					}			
			} else {
				System.out.println("Les champs non validés");
			}
			
			return data;
	    }	
	
	
	//Surcharge de la méthode chercher un client
	//Méthode pour chercher un client
	
	//surcharge chercherClient boolean
	public boolean chercherClient(String nomClient, String adressMailClient) { 
		//Variables locales
		boolean verificationClient = false;
		String nomCorrect = "";
		String adressMailCorrect = "";
		ResultSet resultat = null;
		
		//Utilisation de requêtes préparées
		
		////vérifier que les paramètres ne sont pas vides
		if(nomClient != null &  adressMailClient != null) {
			//requête preparée
			//1. vérification de nom et de l'adresse mail
			try {
				PreparedStatement chercheClient = this.con.prepareStatement("SELECT*  FROM client WHERE adressMail = ?");
				//lier le paramètre à la requête préparée
				chercheClient.setString(1, adressMailClient);
				//exécuter la rqt
				resultat = chercheClient.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("requête échouée");
			}
			
			//parcourir les résultats 
			try {
			  boolean encore = resultat.next();
			  //boucle 
		      while (encore) {
		    	  //récupération de nom
		    	  nomCorrect = resultat.getString(4);
		    	 //récupération de mdp
		    	  adressMailCorrect = resultat.getString(10);
		    	 encore = resultat.next(); 
		      }  
		      resultat.close();
		    } catch (SQLException e) {
		      System.out.println(e.getMessage());
		    }		
		}
		//comparer les résultats
	    if(nomCorrect.equals(nomClient) & adressMailCorrect.equals(adressMailClient)) {
	    	verificationClient = true;
	    }else {
	    	//System.out.println("Nom et adresse mail introuvables");
	    }
	   
		return verificationClient;
    }
	
	
	//Méthode modifier un client
	
	//Méthode pour modifier les informations de client
	public boolean modifierClient(String prenomClient, String nomClient, String adresseClient, String codePostalClient, String villeClient, String phoneFixeClient, String phoneMobileCient, String adressMailClient) { 
		//variables locales
		boolean verifierModifier = false;
		int resultat = 0;
		
		//vérifier si les champs ne sont pas nulls
		if(prenomClient != null & nomClient != null & adresseClient != null & codePostalClient != null & villeClient != null &  phoneFixeClient != null & phoneMobileCient != null & adressMailClient != null) {
			//vérifier si le client existe déja
			if(this.chercherClient(nomClient, adressMailClient)) {
				////requête sql prépérée de mise à jour
				try {
					String rSql = "UPDATE client SET prenom=?, nom=?, adresse=?, codePostal=?, ville=?, phoneFixe=?, phoneMobile=?, adressMail=? ";
		
					PreparedStatement ModifierClient = this.con.prepareStatement(rSql);
					
					//lier les paramètres à la requête préparée
					ModifierClient.setString(1, prenomClient);
					ModifierClient.setString(2, nomClient);
					ModifierClient.setString(3, adresseClient);
					ModifierClient.setString(4, codePostalClient);
					ModifierClient.setString(5, villeClient);
					ModifierClient.setString(6, phoneFixeClient);
					ModifierClient.setString(7, phoneMobileCient);
					ModifierClient.setString(8, adressMailClient);
				
					
					//exécuter la rqt
					resultat = ModifierClient.executeUpdate();
					
					if (resultat != 0) {
						verifierModifier = true;
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Requête préparée échouée");
				}
			}
			
			
			
		}
		
		
		
	    return verifierModifier;
    }
	
	
	//Surcharge de la méthode modifier
	
	//Surcharge méthode pour modifier les informations de client
	public boolean modifierClient(String prenomClient, String nomClient, String adresseClient, String adressMailClient) { 
		//variables locales
		boolean verifierModifier = false;
		int resultat = 0;
		
		//vérifier si les champs ne sont pas nulls
		if(prenomClient != null & nomClient != null & adresseClient != null & adressMailClient != null) {
			//vérifier si le client existe déja
			if(this.chercherClient(nomClient, adressMailClient)) {
				////requête sql prépérée de mise à jour
				try {
					String rSql = "UPDATE client SET prenom=?, nom=?, adresse=?, adressMail=? ";
		
					PreparedStatement ModifierClient = this.con.prepareStatement(rSql);
					
					//lier les paramètres à la requête préparée
					ModifierClient.setString(1, prenomClient);
					ModifierClient.setString(2, nomClient);
					ModifierClient.setString(3, adresseClient);
					ModifierClient.setString(4, adressMailClient);
				
					
					//exécuter la rqt
					resultat = ModifierClient.executeUpdate();
					
					if (resultat != 0) {
						verifierModifier = true;
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Requête préparée échouée");
				}
			}
			
			
			
		}
		
		
		
	    return verifierModifier;
    }
	
	
	//Méthode pour supprimer un client
	public void supprimerClient() { 
		
	       
    }
	
	
	//méthode principal pour lancer l'app et faire des essaies
		/*
		public static void main(String[] args) {
			Connexion con = new Connexion();
			//String[] resultRecherche = new String[13];
			//boolean resultat = con.ajouterClient("dieu", "etshumba", "19 rue", "7745", "kinshasa", "014756", "09455", "dieu@gmail.com", "bon gars");
			
			//resultRecherche = con.chercherClient("dieu", "etshumba", "dieu@gmail.com");
			
			//boucle pour afficher
			/*
			for (int i=0; i<13; i++) {
				System.out.println("Recherche client  :" + " " + resultRecherche[i]);
			}
			*/
			/*
			
			boolean resultRecherche = false;
			
			resultRecherche = con.chercherClient("etshumba", "dieu@gmail.com");
			System.out.println("Trouver" + " " + resultRecherche );
			
			*/
			/*
			boolean modifierClient = con.modifierClient("dieu", "etshumba", "Rue modifié","7745", "paris","014756","09455", "dieu@gmail.com");
			
			
			System.out.println("Client modifié" + " " + modifierClient);
			*/
			
			/*
			Object[][] data = new Object[1][11];
			
			try {
				data = con.chercherClient("dieu", "etshumba", "dieu@gmail.com", "09455");
				
				for (int i = 0; i < 11; i++) {
					System.out.println(data[0][i]);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			/*
			
		}
       */
		
		
}

