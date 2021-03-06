package dialogue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import article.FArticles;
import client.PClients;
import commande.FCommandes;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;


public class FAccueil extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//Attribut d'instance graphique
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnVues;
	private JPanel panel_menu;
	private JLabel lbLTitre;
	private JLabel lblInfo;
	private JButton btnQuitter;
	private GroupLayout gl_panel_menu;
	private JPanel panel_principal;
	private JButton btnArticles;
	private JButton btnClients;
	private JButton btnCommandes;
	private JButton btnParametres;
	
	//Les attribut de classe d'actions
	private final Action actionArticle = new ActionArticles();
	private final Action actionClients = new ActionClients();
	private final Action actionCommandes = new ActionCommandes();
	private final Action actionParametres = new ActionParametres();
	private final Action actionQuitter = new ActionQuitter();
	

	/**
	 * Launch the application.
	 */
	//constructeur
	//Effacez la méthode main() de la classe pour éviter la prolifération de ces méthodes
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAccueil frame = new FAccueil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the frame.
	 */
	public FAccueil() {
		
		//Fenêtre
		setTitle("Accueil");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FAccueil.class.getResource("/images/accueil/Shopping-Bag-128.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 600);
		
		//Les menus
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Menu Fichier
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Menu Vues
		mnVues = new JMenu("Vues");
		mnVues.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnVues);
		
		//conteneur à l'ouest (gauche) du conteneur principal	
		panel_menu = new JPanel();
		panel_menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_menu.setBackground(SystemColor.controlShadow);
		panel_menu.setBounds(0, 0, 200, 300);
		contentPane.add(panel_menu, BorderLayout.WEST);
		GridBagLayout gbl_panel_menu = new GridBagLayout();
		gbl_panel_menu.columnWidths = new int[] {150};
		gbl_panel_menu.rowHeights = new int[] {50, 0, 50, 50};
		gbl_panel_menu.columnWeights = new double[]{};
		gbl_panel_menu.rowWeights = new double[]{};
		panel_menu.setLayout(gbl_panel_menu);
		
		//Nom de l'entrepris
		lbLTitre = new JLabel("ALL CONNECT IT");
		lbLTitre.setFont(new Font("Roboto Lt", Font.BOLD, 20));
		GridBagConstraints gbc_lbLTitre = new GridBagConstraints();
		gbc_lbLTitre.insets = new Insets(0, 0, 5, 0);
		gbc_lbLTitre.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbLTitre.gridx = 0;
		gbc_lbLTitre.gridy = 0;
		panel_menu.add(lbLTitre, gbc_lbLTitre);
		
		//Afficher les informations sur les options 
		lblInfo = new JLabel("Affichage Option");
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Roboto Lt", Font.PLAIN, 19));
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 1;
		panel_menu.add(lblInfo, gbc_lblInfo);
		
		//quitter le programme
		btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		btnQuitter.setAction(actionQuitter);
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.anchor = GridBagConstraints.SOUTH;
		gbc_btnQuitter.insets = new Insets(0, 0, 5, 0);
		gbc_btnQuitter.gridx = 0;
		gbc_btnQuitter.gridy = 2;
		panel_menu.add(btnQuitter, gbc_btnQuitter);
		
		//conteneur central 
		//GroupLayout
		gl_panel_menu = new GroupLayout(panel_menu);
		gl_panel_menu.setHorizontalGroup(
			gl_panel_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_menu.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInfo, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(btnQuitter, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
				.addComponent(lbLTitre, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
		);
		gl_panel_menu.setVerticalGroup(
			gl_panel_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_menu.createSequentialGroup()
					.addGap(7)
					.addComponent(lbLTitre)
					.addGap(30)
					.addComponent(lblInfo)
					.addGap(348)
					.addComponent(btnQuitter)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		panel_menu.setLayout(gl_panel_menu);
		
		//JPanel de menu central
		panel_principal = new JPanel();
		panel_principal.setBorder(new EmptyBorder(5, 0, 5, 5));
		contentPane.add(panel_principal, BorderLayout.CENTER);
		panel_principal.setLayout(new MigLayout("", "[33%][33%][33%]", "[33%][33%][33%]"));	
		
		//Menu Article 
		btnArticles = new JButton();
		btnArticles.setAction(actionArticle);
		btnArticles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblInfo.setText("Article");
			}
		});
		btnArticles.setIcon(new ImageIcon(FAccueil.class.getResource("/images/accueil/Product-128.png")));
		UI.deshabillerBouton(btnArticles, "accueil", "Product", 128);	
		btnArticles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));			
		panel_principal.add(btnArticles, "cell 1 0,alignx center");
		
		//Menu client
		btnClients = new JButton();
		btnClients.setAction(actionClients);
		//afficher le nom de l’action au survol du bouton par la souris
		btnClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				//afficher le texte dans le panneau de menu 
				lblInfo.setText("Clients");
			}
		});
		btnClients.setIcon(new ImageIcon(FAccueil.class.getResource("/images/accueil/People-128-actif.png")));
		UI.deshabillerBouton(btnClients, "accueil", "People", 128);
		btnClients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));		
		panel_principal.add(btnClients, "cell 0 1,alignx center");
		
		//Menu Stats
		JButton btnStats = new JButton("");
		btnStats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblInfo.setText("Statistiques");
			}
		});
		UI.deshabillerBouton(btnStats, "accueil", "Diagram", 128);
		btnStats.setIcon(new ImageIcon(FAccueil.class.getResource("/images/accueil/Diagram-128.png")));
		btnStats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));		
		panel_principal.add(btnStats, "cell 1 1,alignx center");
		
		
		//Menu commandes
		btnCommandes = new JButton("");
		btnCommandes.setAction(actionCommandes);
		btnCommandes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblInfo.setText("Commandes");
			}
		});
		UI.deshabillerBouton(btnCommandes, "accueil", "Shopping-Bag", 128);
		btnCommandes.setIcon(new ImageIcon(FAccueil.class.getResource("/images/accueil/Shopping-Bag-128.png")));
		btnCommandes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));			
		panel_principal.add(btnCommandes, "cell 2 1,alignx center");
		
		//Menu Paramètres
		btnParametres = new JButton ();
		btnParametres.setAction(actionParametres);
		btnParametres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblInfo.setText("Paramètres");
			}
		});
		btnParametres.setIcon(new ImageIcon(FAccueil.class.getResource("/images/accueil/Settings-02-128.png")));
		UI.deshabillerBouton(btnParametres, "accueil", "Settings-02", 128);
		btnParametres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_principal.add(btnParametres, "cell 1 2,alignx center");
	}
	
	//Gérez les actions depuis de menu 
	//Créez dans ces actions des accélérateurs et des mnémoniques raccourics clavier pour faciliter leur utilisation
	
	//Action articles
	private class ActionArticles extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionArticles() {
			putValue(NAME, "Articles");
			putValue(SHORT_DESCRIPTION, "Afficher la liste des articles");
			putValue(ACCELERATOR_KEY, 
                    KeyStroke.getKeyStroke( 
                        KeyEvent.VK_A, 
                        ActionEvent.ALT_MASK)); 
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
		}
		public void actionPerformed(ActionEvent e) {
			//méthode d'appel
			afficherArticles(); 
			
		}
	}
	
	//Action clients
	private class ActionClients extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionClients() {
			putValue(NAME, "Clients");
			putValue(SHORT_DESCRIPTION, "Afficher les clients");
		}
		public void actionPerformed(ActionEvent e) {
			 afficherClients();
		}
	}
	
	//Action commandes
	private class ActionCommandes extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionCommandes() {
			putValue(NAME, "Commandes");
			putValue(SHORT_DESCRIPTION, "Afficher les commandes");
		}
		public void actionPerformed(ActionEvent e) {
			afficheCommandes();
		}
	}
	
	//Action paramètres
	private class ActionParametres extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionParametres() {
			putValue(NAME, "Paramètres");
			putValue(SHORT_DESCRIPTION, "Afficher les paramètres");
		}
		public void actionPerformed(ActionEvent e) {
			afficherParametre();
		}
	}
	
	//Action quitter
	private class ActionQuitter extends AbstractAction {
		private static final long serialVersionUID = 1L;
			
		public ActionQuitter() {
			putValue(NAME, "Quitter");
			putValue(SHORT_DESCRIPTION, "Quitter l'application");
		}
		public void actionPerformed(ActionEvent e) {
			FAccueil.this.dispose();
			}
	}
	
	
	//méthodes d'instance servant méthodes d'appel des actions
	
	protected void afficherArticles() {
		// instancier une nouvelle fenêtre 
		FArticles laFenetre = new FArticles();
		//afficher la fenêtre FArticles
		laFenetre.setVisible(true);
		
	}

	protected void afficherClients() {
		JDialog FClients = new JDialog();
		PClients clients = new PClients();
		//créer une fenêtre pour l'instance du panneau PMenagerieAjouterChat
		
		//propriétés du fenêtre
		//ajouter le panneau au fenêtre
		clients.setFenetre(FClients);
		FClients.setContentPane(clients);
		//
		FClients.setIconImage(Toolkit.getDefaultToolkit().getImage(FAccueil.class.getResource("/images/accueil/Shopping-Bag-128.png")));
		FClients.setTitle("Gestion des Clients"); 
		FClients.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		FClients.setBounds(940, 600, 940, 600);
		FClients.setLocationRelativeTo(null); 
	    //afficher la fenêtre 
		FClients.setVisible(true); 
	    
		
	}
	

	protected void afficheCommandes() {
		// instancier une nouvelle fenêtre
		FCommandes laFenetre = new FCommandes();
		//afficher la fenêtre FCommandes
		laFenetre.setVisible(true);
		
	}
	
	protected void afficherParametre() {
		// TODO Auto-generated method stub
		
	}
}
