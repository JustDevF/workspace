package tp_ihm_swing;


	import javax.swing.*;
	import java.awt.*;

	public class Fenetre1 extends JFrame{
		private JPanel monPanel ;
		private JLabel lblMessage;
		private JLabel lblNom;
		private JTextField jtfNom;
		private JButton btnValider;
		private JButton btnAnnuler;
		private JButton btnRouge;
		private JButton btnVert;
		private JButton btnBleu;
		private JButton btn;
	
		
		//constructeur 
		public Fenetre1() {
			//1. Configuration du structure 
			
			//Par d�faut la fen�tre est invisible, setVisible permet de rendre visible la fenetre 
			this.setVisible(true);
			// Permet de donner un titre � la fen�tre
			this.setTitle("Exercice 1");
			////Fermeture de la fen�tre lorsque l'on clique sur la croix et arr�t du programme
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//permet de d�terminer la taille de la fen�tre
			this.setSize(400, 300);
			//permet d'interdit le redimensionnement de la fen�tre
			this.setResizable(false);
			
			//2. Les contenus 
			
			// On instancie l'objet JPanel
			monPanel = new JPanel ( ) ;
			monPanel.setLayout(new BorderLayout());
			//monPanel.setLayout(new GridLayout(3, 2));
			//pr�ciser l'espacement entre les colonnes et entre les lignes
			//monPanel.setLayout(new GridLayout(3, 2,5,5));
			
			// D�finition de la couleur de fond du JPanel (par ex. Se r�f�rer � la javadoc pour les autres m�thodes)
			monPanel.setBackground(Color.red);
			
			//Texte � afficher :
			lblMessage = new JLabel ("Message � afficher ");
			//Il faut ensuite penser � ajouter le label dans le panel pour qu'il s'affiche !
			//monPanel.add(lblMessage);
			
			//champ de saisie utilisateur
			
			lblNom = new JLabel("Entrez votre nom : ");
			jtfNom = new JTextField("Valeur par d�faut");
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
			
			
			
			//ajouter des boutons 
			btnValider = new JButton("Valider");
			//ou Instanciation puis d�finition du texte gr�ce � la m�thode setText()
			btnAnnuler = new JButton();
			btnAnnuler.setText("Annuler");
			
			//ajouter les composants dans le contenu et sp�ficier les emplacements 
			/*
			monPanel.add(btnValider, BorderLayout.WEST);
			monPanel.add(btnAnnuler, BorderLayout.EAST);
			monPanel.add(lblMessage, BorderLayout.CENTER);
			*/
			
			//Exercice 1
			
			monPanel.add(btnValider, BorderLayout.EAST);
			monPanel.add(btnAnnuler, BorderLayout. WEST);
			monPanel.add(lblMessage, BorderLayout.CENTER);
			monPanel.setBackground(Color.yellow);
			
			
			//Exercice 2
			/*
			monPanel.add(btnValider, BorderLayout.EAST);
			monPanel.add(btnAnnuler, BorderLayout. WEST);
			monPanel.add(lblMessage, BorderLayout.CENTER);
			monPanel.setBackground(Color.yellow);
			*/
			
			
			//ajouter les boutons 
			//pr�ciser l'espacement entre les colonnes et entre les lignes
			/*
			monPanel.add(btnClic1);
			monPanel.add(btnClic2);
			monPanel.add(btnClic3);
			monPanel.add(btnClic4);
			monPanel.add(btnClic5);*/
			
			
			
			
			
			
			
			// On ajoute le JPanel au conteneur principal de notre fen�tre (obligatoire) � faire � la fin :
			this.getContentPane().add(monPanel);
			
			
			//Par d�faut la fen�tre est invisible. Toujours la derni�re instruction du constructeur
			this.setVisible(true);	
			
		}
		
		
	}

