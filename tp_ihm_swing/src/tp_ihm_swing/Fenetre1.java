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
			
			//Par défaut la fenêtre est invisible, setVisible permet de rendre visible la fenetre 
			this.setVisible(true);
			// Permet de donner un titre à la fenêtre
			this.setTitle("Exercice 1");
			////Fermeture de la fenêtre lorsque l'on clique sur la croix et arrêt du programme
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//permet de déterminer la taille de la fenêtre
			this.setSize(400, 300);
			//permet d'interdit le redimensionnement de la fenêtre
			this.setResizable(false);
			
			//2. Les contenus 
			
			// On instancie l'objet JPanel
			monPanel = new JPanel ( ) ;
			monPanel.setLayout(new BorderLayout());
			//monPanel.setLayout(new GridLayout(3, 2));
			//préciser l'espacement entre les colonnes et entre les lignes
			//monPanel.setLayout(new GridLayout(3, 2,5,5));
			
			// Définition de la couleur de fond du JPanel (par ex. Se référer à la javadoc pour les autres méthodes)
			monPanel.setBackground(Color.red);
			
			//Texte à afficher :
			lblMessage = new JLabel ("Message à afficher ");
			//Il faut ensuite penser à ajouter le label dans le panel pour qu'il s'affiche !
			//monPanel.add(lblMessage);
			
			//champ de saisie utilisateur
			
			lblNom = new JLabel("Entrez votre nom : ");
			jtfNom = new JTextField("Valeur par défaut");
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
			
			
			
			//ajouter des boutons 
			btnValider = new JButton("Valider");
			//ou Instanciation puis définition du texte grâce à la méthode setText()
			btnAnnuler = new JButton();
			btnAnnuler.setText("Annuler");
			
			//ajouter les composants dans le contenu et spéficier les emplacements 
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
			//préciser l'espacement entre les colonnes et entre les lignes
			/*
			monPanel.add(btnClic1);
			monPanel.add(btnClic2);
			monPanel.add(btnClic3);
			monPanel.add(btnClic4);
			monPanel.add(btnClic5);*/
			
			
			
			
			
			
			
			// On ajoute le JPanel au conteneur principal de notre fenêtre (obligatoire) à faire à la fin :
			this.getContentPane().add(monPanel);
			
			
			//Par défaut la fenêtre est invisible. Toujours la dernière instruction du constructeur
			this.setVisible(true);	
			
		}
		
		
	}

