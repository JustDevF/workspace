package controle.connexion;

import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

//Classe connexion permettant d'accéder et de manipuler la base de données
public class Connexion {
	/*
	 * PROPRIETES **********
	 */
	private final EntityManagerFactory fabrique;

	// CONSTRUCTEUR
	// ************
	Connexion(String unite) {
		this(Persistence.createEntityManagerFactory(unite));
	}

	protected Connexion(EntityManagerFactory factory) {
		fabrique = factory;
	}

	private static final class ConnexionHolder {
		private static final Connexion connexion
		= new Connexion("eni-acces");		
	}
	
	public static Connexion getConnexion() {
		return ConnexionHolder.connexion;
	}

	/*
	 * METHODES ********
	 */
	// -------------------
	public boolean controle(String nom, String motDePasse) {
		boolean verificationSaisie = false;
		EntityManager gerant = fabrique.createEntityManager();
		Object nomUtilisateurCorrect = gerant.getProperties().get(
				"javax.persistence.jdbc.user");
		Object motDePasseCorrect = gerant.getProperties().get(
				"javax.persistence.jdbc.password");
		verificationSaisie = nom.equals(nomUtilisateurCorrect)
				&& motDePasse.equals(motDePasseCorrect);
		gerant.close();
		return verificationSaisie;
	}

	public void fermeture() {
		fabrique.close();
	}

	public <R> R chercher(Function<EntityManager, R> fonction) {
		EntityManager gerant = fabrique.createEntityManager();
		try {
			R resultat = fonction.apply(gerant);
			return resultat;
		} finally {
			gerant.close();
		}
	}

	public <R> R modifier(Function<EntityManager, R> fonction) {
		EntityManager gerant = fabrique.createEntityManager();
		EntityTransaction transaction = gerant.getTransaction();
		try {
			transaction.begin();

			R resultat = fonction.apply(gerant);

			transaction.commit();
			
			return resultat;
			
		} catch (RuntimeException e) {
			
			transaction.rollback();
			
			throw e;
			
		} finally {
			gerant.close();
		}
	}
	
	
}
