package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dialogue.UI;
import net.miginfocom.swing.MigLayout;

import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class PClients extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//Attribut d'instance graphique
	private JPanel panel_menu;
	private GridBagLayout gbl_panel_menu;
	private JLabel lblTitre;
	private GridBagConstraints gbc_lblTitre;
	private JButton btnAjouter;
	private GridBagConstraints gbc_btnAjouter;
	private JButton btnRechercher;
	private GridBagConstraints gbc_btnRechercher;
	private JButton btnModifier;
	private GridBagConstraints gbc_btnModifier;
	private JButton btnSupprimer;
	private JButton btnApercu;
	private JButton btnImprimer;
	private JButton btnExport;
	private JButton btnAccueil;
	private JPanel panel_principal;
	private JPanel panel_formulaire;
	private JLabel lblDatecreation;
	private JTextField txtDateCreation;
	private JTextField txtCode;
	private JCheckBox cartefidelite;
	private JLabel lblPrenom;
	private JTextField txtPrenom;
	private JLabel lblNom ;
	private JTextField txtNom;
	private JLabel lblAdresse;
	private JTextField txtAdresse;
	private JLabel lblFixe;
	private JTextField txtTelfixe;
	private JLabel lblMobile;
	private JTextField txtMobile;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblRemarques;
	private JTextArea textArea;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblTri;
	private JComboBox<String> comboBox;
	private final Action actionAjouter = new ActionAjouter();
	private final Action actionRechercher = new ActionRechercher();
	private final Action actionModifier = new ActionModifier();
	private final Action actionSupprimer = new ActionSupprimer();
	private final Action actionApercu = new ActionApercu();
	private final Action actionImprimer = new ActionImprimer();
	private final Action actionExporter = new ActionExporter();
	private JDialog fenetre;
	private final Action actionAnnuler = new ActionAnnuler(); 
	private final Action action = new ActionQuitter();

	
	
	/**
	 * Cr??ation de panneau 
	 */
	//constructeur
	public PClients() {
		
		//propri??t??s du panneau principal
		setBackground(new Color(0x33, 0xB5, 0xE5));
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		//Panneau de menus ?? gauche du panneau principal
		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(0x00, 0x99, 0xCC));
		add(panel_menu, BorderLayout.WEST);
		panel_menu.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5,
				5)));
		gbl_panel_menu = new GridBagLayout();
		gbl_panel_menu.columnWidths = new int[] { 0, 0 };
		gbl_panel_menu.rowHeights = new int[] {0, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gbl_panel_menu.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_menu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_menu.setLayout(gbl_panel_menu);
		
		//Titre / image 
		lblTitre = new JLabel("Clients");
		lblTitre.setFont(new Font("Roboto", Font.BOLD, 20));
		lblTitre.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/client/People-64-actif.png")));
		gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.anchor = GridBagConstraints.SOUTH;
		gbc_lblTitre.insets = new Insets(0, 0, 15, 20);
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
		panel_menu.add(lblTitre, gbc_lblTitre);
		
		//Action ajouter / affichera une interface graphique diff??rente
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setAction(actionAjouter);
		btnAjouter.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		btnAjouter.setForeground(Color.BLACK);
		btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAjouter.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/Add-New-48.png")));
		gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.anchor = GridBagConstraints.LINE_START;
		gbc_btnAjouter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouter.gridx = 0;
		gbc_btnAjouter.gridy = 1;
		btnAjouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_menu.add(btnAjouter, gbc_btnAjouter);
		UI.deshabillerBouton(btnAjouter, "Add-New");
		
		//Action rechercher 
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setAction(actionRechercher);
		btnRechercher.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		btnRechercher.setForeground(Color.BLACK);
		btnRechercher.setHorizontalAlignment(SwingConstants.LEFT);
		btnRechercher.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/Search-48.png")));
		gbc_btnRechercher = new GridBagConstraints();
		gbc_btnRechercher.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRechercher.anchor = GridBagConstraints.LINE_START;
		gbc_btnRechercher.insets = new Insets(0, 0, 5, 0);
		gbc_btnRechercher.gridx = 0;
		gbc_btnRechercher.gridy = 2;
		btnRechercher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel_menu.add(btnRechercher, gbc_btnRechercher);
		UI.deshabillerBouton(btnRechercher, "Search");
		
		//Action modifier
		btnModifier = new JButton("Modifier");
		btnModifier.setAction(actionModifier);
		btnModifier.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		btnModifier.setForeground(Color.BLACK);
		btnModifier.setHorizontalAlignment(SwingConstants.LEFT);
		btnModifier.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/Data-Edit-48.png")));
		gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.anchor = GridBagConstraints.LINE_START;
		gbc_btnModifier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifier.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifier.gridx = 0;
		gbc_btnModifier.gridy = 3;
		panel_menu.add(btnModifier, gbc_btnModifier);
		btnModifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		UI.deshabillerBouton(btnModifier, "Data-Edit");
		
		//Action supprimer
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setAction(actionSupprimer);
		btnSupprimer.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		btnSupprimer.setForeground(Color.BLACK);
		btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimer.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/Garbage-Open-48.png")));
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.anchor = GridBagConstraints.LINE_START;
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimer.gridx = 0;
		gbc_btnSupprimer.gridy = 4;
		panel_menu.add(btnSupprimer, gbc_btnSupprimer);
		btnSupprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		UI.deshabillerBouton(btnSupprimer, "Garbage-Open");
		
		//Action aper??u
		btnApercu = new JButton("Aper??u");
		btnApercu.setAction(actionApercu);
		btnApercu.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		btnApercu.setForeground(Color.BLACK);
		btnApercu.setHorizontalAlignment(SwingConstants.LEFT);
		btnApercu.setIcon(new ImageIcon(PClients.class
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
		
		
		//Action
		btnImprimer = new JButton("Imprimer");
		btnImprimer.setAction(actionImprimer);
		btnImprimer.setIcon(new ImageIcon(PClients.class.getResource("/images/gestion/Printer-48.png")));
		btnImprimer.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		btnImprimer.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnImprimer = new GridBagConstraints();
		gbc_btnImprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimer.anchor = GridBagConstraints.LINE_START;
		gbc_btnImprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnImprimer.gridx = 0;
		gbc_btnImprimer.gridy = 6;
		panel_menu.add(btnImprimer, gbc_btnImprimer);
		UI.deshabillerBouton(btnImprimer, "Printer");
		
		btnExport = new JButton("Export");
		btnExport.setAction(actionExporter);
		btnExport.setIcon(new ImageIcon(PClients.class.getResource("/images/gestion/Data-Export-48.png")));
		btnExport.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		btnExport.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExport.anchor = GridBagConstraints.LINE_START;
		gbc_btnExport.insets = new Insets(0, 0, 5, 0);
		gbc_btnExport.gridx = 0;
		gbc_btnExport.gridy = 7;
		panel_menu.add(btnExport, gbc_btnExport);
		UI.deshabillerBouton(btnExport, "Data-Export");
		
		btnAccueil = new JButton("Accueil");
		btnAccueil.setAction(action);
		btnAccueil.setIcon(new ImageIcon(PClients.class.getResource("/images/gestion/Home-48.png")));
		//btnAccueil.setAction(actionAccueil);
		btnAccueil.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnAccueil = new GridBagConstraints();
		gbc_btnAccueil.weighty = 1.0;
		gbc_btnAccueil.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnAccueil.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAccueil.gridx = 0;
		gbc_btnAccueil.gridy = 8;
		panel_menu.add(btnAccueil, gbc_btnAccueil);
		UI.deshabillerBouton(btnAccueil, "Home");
		
		//Panneau au centre du paneau principal
		panel_principal = new JPanel();
		panel_principal.setBackground(new Color(197, 234, 248));
		add(panel_principal, BorderLayout.CENTER);
		panel_principal.setLayout(new MigLayout("", "[][10%][10%][grow]",
				"[grow][42%,grow][]"));
		
		//Panneau formulaire au nord en haut du panneau centrale 
		panel_formulaire = new JPanel();
		panel_formulaire.setOpaque(false);
		panel_formulaire.setBorder(new CompoundBorder(new LineBorder(new Color(
				0, 0, 0), 2, true), new EmptyBorder(5, 5, 5, 5)));
		panel_principal.add(panel_formulaire, "cell 0 0 4 1,grow");
		GridBagLayout gbl_panel_formulaire = new GridBagLayout();
		gbl_panel_formulaire.columnWidths = new int[] { 79, 182, 91, 182, 119 };
		gbl_panel_formulaire.rowHeights = new int[] { 26, 26, 26, 26, 0, 75 };
		gbl_panel_formulaire.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
				0.0 };
		gbl_panel_formulaire.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0 };
		panel_formulaire.setLayout(gbl_panel_formulaire);
		
		
		//Composants ?? l'int??rieur du paneau de formulaire
		
		//Champs Date de cr??ation
		lblDatecreation = new JLabel("Cr???? le");
		lblDatecreation.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDatecreation = new GridBagConstraints();
		gbc_lblDatecreation.anchor = GridBagConstraints.LINE_END;
		gbc_lblDatecreation.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatecreation.gridx = 2;
		gbc_lblDatecreation.gridy = 0;
		panel_formulaire.add(lblDatecreation, gbc_lblDatecreation);
		UI.habiller(lblDatecreation);

		txtDateCreation = new JTextField();
		lblDatecreation.setLabelFor(txtDateCreation);
		txtDateCreation.setEditable(false);JLabel lblCode = new JLabel("Code");
lblCode.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.anchor = GridBagConstraints.EAST;
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 0;
		gbc_lblCode.gridy = 0;
		panel_formulaire.add(lblCode, gbc_lblCode);
		UI.habiller(lblCode);
        
		//champs code
		txtCode = new JTextField();
		lblCode.setLabelFor(txtCode);
		txtCode.setEditable(false);
		GridBagConstraints gbc_txtCode = new GridBagConstraints();
		gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtCode.gridx = 1;
		gbc_txtCode.gridy = 0;
		panel_formulaire.add(txtCode, gbc_txtCode);
		txtCode.setColumns(10);
		UI.habiller(txtCode);
		GridBagConstraints gbc_txtDateCreation = new GridBagConstraints();
		gbc_txtDateCreation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateCreation.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateCreation.gridx = 3;
		gbc_txtDateCreation.gridy = 0;
		panel_formulaire.add(txtDateCreation, gbc_txtDateCreation);
		txtDateCreation.setColumns(10);
		UI.habiller(txtDateCreation);
        
		//CheckBox Carte de fidelit??
		cartefidelite = new JCheckBox("Carte de Fid??lit??");
		cartefidelite.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		cartefidelite.setOpaque(false);
		GridBagConstraints gbc_chckbxCartefidelite = new GridBagConstraints();
		gbc_chckbxCartefidelite.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxCartefidelite.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxCartefidelite.gridx = 4;
		gbc_chckbxCartefidelite.gridy = 0;
		panel_formulaire.add(cartefidelite, gbc_chckbxCartefidelite);
		UI.habiller(cartefidelite);
		
		//Champs pr??nom
		lblPrenom = new JLabel("Pr??nom");
		lblPrenom.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.anchor = GridBagConstraints.EAST;
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 0;
		gbc_lblPrenom.gridy = 1;
		panel_formulaire.add(lblPrenom, gbc_lblPrenom);
		UI.habiller(lblPrenom);
        
		txtPrenom = new JTextField();
		lblPrenom.setLabelFor(txtPrenom);
		txtPrenom.setEditable(false);
		GridBagConstraints gbc_txtPrenom = new GridBagConstraints();
		gbc_txtPrenom.anchor = GridBagConstraints.NORTH;
		gbc_txtPrenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrenom.gridx = 1;
		gbc_txtPrenom.gridy = 1;
		panel_formulaire.add(txtPrenom, gbc_txtPrenom);
		txtPrenom.setColumns(10);
		UI.habiller(txtPrenom);
        
		//champs nom 
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 1;
		panel_formulaire.add(lblNom, gbc_lblNom);
		UI.habiller(lblNom);
    
		txtNom = new JTextField();
		lblNom.setLabelFor(txtNom);
		txtNom.setEditable(false);
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.anchor = GridBagConstraints.NORTH;
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.insets = new Insets(0, 0, 5, 0);
		gbc_txtNom.gridwidth = 2;
		gbc_txtNom.gridx = 3;
		gbc_txtNom.gridy = 1;
		panel_formulaire.add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);
		UI.habiller(txtNom);
        
		//champs adresse
		lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.anchor = GridBagConstraints.EAST;
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 0;
		gbc_lblAdresse.gridy = 2;
		panel_formulaire.add(lblAdresse, gbc_lblAdresse);
		UI.habiller(lblAdresse);
        
		txtAdresse = new JTextField();
		lblAdresse.setLabelFor(txtAdresse);
		txtAdresse.setEditable(false);
		GridBagConstraints gbc_txtAdresse = new GridBagConstraints();
		gbc_txtAdresse.anchor = GridBagConstraints.NORTH;
		gbc_txtAdresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdresse.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdresse.gridwidth = 4;
		gbc_txtAdresse.gridx = 1;
		gbc_txtAdresse.gridy = 2;
		panel_formulaire.add(txtAdresse, gbc_txtAdresse);
		txtAdresse.setColumns(10);
		UI.habiller(txtAdresse);
        
		//champs num??ro fixe
		lblFixe = new JLabel("Fixe");
		lblFixe.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFixe = new GridBagConstraints();
		gbc_lblFixe.anchor = GridBagConstraints.EAST;
		gbc_lblFixe.insets = new Insets(0, 0, 5, 5);
		gbc_lblFixe.gridx = 0;
		gbc_lblFixe.gridy = 3;
		panel_formulaire.add(lblFixe, gbc_lblFixe);
		UI.habiller(lblFixe);

		txtTelfixe = new JTextField();
		lblFixe.setLabelFor(txtTelfixe);
		txtTelfixe.setEditable(false);
		GridBagConstraints gbc_txtTelfixe = new GridBagConstraints();
		gbc_txtTelfixe.anchor = GridBagConstraints.NORTH;
		gbc_txtTelfixe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelfixe.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelfixe.gridx = 1;
		gbc_txtTelfixe.gridy = 3;
		panel_formulaire.add(txtTelfixe, gbc_txtTelfixe);
		txtTelfixe.setColumns(10);
		UI.habiller(txtTelfixe);
        
		//champs t??l??phone Mobile
		lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMobile = new GridBagConstraints();
		gbc_lblMobile.anchor = GridBagConstraints.EAST;
		gbc_lblMobile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobile.gridx = 2;
		gbc_lblMobile.gridy = 3;
		panel_formulaire.add(lblMobile, gbc_lblMobile);
		UI.habiller(lblMobile);

		txtMobile = new JTextField();
		lblMobile.setLabelFor(txtMobile);
		txtMobile.setEditable(false);
		GridBagConstraints gbc_txtMobile = new GridBagConstraints();
		gbc_txtMobile.anchor = GridBagConstraints.NORTH;
		gbc_txtMobile.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMobile.insets = new Insets(0, 0, 5, 0);
		gbc_txtMobile.gridwidth = 2;
		gbc_txtMobile.gridx = 3;
		gbc_txtMobile.gridy = 3;
		panel_formulaire.add(txtMobile, gbc_txtMobile);
		txtMobile.setColumns(10);
		UI.habiller(txtMobile);
        
		//Champs email
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		panel_formulaire.add(lblEmail, gbc_lblEmail);
		UI.habiller(lblEmail);

		txtEmail = new JTextField();
		lblEmail.setLabelFor(txtEmail);
		txtEmail.setEditable(false);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridwidth = 4;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 4;
		panel_formulaire.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		UI.habiller(txtEmail);
        
		//champs remarques
		lblRemarques = new JLabel("Remarques");
		lblRemarques.setFont(new Font("Roboto Lt", Font.PLAIN, 14));
		lblRemarques.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblRemarques = new GridBagConstraints();
		gbc_lblRemarques.anchor = GridBagConstraints.NORTH;
		gbc_lblRemarques.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemarques.gridx = 0;
		gbc_lblRemarques.gridy = 5;
		panel_formulaire.add(lblRemarques, gbc_lblRemarques);
		UI.habiller(lblRemarques);
        
		//zone de texte brute
		textArea = new JTextArea();
		textArea.setBackground(SystemColor.control);
		lblRemarques.setLabelFor(textArea);
		Border cadre = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		textArea.setBorder(cadre);
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridwidth = 4;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 5;
		panel_formulaire.add(textArea, gbc_textArea);
		UI.habiller(textArea);
		
		
		//Tableau pour afficher les clients enregistr??s situ?? au centre du panneau scroller
		table = new JTable();
		UI.habiller(table);
		
        //Panneau Scroller situ?? au centre du panneau centrale
		scrollPane = new JScrollPane(table);
		panel_principal.add(scrollPane, "cell 0 1 4 1,grow");
		scrollPane.setOpaque(false);
		
		
		//Trier l'affichage de client par liste
		//JLabel situ?? en bas du panneau central
		lblTri = new JLabel("Trier la liste par");
		lblTri.setIcon(new ImageIcon(PClients.class
				.getResource("/images/gestion/Sort-Ascending-32.png")));
		panel_principal.add(lblTri, "cell 1 2,alignx trailing");
		UI.habiller(lblTri);
        //JComboBox permet de s??lectionner les options 
		comboBox = new JComboBox<>();
		panel_principal.add(comboBox, "cell 2 2,growx");
		UI.habiller(comboBox);

		SwingUtilities.invokeLater(
				() -> btnAccueil.requestFocusInWindow()		
		);
		
		
	}
	
	
	//Les actions de boutons du panneau menu 
	
	//Action Ajouter
	private class ActionAjouter extends AbstractAction {
		private static final long serialVersionUID = 1L;
		//m??thode de la classe
		public ActionAjouter() {
			putValue(NAME, "Ajouter");
			putValue(SHORT_DESCRIPTION, "Ajouter un nouveau client");
		}
		public void actionPerformed(ActionEvent e) {
			//methode d'appel
			ajouter();
		}
	}
	
	//Action Rechercher
	private class ActionRechercher extends AbstractAction {
		private static final long serialVersionUID = 1L;
		//m??thode de la classe
		public ActionRechercher() {
			putValue(NAME, "Rechercher");
			putValue(SHORT_DESCRIPTION, "Rechercher un client");
		}
		public void actionPerformed(ActionEvent e) {
			//m??thode d'appel
			rechercher();
		}
	}
	
	//Action modifier
	private class ActionModifier extends AbstractAction {
		private static final long serialVersionUID = 1L;
		//m??thode de la classe
		public ActionModifier() {
			putValue(NAME, "Modifier");
			putValue(SHORT_DESCRIPTION, "Modifier les informations d'un client");
		}
		public void actionPerformed(ActionEvent e) {
			modifier();
		}
	}
	//Action supprimer
	private class ActionSupprimer extends AbstractAction {
		private static final long serialVersionUID = 1L;
		//m??thode de la classe
		public ActionSupprimer() {
			putValue(NAME, "Supprimer");
			putValue(SHORT_DESCRIPTION, "Supprimer un client");
		}
		public void actionPerformed(ActionEvent e) {
			supprimer();
		}
	}
	
	//Action apercu
	private class ActionApercu extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		//m??thode de la classe
		public ActionApercu() {
			putValue(NAME, "Aper??u");
			putValue(SHORT_DESCRIPTION, "l'aper??u d'un client");
		}
		public void actionPerformed(ActionEvent e) {
			apercu();
		}
	}
	
	//Action imprimer
	private class ActionImprimer extends AbstractAction {
		private static final long serialVersionUID = 1L;
		//m??thode de la classe
		public ActionImprimer() {
			putValue(NAME, "Imprimer");
			putValue(SHORT_DESCRIPTION, "Imprimer les informations de client");
		}
		public void actionPerformed(ActionEvent e) {
			imprimer();
		}
	}
	
	//Action exporter
	private class ActionExporter extends AbstractAction {
		private static final long serialVersionUID = 1L;
		//m??thode de la classe
		public ActionExporter() {
			putValue(NAME, "Exporter");
			putValue(SHORT_DESCRIPTION, "Exporter les informations de client");
		}
		public void actionPerformed(ActionEvent e) {
			exporter();
		}
	}
	
	
	//Action accueil
	
	
	//Action quitter
	private class ActionQuitter extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionQuitter() {
			putValue(NAME, "Quitter");
			putValue(SHORT_DESCRIPTION, "Quitter la fen??tre clients");
		}
		public void actionPerformed(ActionEvent e) {
			//r??diriger vers la fen??tre d'accueil
			
		}
	}
	
	//Action annuler
	//une action qui servira pour les panneaux d???ajout et de recherche ?? pouvoir afficher de nouveau le panneau principal.
    private class ActionAnnuler extends AbstractAction { 
        private static final long serialVersionUID = 1L; 
        //m??thode de la classse
        public ActionAnnuler() { 
            putValue(NAME, "Annuler"); 
            putValue(SHORT_DESCRIPTION, 
                             "Annuler l'action en cours"); 
        } 
     
        public void actionPerformed(ActionEvent e) {  
        	//m??thode d'appel 
            changerPanneau(PClients.this, "Gestion des Clients"); 
        } 
    }
    
	
	//M??thodes des actions 
	
	public void ajouter() {
		//instancier un nouveau client
		PClient ajout = new PClient();
		//
	    ajout.setActionAnnuler(actionAnnuler); 
	     
	    btnAjouter.setIcon(new ImageIcon( 
	                PClients.class.getResource( 
	                "/images/gestion/Add-New-48.png"))); 
	    //r??diriger vers le panenau d'ajout de client
	    changerPanneau(ajout ,"Ajouter un nouveau client");
		
	}
	
	public void rechercher() {
		// instancier un nouveau recherche
		 PClientRecherche recherche = new PClientRecherche();
		
		 recherche.setActionAnnuler(actionAnnuler); 
		 
		 btnRechercher.setIcon(new ImageIcon( 
	                PClients.class.getResource( 
	                    "/images/gestion/Search-48.png"))); 
		 //r??diriger vers le pennau de recherche
	    changerPanneau(recherche, "Recherche de client(s)"); 
		
	}
	public void modifier() {
		// TODO Auto-generated method stub
		
	}
	public void supprimer() {
		// TODO Auto-generated method stub
		
	}
	public void apercu() {
		// TODO Auto-generated method stub
		
	}
	public void imprimer() {
		// TODO Auto-generated method stub
		
	}
	public void exporter() {
		// TODO Auto-generated method stub
		
	}
	
	public void accueil() {
		// TODO Auto-generated method stub
		
	}
	
	//Les m??thodes permettent respectivement de fixer et de retrouver la fen??tre ?? laquelle est rattach?? le panneau, et enfin de pouvoir changer le panneau de contenu principal.
	
	//Ajouter une fen??tre 
	//permet d'ajoutr l'instance ce panneau princopal dans une fen??tre
	public void setFenetre(JDialog fenetre) { 
        this.fenetre = fenetre; 
    } 
    
	//Obtenier la fen??tre ajout??e
	/*
    private JDialog getFenetre() { 
        return fenetre; 
    } 
    */
    //Changer de panneau 
    private void changerPanneau(JPanel panneau, String titre) { 
        fenetre.setContentPane(panneau); 
        fenetre.setTitle(titre); 
        fenetre.revalidate(); 
    }
    
	
}


