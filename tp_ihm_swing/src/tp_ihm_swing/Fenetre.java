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
		
		//Par d�faut la fen�tre est invisible, setVisible permet de rendre visible la fenetre
		this.setVisible(true);
		// Permet de donner un titre � la fen�tre
		this.setTitle("Ma premi�re fen�tre java");
		////Fermeture de la fen�tre lorsque l'on clique sur la croix et arr�t du programme
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//permet de d�terminer la taille de la fen�tre
		this.setSize(400, 300);
		//permet d'interdit le redimensionnement de la fen�tre
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
		//Texte � afficher :
		lblMessage = new JLabel ();
		//ajouter � l'interface
		monPanel.add(lblMessage, BorderLayout.CENTER);
		
		
		
		//3.JTextField
		
		//1.Nom 
		lblNom = new JLabel("Nom : ");
		jtfNom = new JTextField("Saisir votre nom");
		monPanel.add(jtfNom, BorderLayout.WEST);
		monPanel.add(lblNom, BorderLayout.WEST);
		
		//2.Pr�nom 
		lblPrenom = new JLabel("Pr�nom : ");
		jtfPrenom = new JTextField("Saisir votre pr�nom");
		monPanel.add(jtfPrenom, BorderLayout.EAST);
		monPanel.add(lblPrenom, BorderLayout.EAST);
		
		
		//3. Mail
		lblMail = new JLabel("Mail : ");
		jtfMail = new JTextField("Saisir votre pr�nom");
		monPanel.add(lblMail, BorderLayout.SOUTH);
		monPanel.add(jtfMail, BorderLayout.SOUTH);
		

		// Cr�ation d'un nouvel objet permettant de g�rer la police de caract�re
		Font police = new Font("Arial", Font.BOLD, 14);
		// D�finition de la police de caract�res � utiliser dans le champ de saisie
		jtfNom.setFont(police);
		// D�finition de la taille du champ de saisie
		jtfNom.setPreferredSize(new Dimension(150, 30));
		// D�finition de la couleur du texte
		jtfNom.setForeground(Color.BLUE);
		//in faut toujour rajouter add  � la fin de chaque composant
		monPanel.add(jtfNom);
		
		//4.JButton
		//I. Bouton Valider
		btnValider = new JButton("Valider");
		//on l'ajoute � l'action listener
		btnValider.addActionListener(new ActionBtnValider());
		//ajouter � l'interface  � une position sp�cifique
		monPanel.add(btnValider, BorderLayout.WEST);
		
		//II. Bouton Annuler
		btnAnnuler = new JButton("Annuler");
		//on l'ajoute � l'action listener
		btnAnnuler.addActionListener(new ActionBtnAnnuler());
		//ajouter � l'interface � une position sp�cifique
		monPanel.add(btnAnnuler, BorderLayout.EAST);
		
			
		//5. JComboBox
		// Liste d�roulante.
		String[] tab = {"Option 1", "Option 2", "Option 3", "option 4"};
		liste = new JComboBox(tab);
		//rajouter dans l'interface
		monPanel.add(liste);
		//on l'ajoute � l'action listener
		liste.addActionListener(new ActionListe());
		
		
		// On ajoute le JPanel au conteneur principal de notre fen�tre (obligatoire) � faire � la fin :
		this.getContentPane().add(monPanel);
		//Par d�faut la fen�tre est invisible. Toujours la derni�re instruction du constructeur
		this.setVisible(true);	
		
	}
	
	
	
	//Les classes d'�coute
	
	//m�thode par d�faut
	public void actionPerformed ( ActionEvent evenement ) {
		/*
		if ( evenement.getSource() == btnValider) { // Si la source de l'�v�nement est le JButton appel� btnValider
				lblMessage.setText("Vous avez valid� votre saisie ! ");
				monPanel.add(lblMessage);
		}else
				lblMessage.setText("Vous avez annul� votre saisie ...");
				monPanel.add(lblMessage);
	}
	*/
	}
	
	//La classe pour �couter la liste d'option
	class ActionListe implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("ActionListener : action sur " + liste.getSelectedItem());
		}
	}
	
	//La classe pour �couter le bouton valider
	class ActionBtnValider implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("Vous avez valid� votre saisie ! ");
			monPanel.add(lblMessage);
		}
	}
	
	//La classe pour �couter le bouton annuler
	class ActionBtnAnnuler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("Vous avez annul� votre saisie ...");
			monPanel.add(lblMessage);
		}
	}
}





