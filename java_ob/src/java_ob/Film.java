/**
 * 
 */
package java_ob;

/**
 * @author speen
 *
 */
public class Film {
	//Les attributs
		private String titre;
		private int anneeSortie;
		private int duree;
		private String genre;
		private int  nbFilms = 0;
			
			
		//Les constructeurs
		public Film() {
			
		}
		public void ajouterUnFilm(Film unFilm){
			this.sesFilms[this.nbFilms] = unFilm ;
			this.nbFilm += 1 ;
		}
		public void ajouterUnFilm(String unTitre, int uneAnneeSortie, int uneDuree, String unGenre){
			this.sesFilms[this.nbFilms] = new Film(unTitre, uneAnneSortie, uneDuree, unGenre) ;
			this.nbFilm += 1 ;
		}
		public Film rechercheUnfilm(int indice){
			return this.sesFilms[indice];
		}
		
		public boolean rechercheUnFilm(String unTitre){
			Boolean rFilm ;
			int i = 0 ;
			while (i < nbFilms && unTitre != this.sesFilms[unTitre] ){
				i++ ;
			}
			if (i < nbFilms){
				rFilm = true ;
			} else {
				rFilm = false ;
			}
			return rFilm;
		}
		
		public void supprimerUnFilm(int indice){
			for(int i = indice; i < (this.nbFilms - 1); i++) {
				this.sesFilm[i] = this.sesFilm[i +1];
				}
			this.nbFilms = this.nbFilms -1
		
		}
	
		
		public void supprimerUnFilm(Film unFilm){
		}
		
		public Film(String unTitre, int uneAnneeSortie, int uneDuree, String unGenre) {
			this.titre = unTitre;
			this.anneeSortie = uneAnneeSortie;
			this.duree = uneDuree;
			this.genre = unGenre;
		}

		
		//Les asseceurs
		
		public String getTitre() {
			return this.titre;
		}
		
		public void setTitre(String unTitre) {
			this.titre = unTitre;
		}
		
		public int getAnneeSortie() {
			return this.anneeSortie;
		}
		
		public void setAnneeSortie(int uneAnneeSortie) {
			this.anneeSortie = uneAnneeSortie;
		}
		
		public int getDuree() {
			return this.duree;
		}
		
		public void setDuree(int uneDuree) {
			this.duree = uneDuree;
		}
		
		public String getGenre() {
			return this.genre;
		}
		
		public void setGenre(String unGenre) {
			this.genre = unGenre;
		}
		

		//toString
		public String toString() {
			
			String affiche = " ";
			
			if (this.titre != null) {
				
				affiche = "Titre : " + this.titre + "\n";
			}
			
			if (this.anneeSortie != 0) {
				
				affiche +=  "Année de sortie  : " + this.anneeSortie + "\n";
			}
			
			if (this.duree != 0) {
				affiche += "durée de :" + this.duree + "\n";
			}
			if (this.genre != null) {
				affiche += "Genre :" + this.genre + "\n";
			}	
			
			return affiche;
	
		}
}
		
		
		
		

