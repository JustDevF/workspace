package article;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import client.PClients;
import dialogue.UI;

import java.awt.Toolkit;

//création d'une fenêtre JFrame
public class FArticles extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//Attribut d'instance graphique
	private JPanel contentPane;
	private JPanel panel_menu;
	private JLabel lblTitre;
	private JButton btnApercu;
	private JButton btnImprimer;
	private JButton btnExport;
	private JButton btnAccueil;
	private JPanel panel_principal;
	private JPanel panel_formulaire;
	private JLabel lblCode;
	private JTextField txtCode;
	private JLabel lblCategorie;
	private JTextField txtCategorie;
	private JLabel lblDesignation;
	private JTextField txtDesignation;
	private JLabel lblQuantite;
	private JSlider sliderQuantite;
	private JTextField txtQuantite;
	private JLabel lblPrixUnitaire;
	private JFormattedTextField txtPrixUnitaire;
	private JLabel lblMoney;
	private JToolBar toolBar;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnAnnuler;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel lblTri; 
	private JRadioButton rdbtnCode;
	private JRadioButton rdbtnCategorie;
	private JLabel lblRecherche;
	private JTextField txtRecherche;
	
	

	/**
	 * lancer d'application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FArticles frame = new FArticles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Création d'une fenêtre JFrame
	 */
	//consctructeur
	public FArticles() {
		//propriétes de la fenêtre
		setTitle("Gestion des articles");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FArticles.class.getResource("/images/accueil/Product-128-actif.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 540);
		
		//propriétes du panneau principal
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0x99, 0xCC, 0x00));
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Panneau menu situé à gauche du panneau principal
		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(0x66, 0x99, 0x00));
		contentPane.add(panel_menu, BorderLayout.WEST);
		panel_menu.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5,
				5)));
		GridBagLayout gbl_panel_menu = new GridBagLayout();
		gbl_panel_menu.columnWidths = new int[] { 0, 0 };
		gbl_panel_menu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_menu.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_menu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_menu.setLayout(gbl_panel_menu);
		
		//titre du panneau
		lblTitre = new JLabel("Articles");
		lblTitre.setIcon(new ImageIcon(FArticles.class
				.getResource("/images/gestion/article/Product-64-actif.png")));
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.insets = new Insets(0, 0, 15, 20);
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
		panel_menu.add(lblTitre, gbc_lblTitre);
		lblTitre.setFont(new Font("Roboto Lt", Font.BOLD, 25));
		
		//Les actions possibles 
		
		//action apercu
		btnApercu = new JButton("Apercu");
		btnApercu.setFont(new Font("Roboto Lt", Font.BOLD, 15));
		btnApercu.setForeground(Color.BLACK);
		btnApercu.setHorizontalAlignment(SwingConstants.LEFT);
		btnApercu.setIcon(new ImageIcon(FArticles.class
				.getResource("/images/gestion/Preview-48.png")));
		GridBagConstraints gbc_btnApercu = new GridBagConstraints();
		gbc_btnApercu.weighty = 1.0;
		gbc_btnApercu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnApercu.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnApercu.insets = new Insets(0, 0, 5, 0);
		gbc_btnApercu.gridx = 0;
		gbc_btnApercu.gridy = 5;
		btnApercu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_menu.add(btnApercu, gbc_btnApercu);
		UI.deshabillerBouton(btnApercu, "Preview");
		
		//Action imprimer
		btnImprimer = new JButton("Imprimer");
		btnImprimer.setFont(new Font("Roboto Lt", Font.BOLD, 15));
		btnImprimer.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnImprimer = new GridBagConstraints();
		gbc_btnImprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimer.anchor = GridBagConstraints.LINE_START;
		gbc_btnImprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnImprimer.gridx = 0;
		gbc_btnImprimer.gridy = 6;
		btnImprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_menu.add(btnImprimer, gbc_btnImprimer);
		UI.deshabillerBouton(btnImprimer, "Printer");
		
		//Action exporter
		btnExport = new JButton("Export");
		btnExport.setFont(new Font("Roboto Lt", Font.BOLD, 15));
		btnExport.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExport.anchor = GridBagConstraints.LINE_START;
		gbc_btnExport.insets = new Insets(0, 0, 5, 0);
		gbc_btnExport.gridx = 0;
		gbc_btnExport.gridy = 7;
		btnExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_menu.add(btnExport, gbc_btnExport);
		UI.deshabillerBouton(btnExport, "Data-Export");
		
		//Action accueil
		btnAccueil = new JButton("Accueil");
		btnAccueil.setFont(new Font("Roboto Lt", Font.BOLD, 15));
		//btnAccueil.setAction(actionAccueil);
		btnAccueil.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnAccueil = new GridBagConstraints();
		gbc_btnAccueil.weighty = 1.0;
		gbc_btnAccueil.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnAccueil.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAccueil.gridx = 0;
		gbc_btnAccueil.gridy = 8;
		btnAccueil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_menu.add(btnAccueil, gbc_btnAccueil);
		UI.deshabillerBouton(btnAccueil, "Home");
		
		//Panneau central au centre du panneau principal
		panel_principal = new JPanel();
		panel_principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_principal.setBackground(new Color(0xE2, 0xF0, 0xB6));
		contentPane.add(panel_principal, BorderLayout.CENTER);
		GridBagLayout gbl_panel_principal = new GridBagLayout();
		gbl_panel_principal.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_principal.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_principal.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0 };
		gbl_panel_principal.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		panel_principal.setLayout(gbl_panel_principal);
		
		//Panneau formulaire en haut du panneau centrale
		panel_formulaire = new JPanel();
		panel_formulaire.setOpaque(false);
		panel_formulaire.setBorder(new CompoundBorder(new LineBorder(new Color(
				0, 0, 0), 2, true), new EmptyBorder(5, 5, 5, 5)));
		GridBagConstraints gbc_panel_formulaire = new GridBagConstraints();
		gbc_panel_formulaire.weightx = 1.0;
		gbc_panel_formulaire.fill = GridBagConstraints.BOTH;
		gbc_panel_formulaire.insets = new Insets(0, 0, 5, 0);
		gbc_panel_formulaire.gridwidth = 5;
		gbc_panel_formulaire.gridx = 0;
		gbc_panel_formulaire.gridy = 0;
		panel_principal.add(panel_formulaire, gbc_panel_formulaire);
		GridBagLayout gbl_panel_formulaire = new GridBagLayout();
		gbl_panel_formulaire.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_formulaire.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_formulaire.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0,
				1.0, 0.0 };
		gbl_panel_formulaire.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				1.0 };
		panel_formulaire.setLayout(gbl_panel_formulaire);

		//champs code
		lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 0;
		panel_formulaire.add(lblCode, gbc_lblCode);
		UI.habiller(lblCode);
		
		txtCode = new JTextField();
		lblCode.setLabelFor(txtCode);
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.gridwidth = 2;
		gbc_txtCode.weightx = 1.0;
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtCode.gridx = 1;
		gbc_txtCode.gridy = 0;
		panel_formulaire.add(txtCode, gbc_txtCode);
		txtCode.setColumns(10);
		UI.habiller(txtCode);
		
		//champs catégories
		lblCategorie = new JLabel("Catégorie");
		lblCategorie.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCategorie = new GridBagConstraints();
		gbc_lblCategorie.anchor = GridBagConstraints.EAST;
		gbc_lblCategorie.insets = new Insets(0, 20, 5, 5);
		gbc_lblCategorie.gridx = 3;
		gbc_lblCategorie.gridy = 0;
		panel_formulaire.add(lblCategorie, gbc_lblCategorie);
		UI.habiller(lblCategorie);
		

		txtCategorie = new JTextField();
		lblCategorie.setLabelFor(txtCategorie);
		GridBagConstraints gbc_txtCategorie = new GridBagConstraints();
		gbc_txtCategorie.gridwidth = 2;
		gbc_txtCategorie.weightx = 1.0;
		gbc_txtCategorie.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCategorie.insets = new Insets(0, 0, 5, 0);
		gbc_txtCategorie.gridx = 4;
		gbc_txtCategorie.gridy = 0;
		panel_formulaire.add(txtCategorie, gbc_txtCategorie);
		txtCategorie.setColumns(10);
		UI.habiller(txtCategorie);
		
		//champs Désignation
		lblDesignation = new JLabel("Désignation");
		lblDesignation.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		UI.habiller(lblDesignation);
		GridBagConstraints gbc_lblDesignation = new GridBagConstraints();
		gbc_lblDesignation.anchor = GridBagConstraints.EAST;
		gbc_lblDesignation.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesignation.gridx = 0;
		gbc_lblDesignation.gridy = 1;
		panel_formulaire.add(lblDesignation, gbc_lblDesignation);
		
		txtDesignation = new JTextField();
		GridBagConstraints gbc_txtDesignation = new GridBagConstraints();
		gbc_txtDesignation.gridwidth = 5;
		gbc_txtDesignation.insets = new Insets(0, 0, 5, 0);
		gbc_txtDesignation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDesignation.gridx = 1;
		gbc_txtDesignation.gridy = 1;
		panel_formulaire.add(txtDesignation, gbc_txtDesignation);
		txtDesignation.setColumns(10);
		UI.habiller(txtDesignation);
		
		//champs Quantité
		lblQuantite = new JLabel("Quantité");
		lblQuantite.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblQuantite = new GridBagConstraints();
		gbc_lblQuantite.anchor = GridBagConstraints.EAST;
		gbc_lblQuantite.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantite.gridx = 0;
		gbc_lblQuantite.gridy = 2;
		panel_formulaire.add(lblQuantite, gbc_lblQuantite);
		UI.habiller(lblQuantite);
		
		sliderQuantite = new JSlider(1, 20, 5);
		sliderQuantite.setOpaque(false);
		GridBagConstraints gbc_slider_quantite = new GridBagConstraints();
		gbc_slider_quantite.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_quantite.insets = new Insets(0, 0, 5, 5);
		gbc_slider_quantite.gridx = 1;
		gbc_slider_quantite.gridy = 2;
		panel_formulaire.add(sliderQuantite, gbc_slider_quantite);
		UI.habiller(sliderQuantite);

		txtQuantite = new JTextField();
		txtQuantite.setEditable(false);
		GridBagConstraints gbc_quantite = new GridBagConstraints();
		gbc_quantite.insets = new Insets(0, 0, 5, 5);
		gbc_quantite.fill = GridBagConstraints.HORIZONTAL;
		gbc_quantite.gridx = 2;
		gbc_quantite.gridy = 2;
		panel_formulaire.add(txtQuantite, gbc_quantite);
		txtQuantite.setColumns(2);
		UI.habiller(txtQuantite);
		
		//champs prix unitaire
		lblPrixUnitaire = new JLabel("Prix Unitaire");
		lblPrixUnitaire.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblPrixUnitaire = new GridBagConstraints();
		gbc_lblPrixUnitaire.anchor = GridBagConstraints.EAST;
		gbc_lblPrixUnitaire.insets = new Insets(0, 20, 5, 5);
		gbc_lblPrixUnitaire.gridx = 3;
		gbc_lblPrixUnitaire.gridy = 2;
		panel_formulaire.add(lblPrixUnitaire, gbc_lblPrixUnitaire);
		UI.habiller(lblPrixUnitaire);
		
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMaximumFractionDigits(2);
		
		txtPrixUnitaire = new JFormattedTextField(format);
		txtPrixUnitaire.setText("0,00");
		txtPrixUnitaire.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_spinner_prix = new GridBagConstraints();
		gbc_spinner_prix.weightx = 1.0;
		gbc_spinner_prix.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_prix.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_prix.gridx = 4;
		gbc_spinner_prix.gridy = 2;
		txtPrixUnitaire.setColumns(10);
		panel_formulaire.add(txtPrixUnitaire, gbc_spinner_prix);
		UI.habiller(txtPrixUnitaire);
		
		lblMoney = new JLabel("€");
		GridBagConstraints gbc_lblMoney = new GridBagConstraints();
		gbc_lblMoney.anchor = GridBagConstraints.LINE_START;
		gbc_lblMoney.insets = new Insets(0, 0, 5, 0);
		gbc_lblMoney.gridx = 5;
		gbc_lblMoney.gridy = 2;
		panel_formulaire.add(lblMoney, gbc_lblMoney);
		UI.habiller(lblMoney);
		
		//composant JToolBar, qui propose les actions disponibles concernant un article
		toolBar = new JToolBar();
		toolBar.setOpaque(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.gridwidth = 6;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 3;
		panel_formulaire.add(toolBar, gbc_toolBar);
		
		//Les actions disponibles pour l'article
		
		//Action AJouter
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Roboto Lt", Font.BOLD, 13));
		toolBar.add(btnAjouter);
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouter.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/Add-New-48.png")));
		UI.deshabillerBouton(btnAjouter, "Add-New");
		btnAjouter.setForeground(Color.BLACK);
		
		//Action modifier
		btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Roboto Lt", Font.BOLD, 13));
		toolBar.add(btnModifier);
		btnModifier.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifier.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/Data-Edit-48.png")));
		UI.deshabillerBouton(btnModifier, "Data-Edit");
		btnModifier.setForeground(Color.BLACK);
		
		//Action supprimer
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Roboto Lt", Font.BOLD, 13));
		toolBar.add(btnSupprimer);
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer.setIcon(new ImageIcon(FArticles.class
				.getResource("/images/gestion/Garbage-Open-48.png")));
		UI.deshabillerBouton(btnSupprimer, "Garbage-Open");
		btnSupprimer.setForeground(Color.BLACK);
		
		//Action effacer
		btnAnnuler = new JButton("Effacer");
		btnAnnuler.setFont(new Font("Roboto Lt", Font.BOLD, 13));
		toolBar.add(btnAnnuler);
		btnAnnuler.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnnuler.setIcon(new ImageIcon(FArticles.class
				.getResource("/images/gestion/Cancel-48.png")));
		UI.deshabillerBouton(btnAnnuler, "Cancel");
		btnAnnuler.setForeground(Color.BLACK);
		
		//panneau résultat situé en bas du le panneau formulaire contenant le tableau 
		panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		panel_formulaire.add(panel, gbc_panel);

		JTable table = new JTable();
		UI.habiller(table);
		
		//Panneau scroller situé dans le panneau résulat
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;

		panel_principal.add(scrollPane, gbc_scrollPane);
		
		//champs trier par
		lblTri = new JLabel("Trier par");
		lblTri.setForeground(Color.BLACK);
		lblTri.setFont(new Font("Roboto Lt", Font.PLAIN, 12));
		lblTri.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/Sort-Ascending-32.png")));
		GridBagConstraints gbc_lblTri = new GridBagConstraints();
		gbc_lblTri.anchor = GridBagConstraints.EAST;
		gbc_lblTri.insets = new Insets(0, 0, 5, 5);
		gbc_lblTri.gridx = 0;
		gbc_lblTri.gridy = 2;
		panel_principal.add(lblTri, gbc_lblTri);
		UI.habiller(lblTri);
		
		//Bouton de choix unique
		
		//Bouton code
		rdbtnCode = new JRadioButton("Code");
		rdbtnCode.setFont(new Font("Roboto Lt", Font.PLAIN, 12));
		rdbtnCode.setOpaque(false);
		UI.habiller(rdbtnCode);
		GridBagConstraints gbc_rdbtnCode = new GridBagConstraints();
		gbc_rdbtnCode.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCode.gridx = 1;
		gbc_rdbtnCode.gridy = 2;
		panel_principal.add(rdbtnCode, gbc_rdbtnCode);
		
		//Bouton Catégories
		rdbtnCategorie = new JRadioButton("Catégorie");
		rdbtnCategorie.setFont(new Font("Roboto Lt", Font.PLAIN, 12));
		rdbtnCategorie.setOpaque(false);
		UI.habiller(rdbtnCategorie);
		GridBagConstraints gbc_rdbtnCatgorie = new GridBagConstraints();
		gbc_rdbtnCatgorie.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCatgorie.gridx = 2;
		gbc_rdbtnCatgorie.gridy = 2;
		panel_principal.add(rdbtnCategorie, gbc_rdbtnCatgorie);
		
		//Bouton recherche
		lblRecherche = new JLabel("Recherche");
		lblRecherche.setFont(new Font("Roboto Lt", Font.PLAIN, 12));
		lblRecherche.setIcon(new ImageIcon(FArticles.class
				.getResource("/images/gestion/Search-32.png")));
		GridBagConstraints gbc_lblRecherche = new GridBagConstraints();
		gbc_lblRecherche.anchor = GridBagConstraints.WEST;
		gbc_lblRecherche.insets = new Insets(0, 20, 5, 5);
		gbc_lblRecherche.gridx = 3;
		gbc_lblRecherche.gridy = 2;
		panel_principal.add(lblRecherche, gbc_lblRecherche);
		UI.habiller(lblRecherche);
		
		//champs de bouton recherche 
		txtRecherche = new JTextField();
		txtRecherche.setText("");
		GridBagConstraints gbc_txtRecherche = new GridBagConstraints();
		gbc_txtRecherche.insets = new Insets(0, 0, 5, 0);
		gbc_txtRecherche.weightx = 5.0;
		gbc_txtRecherche.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRecherche.gridx = 4;
		gbc_txtRecherche.gridy = 2;
		panel_principal.add(txtRecherche, gbc_txtRecherche);
		txtRecherche.setColumns(10);
		UI.habiller(txtRecherche);
		

		SwingUtilities.invokeLater(() -> btnAccueil.requestFocusInWindow());
	}

}
