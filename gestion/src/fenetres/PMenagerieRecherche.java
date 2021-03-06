package fenetres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

import classesLogiques.Animal;
import classesLogiques.Chat;
import classesLogiques.Chien;
import classesLogiques.Menagerie;
import dialogue.UI;
import net.miginfocom.swing.MigLayout;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class PMenagerieRecherche extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//Attribut d'instance graphique
	private JPanel panel_menu;
	private JLabel lblTitre;
	private JButton btnRecherche;
	private JButton btnApercu;
	private JButton btnImprimer;
	private JButton btnExport;
	private JButton btnAccueil;
	private JPanel panel_principal;
	private JPanel panel_formulaire;
	private JLabel lblEspece;
	private JTextField txtEspece;
	private JLabel lblRace;
	private JTextField txtRace;
	private JCheckBox chckbxCartefidelite;
	private JTextField txtCouleur;
	private JLabel lblNom;
	private JTextField txtNom;
	private JLabel lblTypeEducation;
	private JTextField txtTypeEducation;
	private JLabel lblEnvironnement;
	private JTextField txtEnvironnement;
	private JLabel lblOrigine;
	private JTextField txtOrigine;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblTri;
	private JComboBox<Object> comboBoxTrie;
	
	
	private final Action actionRecherche = new ActionRecherche();
	private JLabel lblMessage;
	private JButton btnSupprimerAnimal;
	private final Action actionSupprimerAnimal = new ActionSupprimerAnimal();
	/**
	 * Cr??ation du panneau principal
	 */
	//constructeur
	public PMenagerieRecherche() {
		//propri??tes du panneau principal
		setBackground(new Color(0x33, 0xB5, 0xE5));
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		//Panneau menu situ?? ?? gauche du panneau principal
		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(0x00, 0x99, 0xCC));
		add(panel_menu, BorderLayout.WEST);
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
		lblTitre = new JLabel("RechercheAnimal");
		lblTitre.setIcon(new ImageIcon(PMenagerieRecherche.class.getResource("/images/animal.png")));
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.anchor = GridBagConstraints.LINE_START;
		gbc_lblTitre.insets = new Insets(0, 0, 15, 20);
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
		panel_menu.add(lblTitre, gbc_lblTitre);
		lblTitre.setFont(new Font("Roboto", Font.BOLD, 18));
		
		//Actions disponibles
		
		//Action rechercher
		btnRecherche = new JButton("Rechercher");
		btnRecherche.setAction(actionRecherche);
		btnRecherche.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		//btnAction.setAction(actionPrincipale);
		btnRecherche.setForeground(Color.BLACK);
		btnRecherche.setIcon(new ImageIcon(PMenagerieRecherche.class.getResource("/images/gestion/Search-48.png")));
		UI.deshabillerBouton(btnRecherche, "Search");
		btnRecherche.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.anchor = GridBagConstraints.LINE_START;
		gbc_btnRecherche.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRecherche.insets = new Insets(0, 0, 5, 0);
		gbc_btnRecherche.gridx = 0;
		gbc_btnRecherche.gridy = 1;
		panel_menu.add(btnRecherche, gbc_btnRecherche);
		
		//champs pour afficher un message dans le panneau de menu gauche
		lblMessage = new JLabel("");
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setFont(new Font("Roboto Lt", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(0, 0, 5, 0);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 2;
		panel_menu.add(lblMessage, gbc_lblMessage);
		
		btnSupprimerAnimal = new JButton("Supprimer");
		btnSupprimerAnimal.setAction(actionSupprimerAnimal);
		btnSupprimerAnimal.setHorizontalAlignment(SwingConstants.LEFT);
		btnSupprimerAnimal.setIcon(new ImageIcon(PMenagerieRecherche.class.getResource("/images/gestion/Garbage-Open-48.png")));
		btnSupprimerAnimal.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		GridBagConstraints gbc_btnSupprimerAnimal = new GridBagConstraints();
		gbc_btnSupprimerAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimerAnimal.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimerAnimal.gridx = 0;
		gbc_btnSupprimerAnimal.gridy = 3;
		panel_menu.add(btnSupprimerAnimal, gbc_btnSupprimerAnimal);
		UI.deshabillerBouton(btnSupprimerAnimal, "Garbage-Open");
        
		//Action Apercu
		btnApercu = new JButton("Apercu");
		btnApercu.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		btnApercu.setForeground(Color.BLACK);
		btnApercu.setHorizontalAlignment(SwingConstants.LEFT);
		btnApercu.setIcon(new ImageIcon(PMenagerieRecherche.class
				.getResource("/images/gestion/Preview-48.png")));
		GridBagConstraints gbc_btnApercu = new GridBagConstraints();
		gbc_btnApercu.weighty = 1.0;
		gbc_btnApercu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnApercu.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnApercu.insets = new Insets(0, 0, 5, 0);
		gbc_btnApercu.gridx = 0;
		gbc_btnApercu.gridy = 5;
		panel_menu.add(btnApercu, gbc_btnApercu);
		UI.deshabillerBouton(btnApercu, "Preview");
		
		//Action Imprimer
		btnImprimer = new JButton("Imprimer");
		btnImprimer.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		btnImprimer.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnImprimer = new GridBagConstraints();
		gbc_btnImprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimer.anchor = GridBagConstraints.LINE_START;
		gbc_btnImprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnImprimer.gridx = 0;
		gbc_btnImprimer.gridy = 6;
		panel_menu.add(btnImprimer, gbc_btnImprimer);
		UI.deshabillerBouton(btnImprimer, "Printer");
		
		//Action exporter
		btnExport = new JButton("Export");
		btnExport.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		btnExport.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExport.anchor = GridBagConstraints.LINE_START;
		gbc_btnExport.insets = new Insets(0, 0, 5, 0);
		gbc_btnExport.gridx = 0;
		gbc_btnExport.gridy = 7;
		panel_menu.add(btnExport, gbc_btnExport);
		UI.deshabillerBouton(btnExport, "Data-Export");
		
		//Action annuler quitter
		btnAccueil = new JButton("Annuler");
		btnAccueil.setFont(new Font("Roboto Lt", Font.BOLD, 14));
		btnAccueil.setIcon(new ImageIcon(PMenagerieRecherche.class.getResource("/images/gestion/Cancel-48.png")));
		btnAccueil.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnAccueil = new GridBagConstraints();
		gbc_btnAccueil.weighty = 1.0;
		gbc_btnAccueil.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnAccueil.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAccueil.gridx = 0;
		gbc_btnAccueil.gridy = 8;
		panel_menu.add(btnAccueil, gbc_btnAccueil);
		UI.deshabillerBouton(btnAccueil, "Cancel");
		
		//Panneau central au centre du panneau principal
		panel_principal = new JPanel();
		panel_principal.setBackground(new Color(197, 234, 248));
		add(panel_principal, BorderLayout.CENTER);
		panel_principal.setLayout(new MigLayout("", "[][10%][10%][grow]", "[grow][42%,grow][]"));
		
		//Panneau formulaire en haut du panneau centrale
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
		
		//Champs Date de code
		lblEspece = new JLabel("Espece");
		lblEspece.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEspece = new GridBagConstraints();
		gbc_lblEspece.anchor = GridBagConstraints.EAST;
		gbc_lblEspece.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspece.gridx = 0;
		gbc_lblEspece.gridy = 0;
		panel_formulaire.add(lblEspece, gbc_lblEspece);
		UI.habiller(lblEspece);
		

		txtEspece = new JTextField();
		lblEspece.setLabelFor(txtEspece);
		txtEspece.setEditable(false);
		GridBagConstraints gbc_txtEspece = new GridBagConstraints();
		gbc_txtEspece.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspece.insets = new Insets(0, 0, 5, 5);
		gbc_txtEspece.gridx = 1;
		gbc_txtEspece.gridy = 0;
		panel_formulaire.add(txtEspece, gbc_txtEspece);
		txtEspece.setColumns(10);
		UI.habiller(txtEspece);
		
		//champs date de cr??ation
		lblRace = new JLabel("Race");
		lblRace.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblRace = new GridBagConstraints();
		gbc_lblRace.anchor = GridBagConstraints.LINE_END;
		gbc_lblRace.insets = new Insets(0, 0, 5, 5);
		gbc_lblRace.gridx = 2;
		gbc_lblRace.gridy = 0;
		panel_formulaire.add(lblRace, gbc_lblRace);
		UI.habiller(lblRace);

		txtRace = new JTextField();
		txtRace.setEditable(false);
		lblRace.setLabelFor(txtRace);
		GridBagConstraints gbc_txtRace = new GridBagConstraints();
		gbc_txtRace.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRace.insets = new Insets(0, 0, 5, 5);
		gbc_txtRace.gridx = 3;
		gbc_txtRace.gridy = 0;
		panel_formulaire.add(txtRace, gbc_txtRace);
		txtRace.setColumns(10);
		UI.habiller(txtRace);

		//champs radio carte de fid??lit??
		chckbxCartefidelite = new JCheckBox("Carte de Fid??lit??");
		chckbxCartefidelite.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		chckbxCartefidelite.setOpaque(false);
		GridBagConstraints gbc_chckbxCartefidelite = new GridBagConstraints();
		gbc_chckbxCartefidelite.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxCartefidelite.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxCartefidelite.gridx = 4;
		gbc_chckbxCartefidelite.gridy = 0;
		panel_formulaire.add(chckbxCartefidelite, gbc_chckbxCartefidelite);
		UI.habiller(chckbxCartefidelite);
		
		//champs pr??nom
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.anchor = GridBagConstraints.EAST;
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.gridx = 0;
		gbc_lblCouleur.gridy = 1;
		panel_formulaire.add(lblCouleur, gbc_lblCouleur);
		UI.habiller(lblCouleur);

		txtCouleur = new JTextField();
		lblCouleur.setLabelFor(txtCouleur);
		txtCouleur.setEditable(false);
		GridBagConstraints gbc_txtCouleur = new GridBagConstraints();
		gbc_txtCouleur.anchor = GridBagConstraints.NORTH;
		gbc_txtCouleur.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_txtCouleur.gridx = 1;
		gbc_txtCouleur.gridy = 1;
		panel_formulaire.add(txtCouleur, gbc_txtCouleur);
		txtCouleur.setColumns(10);
		UI.habiller(txtCouleur);
		
		//champs nom
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 1;
		panel_formulaire.add(lblNom, gbc_lblNom);
		UI.habiller(lblNom);

		txtNom = new JTextField();
		lblNom.setLabelFor(txtNom);
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
		lblTypeEducation = new JLabel("Type Education");
		lblTypeEducation.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTypeEducation = new GridBagConstraints();
		gbc_lblTypeEducation.anchor = GridBagConstraints.EAST;
		gbc_lblTypeEducation.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypeEducation.gridx = 0;
		gbc_lblTypeEducation.gridy = 2;
		panel_formulaire.add(lblTypeEducation, gbc_lblTypeEducation);
		UI.habiller(lblTypeEducation);

		txtTypeEducation = new JTextField();
		lblTypeEducation.setLabelFor(txtTypeEducation);
		txtTypeEducation.setEditable(false);
		GridBagConstraints gbc_txtTypeEducation = new GridBagConstraints();
		gbc_txtTypeEducation.anchor = GridBagConstraints.NORTH;
		gbc_txtTypeEducation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTypeEducation.insets = new Insets(0, 0, 5, 0);
		gbc_txtTypeEducation.gridwidth = 4;
		gbc_txtTypeEducation.gridx = 1;
		gbc_txtTypeEducation.gridy = 2;
		panel_formulaire.add(txtTypeEducation, gbc_txtTypeEducation);
		txtTypeEducation.setColumns(10);
		UI.habiller(txtTypeEducation);
        
		//champs t??l??phone fixe
		lblEnvironnement = new JLabel("Environnement");
		lblEnvironnement.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEnvironnement = new GridBagConstraints();
		gbc_lblEnvironnement.anchor = GridBagConstraints.EAST;
		gbc_lblEnvironnement.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnvironnement.gridx = 0;
		gbc_lblEnvironnement.gridy = 3;
		panel_formulaire.add(lblEnvironnement, gbc_lblEnvironnement);
		UI.habiller(lblEnvironnement);

		txtEnvironnement = new JTextField();
		txtEnvironnement.setEditable(false);
		lblEnvironnement.setLabelFor(txtEnvironnement);
		GridBagConstraints gbc_txtEnvironnement = new GridBagConstraints();
		gbc_txtEnvironnement.anchor = GridBagConstraints.NORTH;
		gbc_txtEnvironnement.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnvironnement.insets = new Insets(0, 0, 5, 5);
		gbc_txtEnvironnement.gridx = 1;
		gbc_txtEnvironnement.gridy = 3;
		panel_formulaire.add(txtEnvironnement, gbc_txtEnvironnement);
		txtEnvironnement.setColumns(10);
		UI.habiller(txtEnvironnement);
		
		//champs t??l??phone mobile
		lblOrigine = new JLabel("Origine");
		lblOrigine.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		GridBagConstraints gbc_lblOrigine = new GridBagConstraints();
		gbc_lblOrigine.anchor = GridBagConstraints.EAST;
		gbc_lblOrigine.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrigine.gridx = 2;
		gbc_lblOrigine.gridy = 3;
		panel_formulaire.add(lblOrigine, gbc_lblOrigine);
		UI.habiller(lblOrigine);
		
		txtOrigine = new JTextField();
		txtOrigine.setEditable(false);
		lblOrigine.setLabelFor(txtOrigine);
		GridBagConstraints gbc_txtOrigine = new GridBagConstraints();
		gbc_txtOrigine.anchor = GridBagConstraints.NORTH;
		gbc_txtOrigine.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOrigine.insets = new Insets(0, 0, 5, 0);
		gbc_txtOrigine.gridwidth = 2;
		gbc_txtOrigine.gridx = 3;
		gbc_txtOrigine.gridy = 3;
		panel_formulaire.add(txtOrigine, gbc_txtOrigine);
		txtOrigine.setColumns(10);
		UI.habiller(txtOrigine);
		Border cadre = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		
		//Panneau scroller 
		
		//Tableau pour afficher les informations de client
		/*
		table = new JTable();
		UI.habiller(table);
		
		
		//Panneau scroller
		scrollPane = new JScrollPane(table);
		panel_principal.add(scrollPane, "cell 0 1 4 1,grow");
		
		*/
		//champs trier la liste par
		lblTri = new JLabel("Trier la liste par");
		lblTri.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		lblTri.setIcon(new ImageIcon(PMenagerieRecherche.class
				.getResource("/images/gestion/Sort-Ascending-32.png")));
		panel_principal.add(lblTri, "cell 1 2,alignx trailing");
		UI.habiller(lblTri);
		
		//Champs d'options multiples
		comboBoxTrie = new JComboBox<>();
		comboBoxTrie.setFont(new Font("Roboto Lt", Font.PLAIN, 13));
		UI.habiller(comboBoxTrie);
		panel_principal.add(comboBoxTrie, "cell 2 2,growx");
		//les options possibles
		comboBoxTrie.addItem("Code");
		comboBoxTrie.addItem("Pr??nom");
		comboBoxTrie.addItem("Nom");
		comboBoxTrie.addItem("Date de Cr??ation");
		
		/*
		comboBoxTrie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Tri s??lectionn??: " +comboBoxTrie.getSelectedItem());
			}
		});
		*/
		SwingUtilities.invokeLater(
				() -> btnAccueil.requestFocusInWindow()		
		);
	}
	
		//Action annuler
		void setActionAnnuler(Action action) {
			btnAccueil.setAction(action);
			UI.deshabillerBouton(btnAccueil, "Cancel");
		}
		
		//Action recherche
		private class ActionRecherche extends AbstractAction {
			private static final long serialVersionUID = 1L;
			
			public ActionRecherche() {
				putValue(NAME, "Recherche");
				putValue(SHORT_DESCRIPTION, "Recherche un client dans la base de donn??e");
			}
			public void actionPerformed(ActionEvent e) {
				recherche();
			}
		}

		
		//Action supprimer un animal
		private class ActionSupprimerAnimal extends AbstractAction {
			private static final long serialVersionUID = 1L;
			
			public ActionSupprimerAnimal() {
				putValue(NAME, "SupprimerAnimal");
				putValue(SHORT_DESCRIPTION, "Supprimer un animal par son nom");
			}
			public void actionPerformed(ActionEvent e) {
				supprimerAnimal();
			}
		}
		
		
		
		public void recherche() {
			//r??cup??ration de saisie
			String lNom = txtNom.getText();
			
			//r??cup??ration de la m??nagerie
			Menagerie uneMenagerie = Menagerie.uneMenagerie;
			
			//r??cup??ration de la collection
			ArrayList<Animal> listAnimaux = uneMenagerie.getListAnimaux();
			
			//recherche de l'index
			int indexAnimal = uneMenagerie.rechercheAnimal(lNom);
			
			
			if(indexAnimal != -1) {
				//recherche de l'animal
				Animal unAnimal = listAnimaux.get(indexAnimal);
				
				//v??rifier si l'animal est trouv?? / un seul 
				if(uneMenagerie.rechercherAnimal(unAnimal)) {
					//affichage de l'animal
					
					//Ent??te JTable
					String[] columns = new String[] {
							"Espece", "Nom", "Race", "Couleur/Type d'??ducation " , "Origine Environnement" , "Animal"
					};
					
					//r??cup??ration des informations de l'animal
					Object data[][] = new Object[10][10];
					
					//Classe fille Chien
					if(listAnimaux.get(indexAnimal) instanceof Chat) {
						Chat unChat = (Chat) listAnimaux.get(indexAnimal);
						data[0][0] = unAnimal.getEspece();
						data[0][1] = unChat.getNom();
						data[0][2] = unChat.getRace();
						data[0][3] = unChat.getCouleur();
						data[0][4] = unChat.getOrigine();	
						data[0][5] = "Chat";
					} else if (listAnimaux.get(indexAnimal) instanceof Chien){
						Chien unChien = (Chien) listAnimaux.get(indexAnimal);
						data[0][0] = unChien.getEspece();
						data[0][1] = unChien.getNom();
						data[0][2] = unChien.getRace();
						data[0][3] = unChien.getTypeEducation();
						data[0][4] = unChien.getEnvironnement();
						data[0][5] = "Chien";
					}
					
					//cr??er un JTable avec des donn??es
			        table = new JTable(data, columns);
			        table.setFillsViewportHeight(true);
			        scrollPane = new JScrollPane(table);
			        panel_principal.add(scrollPane, "cell 0 1 4 1,grow");
			 		add(panel_principal, BorderLayout.CENTER);
			 		UI.habiller(table);	
			 		
			 		lblMessage.setText("Animal trouv??");
			 		lblMessage.setForeground(Color.green);
				} else {
					//l'animal n'a pas ??t?? trouv??
					lblMessage.setText("Animal non trouv??");
					lblMessage.setForeground(Color.red);
				}
			
			} else {
				//l'animal n'a pas ??t?? trouv??
				lblMessage.setText("Animal non trouv??");
				lblMessage.setForeground(Color.red);
			}
			
			
		}

		
		
		public void supprimerAnimal() {
			// TODO Auto-generated method stub
			
		}

}

	
