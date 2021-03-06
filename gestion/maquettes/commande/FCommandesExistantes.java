package commande;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import dialogue.UI;
import java.awt.Toolkit;

//Cette fenêtre permet de gérer le fichier des commandes passées
public class FCommandesExistantes extends JDialog {
	private static final long serialVersionUID = 1L;
	
	//Attribut d'instance graphique
	private JPanel contentPane;
	private JLabel txtTotalcommandes;
	private JTextField txtRecherche;
	private JTable table;
	
	/**
	 * Lanceur de la'application.
	 */
	public static void main(String[] args) {
		try {
			FCommandesExistantes dialog = new FCommandesExistantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Création d'une dialogue
	 */
	//le constructeur
	public FCommandesExistantes() {
		//propriétes de la fenêtre 
		setIconImage(Toolkit.getDefaultToolkit().getImage(FCommandesExistantes.class.getResource("/images/gestion/commande/Shopping-Bag-64-actif.png")));
		setTitle("Gestion des Commandes Existantes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		
		//panneau principal
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xFF, 0xBB, 0x33));
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		///Panneau menu situé à gauche du panneau principal
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(0xFF, 0x88, 0x00));
		contentPane.add(panel_menu, BorderLayout.WEST);
		panel_menu.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5,
				5)));
		GridBagLayout gbl_panel_menu = new GridBagLayout();
		gbl_panel_menu.columnWidths = new int[] { 0, 0 };
		gbl_panel_menu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_menu.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_menu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_menu.setLayout(gbl_panel_menu);
		
		//titre du panneau 
		JLabel lblTitre = new JLabel("Commandes");
		lblTitre.setIcon(new ImageIcon(
				FCommandesExistantes.class
						.getResource("/images/gestion/commande/Shopping-Bag-64-actif.png")));
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.insets = new Insets(0, 0, 15, 20);
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
		panel_menu.add(lblTitre, gbc_lblTitre);
		lblTitre.setFont(lblTitre.getFont().deriveFont(25f));
		
		//Actions disponibles 
		
		//Action btnSupprimerToutesLignes
		JButton btnSupprimerToutesLignes = new JButton("SupprimerToutesLignes");
		btnSupprimerToutesLignes.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnSupprimertouteslignes = new GridBagConstraints();
		gbc_btnSupprimertouteslignes.anchor = GridBagConstraints.LINE_START;
		gbc_btnSupprimertouteslignes.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimertouteslignes.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimertouteslignes.gridx = 0;
		gbc_btnSupprimertouteslignes.gridy = 4;
		panel_menu.add(btnSupprimerToutesLignes, gbc_btnSupprimertouteslignes);
		btnSupprimerToutesLignes.setIcon(new ImageIcon(FCommandesExistantes.class
				.getResource("/images/gestion/Garbage-Open-48.png")));
		UI.deshabillerBouton(btnSupprimerToutesLignes, "Garbage-Open");
		
		//Action apercu
		JButton btnApercu = new JButton("Apercu");
		btnApercu.setForeground(Color.WHITE);
		btnApercu.setHorizontalAlignment(SwingConstants.LEFT);
		btnApercu.setIcon(new ImageIcon(FCommandesExistantes.class
				.getResource("/images/gestion/Preview-48.png")));
		GridBagConstraints gbc_btnApercu = new GridBagConstraints();
		gbc_btnApercu.weighty = 1.0;
		gbc_btnApercu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnApercu.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnApercu.insets = new Insets(0, 0, 5, 0);
		gbc_btnApercu.gridx = 0;
		gbc_btnApercu.gridy = 6;
		panel_menu.add(btnApercu, gbc_btnApercu);
		UI.deshabillerBouton(btnApercu, "Preview");
		
		//Action imprimer
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnImprimer = new GridBagConstraints();
		gbc_btnImprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnImprimer.anchor = GridBagConstraints.LINE_START;
		gbc_btnImprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnImprimer.gridx = 0;
		gbc_btnImprimer.gridy = 7;
		panel_menu.add(btnImprimer, gbc_btnImprimer);
		UI.deshabillerBouton(btnImprimer, "Printer");
		
		//Action exporter
		JButton btnExport = new JButton("Export");
		btnExport.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnExport = new GridBagConstraints();
		gbc_btnExport.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExport.anchor = GridBagConstraints.LINE_START;
		gbc_btnExport.insets = new Insets(0, 0, 5, 0);
		gbc_btnExport.gridx = 0;
		gbc_btnExport.gridy = 8;
		panel_menu.add(btnExport, gbc_btnExport);
		UI.deshabillerBouton(btnExport, "Data-Export");
		
		//Action rédirection accueil 
		JButton btnAccueil = new JButton("Accueil");
		//btnAccueil.setAction(actionAccueil);
		btnAccueil.setForeground(Color.WHITE);
		GridBagConstraints gbc_btnAccueil = new GridBagConstraints();
		gbc_btnAccueil.weighty = 1.0;
		gbc_btnAccueil.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnAccueil.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAccueil.gridx = 0;
		gbc_btnAccueil.gridy = 9;
		panel_menu.add(btnAccueil, gbc_btnAccueil);
		UI.deshabillerBouton(btnAccueil, "Home");
		
		//Panneau central au centre du panneau principal
		JPanel panel_principal = new JPanel();
		panel_principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_principal.setBackground(new Color(0xFF, 0xEC, 0xC0));
		contentPane.add(panel_principal, BorderLayout.CENTER);
		GridBagLayout gbl_panel_principal = new GridBagLayout();
		gbl_panel_principal.columnWidths = new int[] {0, 0, 0, 0};
		gbl_panel_principal.rowHeights = new int[] {0, 0};
		gbl_panel_principal.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0 };
		gbl_panel_principal.rowWeights = new double[] { 1.0, 0.0 };
		panel_principal.setLayout(gbl_panel_principal);
		
		//Apnneau scoller
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_principal.add(scrollPane, gbc_scrollPane);
		
		//table
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//champs Total des commandes
		JLabel lblTotalCommandes = new JLabel("Total des Commandes");
		GridBagConstraints gbc_lblTotalCommandes = new GridBagConstraints();
		gbc_lblTotalCommandes.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalCommandes.anchor = GridBagConstraints.EAST;
		gbc_lblTotalCommandes.gridx = 0;
		gbc_lblTotalCommandes.gridy = 1;
		panel_principal.add(lblTotalCommandes, gbc_lblTotalCommandes);
		UI.habiller(lblTotalCommandes);
		
		txtTotalcommandes = new JLabel();
		txtTotalcommandes.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalcommandes.setText("0,00");
		GridBagConstraints gbc_txtTotalcommandes = new GridBagConstraints();
		gbc_txtTotalcommandes.insets = new Insets(0, 0, 0, 5);
		gbc_txtTotalcommandes.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalcommandes.gridx = 1;
		gbc_txtTotalcommandes.gridy = 1;
		panel_principal.add(txtTotalcommandes, gbc_txtTotalcommandes);
		UI.habiller(txtTotalcommandes);
		
		//champs de recherche
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setIcon(new ImageIcon(FCommandesExistantes.class.getResource("/images/gestion/Search-48.png")));
		GridBagConstraints gbc_lblRecherche = new GridBagConstraints();
		gbc_lblRecherche.insets = new Insets(0, 20, 0, 5);
		gbc_lblRecherche.anchor = GridBagConstraints.EAST;
		gbc_lblRecherche.gridx = 2;
		gbc_lblRecherche.gridy = 1;
		panel_principal.add(lblRecherche, gbc_lblRecherche);
		UI.habiller(lblRecherche);
		
		txtRecherche = new JTextField();
		GridBagConstraints gbc_txtRecherche = new GridBagConstraints();
		gbc_txtRecherche.weightx = 3.0;
		gbc_txtRecherche.fill = GridBagConstraints.BOTH;
		gbc_txtRecherche.gridx = 3;
		gbc_txtRecherche.gridy = 1;
		panel_principal.add(txtRecherche, gbc_txtRecherche);
		txtRecherche.setColumns(10);
		UI.habiller(txtRecherche);

		SwingUtilities.invokeLater(() -> btnAccueil.requestFocusInWindow());
	}

}
