/**
 * 
 */
package tp_ihm_swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;
import java.awt.event.ActionEvent;

public class Fenetre extends JFrame implements ActionListener{
	private JPanel monPanel;
	private JPanel monPanel2;
	private JLabel lblMessage;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblMail;
	private JTextField jtfPrenom;
	private JTextField jtfNom;
	private JTextField jtfMail;
	private JButton btnValider;
	private JButton btnAnnuler;
	private JComboBox liste;
	
	
	//constructeur
	public Fenetre() {
		//1. Configuration du structure
		
		//Par défaut la fenêtre est invisible, setVisible permet de rendre visible la fenetre
		this.setVisible(true);
		// Permet de donner un titre à la fenêtre
		this.setTitle("Ma première fenêtre java");
		////Fermeture de la fenêtre lorsque l'on clique sur la croix et arrêt du programme
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//permet de déterminer la taille de la fenêtre
		this.setSize(400, 300);
		//permet d'interdit le redimensionnement de la fenêtre
		this.setResizable(true);
		//.....................................................................//
		
		//2. Les contenus
		
		// 1. JPanel
		monPanel = new JPanel ();
		monPanel.setLayout(new FlowLayout());
		monPanel.setBackground(Color.gray);
		monPanel.setLocation(150, 100);
		monPanel.setSize(300, 200);
		
		monPanel2 = new JPanel();
		monPanel2.setLayout(new FlowLayout());
		monPanel.setBackground(Color.gray);
		monPanel.setLocation(150, 100);
		monPanel.setSize(300, 200);
		
		
		
		
		//2.JLabel
		//Texte à afficher :
		lblMessage = new JLabel ();
		//ajouter à l'interface
		monPanel.add(lblMessage, BorderLayout.CENTER);
		
		
		
		//3.JTextField
		
		//1.Nom 
		lblNom = new JLabel("Nom : ");
		jtfNom = new JTextField("Saisir votre nom");
		monPanel.add(jtfNom, BorderLayout.WEST);
		monPanel.add(lblNom, BorderLayout.WEST);
		
		//2.Prénom 
		lblPrenom = new JLabel("Prénom : ");
		jtfPrenom = new JTextField("Saisir votre prénom");
		monPanel.add(jtfPrenom, BorderLayout.EAST);
		monPanel.add(lblPrenom, BorderLayout.EAST);
		
		
		//3. Mail
		lblMail = new JLabel("Mail : ");
		jtfMail = new JTextField("Saisir votre prénom");
		monPanel.add(lblMail, BorderLayout.SOUTH);
		monPanel.add(jtfMail, BorderLayout.SOUTH);
		

		// Création d'un nouvel objet permettant de gérer la police de caractère
		Font police = new Font("Arial", Font.BOLD, 14);
		// Définition de la police de caractères à utiliser dans le champ de saisie
		jtfNom.setFont(police);
		// Définition de la taille du champ de saisie
		jtfNom.setPreferredSize(new Dimension(150, 30));
		// Définition de la couleur du texte
		jtfNom.setForeground(Color.BLUE);
		//in faut toujour rajouter add  à la fin de chaque composant
		monPanel.add(jtfNom);
		
		//4.JButton
		//I. Bouton Valider
		btnValider = new JButton("Valider");
		//on l'ajoute à l'action listener
		btnValider.addActionListener(new ActionBtnValider());
		//ajouter à l'interface  à une position spécifique
		monPanel.add(btnValider, BorderLayout.WEST);
		
		//II. Bouton Annuler
		btnAnnuler = new JButton("Annuler");
		//on l'ajoute à l'action listener
		btnAnnuler.addActionListener(new ActionBtnAnnuler());
		//ajouter à l'interface à une position spécifique
		monPanel.add(btnAnnuler, BorderLayout.EAST);
		
			
		//5. JComboBox
		// Liste déroulante.
		String[] tab = {"Option 1", "Option 2", "Option 3", "option 4"};
		liste = new JComboBox(tab);
		//rajouter dans l'interface
		monPanel.add(liste);
		//on l'ajoute à l'action listener
		liste.addActionListener(new ActionListe());
		
		
		// On ajoute le JPanel au conteneur principal de notre fenêtre (obligatoire) à faire à la fin :
		this.getContentPane().add(monPanel);
		//Par défaut la fenêtre est invisible. Toujours la dernière instruction du constructeur
		this.setVisible(true);	
		
	}
	
	
	
	//Les classes d'écoute
	
	//méthode par défaut
	public void actionPerformed ( ActionEvent evenement ) {
		/*
		if ( evenement.getSource() == btnValider) { // Si la source de l'évènement est le JButton appelé btnValider
				lblMessage.setText("Vous avez validé votre saisie ! ");
				monPanel.add(lblMessage);
		}else
				lblMessage.setText("Vous avez annulé votre saisie ...");
				monPanel.add(lblMessage);
	}
	*/
	}
	
	//La classe pour écouter la liste d'option
	class ActionListe implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("ActionListener : action sur " + liste.getSelectedItem());
		}
	}
	
	//La classe pour écouter le bouton valider
	class ActionBtnValider implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("Vous avez validé votre saisie ! ");
			monPanel.add(lblMessage);
		}
	}
	
	//La classe pour écouter le bouton annuler
	class ActionBtnAnnuler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("Vous avez annulé votre saisie ...");
			monPanel.add(lblMessage);
		}
	}
}





