package fenetresGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class PremiereFenetre extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//attribut de type JPanel(objet)//conteneur
	private JPanel contentPane;
	//attribut de type JtexteField(objet) / composant
	private JTextField textField;
	////attribut de type JMenuBar(objet) / composant menu
	private JMenuBar menuBar;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremiereFenetre frame = new PremiereFenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//constructeur
	public PremiereFenetre() {
		//utilialiser les attributs du conteneur JFrame / modifier les informations du fenêtre
		setTitle("1ére fenêtre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PremiereFenetre.class.getResource("/PriseEnMain/graphrique/image30x30.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 328);
		
		//Le conteneur JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Les composants
		//JButton
		JButton btnValider = new JButton("btnValider");
		//Fonction gestionaire d'évènement 
		//prend en param l'écouteur d'action
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Quand l’utilisateur clique btnValider, le code dans  actionPerformed est exécuté
				JOptionPane.showMessageDialog(btnValider,"Vous avez saisi \"" + textField.getText() +"\"");

			}
		});
		btnValider.setBounds(164, 145, 106, 23);
		//ajouter le composant au conteneur
		contentPane.add(btnValider);
		
		//JTextField / champs de saisie
		textField = new JTextField();
		textField.setBounds(115, 114, 198, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//JLabel //affichage texte / image
		JLabel lblNewLabel = new JLabel("Saisir un message ");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblNewLabel.setBounds(134, 75, 166, 25);
		contentPane.add(lblNewLabel);
		
		//JMenuBar / La navigations 
		menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 101, 22);
		contentPane.add(menuBar);
		
		//JMenu / les menus
		//Menu 1 
		JMenu menuFichier = new JMenu("Fichier");
		menuBar.add(menuFichier);
		
		//JMenuItem / les items de menu
		JMenuItem menuItemQuitter = new JMenuItem("Quitter");
		menuItemQuitter.setAction(action);
		menuFichier.add(menuItemQuitter);
		
		//Menu 2
		JMenu menuClient= new JMenu("Client");
		menuBar.add(menuClient);
		
		//le sous menu
		JMenu sousMenuGestion = new JMenu("Gestion");
		menuClient.add(sousMenuGestion);
		
		//Les items de menu
		JMenuItem menuItemAjouter = new JMenuItem("Ajouter");
		sousMenuGestion.add(menuItemAjouter);
		
		JMenuItem menuItemRechercher = new JMenuItem("Rechercher");
		sousMenuGestion.add(menuItemRechercher);
		
		JMenuItem menuItemModifier = new JMenuItem("Modifier");
		sousMenuGestion.add(menuItemModifier);
		
		//Ajouter un séparateur
		JSeparator separator = new JSeparator();
		sousMenuGestion.add(separator);
		
		JMenuItem menuItemSupprimer = new JMenuItem("Supprimer");
		sousMenuGestion.add(menuItemSupprimer);
	}
	
	//La classe SwingAction héritante de la classe AbstractAction (il s’agit d’un nom généré automatiquement), qui dérive du type AbstractAction
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "Quitter");
			putValue(SHORT_DESCRIPTION, "Quitter l'application");
			//introduire des raccourcis-clavier 
			//raccourics Ctr
			putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_DOWN_MASK));
		}
		public void actionPerformed(ActionEvent e) {
			//Quand l’utilisateur clique sur l’item Quitter, le code de la méthode actionPerformed est exécuté.
			//dispose permet de quitter le programme java 
			dispose();
		}
		
	}
}
