package ihm_menagerie;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class RechercherAnimal extends JFrame implements ActionListener{
	/* --- ATTRIBUTS --- */
	private JPanel monPanel;
	private JLabel lblNom;
	private JPanel monPanel3;
	private JPanel monPanel2;
	private JLabel lblMessage;
	private JTextField jtfNom;
	private JLabel lblRace;
	private JTextField jtfRace;
	private JButton btnValider;
	private JButton btnRetour;
	
 public RechercherAnimal(Menagerie uneMenagerie) {
		
		this.setTitle("Recherche d'Animaux");
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		monPanel = new JPanel();
		monPanel3 = new JPanel();
		monPanel2 = new JPanel();
		
		lblMessage = new JLabel("Rechercher un Animal");
		
		lblNom = new JLabel("Nom :");
		jtfNom = new JTextField(16);
		lblRace = new JLabel("Espece :");
		jtfRace = new JTextField(16);
		
		btnValider = new JButton("OK");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				String race = jtfNom. getText();
				String nom = jtfRace. getText();
				int verif = uneMenagerie.verification(race, nom);
				if(verif !=404) {
					
					TrouverAnimal fenetre = new TrouverAnimal(uneMenagerie);
				}
				else {
					Erreur page = new Erreur(uneMenagerie);
				}
				
				
			}
		});
		btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				dispose();		
				Menu fenetre = new Menu(uneMenagerie);
			}
		});
		
		
		
		
		monPanel.add(lblMessage);
		monPanel2.add(lblNom);
		monPanel2.add(jtfNom);
		monPanel2.add(lblRace);
		monPanel2.add(jtfRace);
		monPanel3.add(btnValider);
		monPanel3.add(btnRetour);
		
		
		
		
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(monPanel);
		
		
		
		
		this.getContentPane().add(monPanel3);
		
		
		this.add(monPanel, BorderLayout.NORTH);
		this.add(monPanel2, BorderLayout.CENTER);
		this.add(monPanel3, BorderLayout.SOUTH);
		

		

		setVisible(true);
		
 	}
 	
	

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
		
}

}