package java_ob;

public class Programme {

	public static void main(String[] args) {
		//Objets
		//instacier les films
		Film sonFilm = new Film("Intouchables", 2011, 113, "Comédie");
		Film sonAutreFilm = new Film("flex", 2020, 60, "action");
			
		//instancier les acteurs avec le constructeur
		Acteur unActeur = new Acteur  ("Omar", "Sy", 1978, "Francaise", sonFilm );
			
		//instancier avec le getter
		Acteur unAutreActeur = new Acteur ();
			
		unAutreActeur.setNom("jean");
		unAutreActeur.setPrenom("christophe");
		unAutreActeur.setAnneeNaiss(1980);
		unAutreActeur.setNationalite("Francaise");
		unAutreActeur.setSonFilm(sonAutreFilm);
		
			
		System.out.println(unActeur.toString());
		System.out.println(unAutreActeur.toString());			
			
	}

}
	
		
