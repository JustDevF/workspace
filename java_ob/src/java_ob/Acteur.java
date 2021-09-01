/**
 * 
 */
package java_ob;

/**
 * @author speen
 *
 */
public class Acteur {
	//Les attributs
		private String nom;
		private String prenom;
		private int anneeNaiss;
		private String nationalite;
		private Film sonFilm;
		
		
		
		//Les constructeurs0
		public Acteur() {
			this.sonFilm = new Film();
		}
		public Acteur(String unNom, String unPrenom, int unAnneeNaiss, String unNationalite, Film unFilm) {
			this.nom = unNom;
			this.prenom = unPrenom;
			this.anneeNaiss = unAnneeNaiss;
			this.nationalite = unNationalite;
			this.sonFilm = unFilm;
		}
		
		
		//Les asseceurs
		
		public String getNom() {
			return this.nom;
		}
		
		public void setNom(String unNom) {
			this.nom = unNom;
		}
		
		
		public String getPrenom() {
			return this.prenom;
		}
		
		public void setPrenom(String unPrenom) {
			this.prenom = unPrenom;
		}
		
		
		public int getAnneeNaiss() {
			return this.anneeNaiss;
		}
		
		public void setAnneeNaiss(int unAnneeNaiss) {
			this.anneeNaiss = unAnneeNaiss;
		}
		
		public String getNationalite() {
			return this.nationalite;
		}
		
		public void setNationalite(String unNationalite) {
			this.nationalite = unNationalite;
		}
		
		
		
		
		
		
		
		//toString
		public String toString() {
			String affiche = " ";
			
			affiche += "---------------------------------" ;
			if (this.nom != null) {
				
				affiche = "\t" + "Nom : " + this.nom + "\n";
			}
			
			if (this.prenom != null) {
				
				affiche +=  "Prénom : " + this.prenom + "\n";
			}
			
			if (this.anneeNaiss != 0) {
				affiche += "Année de naissance :" + this.anneeNaiss + "\n";
			}
			if (this.nationalite != null) {
				affiche += "Nationalité :" + this.nationalite+ "\n";
			}
			affiche += "---------------------------------" ;
			affiche += "\n" ;
			if (this.sonFilm != null) {
				affiche += "Film  :" + this.sonFilm.toString()+ "\n";
			}
			
			
			return affiche;
		}	
		
}

