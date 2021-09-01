package tp_ihm_swing;

public class Chat extends Animal {
	private String race;
	
	//constructeur 
	public Chat(String unNom, String uneEspece, String uneRace) {
		super(unNom,uneEspece);
		this.race = uneRace;
	}
	
	//acesseurs 
	public void setRace(String uneRace) {
		this.race = uneRace;
	}
	
	public String getRace() {
		return this.race;
	}
	
	public String sePresenter() {
		return "Je suis un : " + super.sePresenter() + this.race;
	}
}
