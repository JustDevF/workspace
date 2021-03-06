package fenetres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import classesLogiques.Utilisateur;



import java.awt.Toolkit;

import dialogue.UI;
import java.awt.Font;



//La fenêtre de connexion
public class Fconnexion extends JFrame {
	private static final long serialVersionUID = 1L;
	//Attrobut d'instance
	private JTextField txtSaisieUtilisateur;
	private JPasswordField pwdMotDePasse;
	private JButton btnValider;
	
	
	//Attributs d'Actions
	private final Action ActionCreerCompte = new ActionInscription();
	private final Action ActionValide = new ActionValider();
	
	//Effacez la méthode main() de la classe pour éviter la prolifération de ces méthodes
	
	//le lanceur de l'application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fconnexion frame = new Fconnexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//le constructeur
	public Fconnexion() {
		//appel de la méthode pour afficher la fenêtre
		createContents();
	}
	
	//méthode d'instance
	private void createContents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fconnexion.class.getResource("/images/connection/Windows-8-Login-16.png")));
		setTitle("Gestion");
		
		JLabel lblTitre = new JLabel("Connexion au programme");
		lblTitre.setFont(lblTitre.getFont().deriveFont(20f));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTitre.setIcon(new ImageIcon(Fconnexion.class.getResource("/images/connection/Shopping-Cart-05-48.png")));
		getContentPane().add(lblTitre, BorderLayout.NORTH);
		
		JPanel panel_global = new JPanel();
		panel_global.setBorder(new CompoundBorder(new EmptyBorder(14, 14, 14, 14), new LineBorder(new Color(0x33, 0XB5, 0XE5), 3, true)));
		getContentPane().add(panel_global, BorderLayout.CENTER);
		panel_global.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_connexion = new JPanel();
		panel_connexion.setBackground(Color.WHITE);
		panel_connexion.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_global.add(panel_connexion);
		GridBagLayout gbl_panel_connexion = new GridBagLayout();
		gbl_panel_connexion.columnWidths = new int[]{134, 525, 0};
		gbl_panel_connexion.rowHeights = new int[]{26, 26, 66, 0};
		gbl_panel_connexion.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_connexion.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_connexion.setLayout(gbl_panel_connexion);
		
		JLabel lblUtilisateur = new JLabel("Identifiant");
		lblUtilisateur.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUtilisateur.setHorizontalTextPosition(SwingConstants.LEADING);
		lblUtilisateur.setIcon(new ImageIcon(Fconnexion.class.getResource("/images/connection/Windows-8-Login-16.png")));
		GridBagConstraints gbc_lblUtilisateur = new GridBagConstraints();
		gbc_lblUtilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUtilisateur.anchor = GridBagConstraints.LINE_END;
		gbc_lblUtilisateur.insets = new Insets(0, 0, 5, 5);
		gbc_lblUtilisateur.gridx = 0;
		gbc_lblUtilisateur.gridy = 0;
		panel_connexion.add(lblUtilisateur, gbc_lblUtilisateur);
		UI.habiller(lblUtilisateur);
		
		txtSaisieUtilisateur = new JTextField();
		GridBagConstraints gbc_txtSaisieUtilisateur = new GridBagConstraints();
		gbc_txtSaisieUtilisateur.weightx = 1.0;
		gbc_txtSaisieUtilisateur.anchor = GridBagConstraints.NORTH;
		gbc_txtSaisieUtilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSaisieUtilisateur.insets = new Insets(0, 0, 5, 0);
		gbc_txtSaisieUtilisateur.gridx = 1;
		gbc_txtSaisieUtilisateur.gridy = 0;
		panel_connexion.add(txtSaisieUtilisateur, gbc_txtSaisieUtilisateur);
		txtSaisieUtilisateur.setColumns(10);
		UI.habiller(txtSaisieUtilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMotDePasse.setHorizontalTextPosition(SwingConstants.LEADING);
		lblMotDePasse.setIcon(new ImageIcon(Fconnexion.class.getResource("/images/connection/Key-16.png")));
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMotDePasse.anchor = GridBagConstraints.LINE_END;
		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotDePasse.gridx = 0;
		gbc_lblMotDePasse.gridy = 1;
		panel_connexion.add(lblMotDePasse, gbc_lblMotDePasse);
		UI.habiller(lblMotDePasse);
		
		pwdMotDePasse = new JPasswordField();
		UI.habiller(pwdMotDePasse);
		GridBagConstraints gbc_pwdMotDePasse = new GridBagConstraints();
		gbc_pwdMotDePasse.weightx = 1.0;
		gbc_pwdMotDePasse.anchor = GridBagConstraints.NORTH;
		gbc_pwdMotDePasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdMotDePasse.insets = new Insets(0, 0, 5, 0);
		gbc_pwdMotDePasse.gridx = 1;
		gbc_pwdMotDePasse.gridy = 1;
		panel_connexion.add(pwdMotDePasse, gbc_pwdMotDePasse);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setText("Veuillez saisir le nom de l'utilisateur et le mot de passe pour accéder à l'application.\r\n\r\nSi vous n'avez pas un compte. Créer un compte ici :\r\n");
		txtpnInfo.setForeground(Color.GRAY);
		txtpnInfo.setBackground(Color.WHITE);
		GridBagConstraints gbc_txtpnInfo = new GridBagConstraints();
		gbc_txtpnInfo.insets = new Insets(5, 0, 0, 0);
		gbc_txtpnInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnInfo.gridwidth = 2;
		gbc_txtpnInfo.gridx = 0;
		gbc_txtpnInfo.gridy = 2;
		panel_connexion.add(txtpnInfo, gbc_txtpnInfo);
		UI.habiller(txtpnInfo);
		
		JPanel panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel_actions, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_actions = new GridBagLayout();
		gbl_panel_actions.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_actions.rowHeights = new int[]{0, 0, 0};
		gbl_panel_actions.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_actions.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_actions.setLayout(gbl_panel_actions);
		
		JButton btnParamtres = new JButton("Paramètres");
		btnParamtres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parametres();
			}
		});
		
		//boutin d'action créer un compte
		JButton btnNewButton = new JButton("Créer un compte");
		btnNewButton.setAction(ActionCreerCompte);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_actions.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.setFont(new Font("Roboto Lt", Font.PLAIN, 15));
		btnParamtres.setIcon(new ImageIcon(Fconnexion.class.getResource("/images/connection/Customize-01-48.png")));
		UI.deshabillerBouton(btnParamtres, "connection", "Customize-01");
		GridBagConstraints gbc_btnParamtres = new GridBagConstraints();
		gbc_btnParamtres.anchor = GridBagConstraints.LINE_START;
		gbc_btnParamtres.weightx = 1.0;
		gbc_btnParamtres.insets = new Insets(0, 0, 0, 5);
		gbc_btnParamtres.gridx = 0;
		gbc_btnParamtres.gridy = 1;
		panel_actions.add(btnParamtres, gbc_btnParamtres);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quitter();
			}
		});
		btnQuitter.setIcon(new ImageIcon(Fconnexion.class.getResource("/images/connection/Stop-48.png")));
		UI.deshabillerBouton(btnQuitter, "connection", "Stop");
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuitter.gridx = 1;
		gbc_btnQuitter.gridy = 1;
		panel_actions.add(btnQuitter, gbc_btnQuitter);
		
		btnValider = new JButton("Valider");
		btnValider.setAction(ActionValide);
		btnValider.setHorizontalTextPosition(SwingConstants.LEADING);
		btnValider.setIcon(new ImageIcon(Fconnexion.class.getResource("/images/connection/Power-48.png")));
		UI.deshabillerBouton(btnValider, "connection", "Power");
		btnValider.setOpaque(true);
		btnValider.setBackground(new Color(0x33, 0xB5, 0xE5));
		btnValider.setForeground(Color.WHITE);
		
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.gridx = 2;
		gbc_btnValider.gridy = 1;
		panel_actions.add(btnValider, gbc_btnValider);
		
		getRootPane().setDefaultButton(btnValider);
		pack();
		setSize(719, 426);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	//Les actions
	
	//Action de valider la connexion
	private class ActionValider extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionValider() {
			putValue(NAME, "Valider");
			putValue(SHORT_DESCRIPTION, "Se connecter à l'application");
		}
		public void actionPerformed(ActionEvent e) {
			valider();
		}
	}
	
	//Action de s'inscrire
	private class ActionInscription extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ActionInscription() {
			putValue(NAME, "Inscription");
			putValue(SHORT_DESCRIPTION, "S'inscrire pour utiliser l'applciation");
		}
		public void actionPerformed(ActionEvent e) {
			inscription();
		}
	}
	
	
	//méthode d'instance servant de méthodes d'appel aux actions
	
		protected void parametres() {
			// TODO Auto-generated method stub
			
		}

		public void inscription() {
		//fermer la page de connexion 
		//rédiriger l'utilisateur dans le panneau d'inscription
		
	}


		/*
		private void parametres() {
			FParametres laFenetre = new FParametres();
			laFenetre.setVisible(true);
		}
		*/
		
		private void quitter() {
			dispose();
		}
		
		
		private void valider() {
			//valider la connexion de l'utilisateur
			
			//récupération de saisie
			String leNom = txtSaisieUtilisateur.getText();
			
			// convertir le tableau de caractères en chaîne de caractères
			String leMotDePasse = String.valueOf(pwdMotDePasse.getPassword());
			
			if(leNom != null & leMotDePasse != null) {
				//connexion
				try {
					//instanciation un utilisateur
					Utilisateur unUser = new Utilisateur (leNom, leMotDePasse);
					unUser.inscriptionUtilisateur(unUser);
					
					boolean valide = unUser.rechercherUtilisateur(unUser);
				
					if (valide) { 
			            //connexion réuissie
						btnValider.setEnabled(false);
						Fconnexion.this.dispose();
						
						//rédiriger l'utilisateur vers la fenêtre menagerie
						afficherMenagerie();
			        } else { 
			            //connexion échouée
			        	
			        } 				
				} catch (Exception e) { 
					// impossible de se connecter à la base
						e.printStackTrace(); 
			    }
			}
			
	
		}
		
		
		protected void afficherMenagerie() {
			JDialog FMenagerie = new JDialog();
			PMenagerie menagerie = new PMenagerie();
			//créer une fenêtre pour l'instance du panneau PMenagerieAjouterChat
			
			//propriétés du fenêtre
			//ajouter le panneau au fenêtre
			menagerie.setFenetre(FMenagerie);
			FMenagerie.setContentPane(menagerie);
			//
			//FClients.setIconImage(Toolkit.getDefaultToolkit().getImage(FAccueil.class.getResource("/images/accueil/Shopping-Bag-128.png")));
			FMenagerie.setTitle("Gestion des animaux"); 
			FMenagerie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			FMenagerie.setBounds(100, 100, 1000, 700);
			FMenagerie.setLocationRelativeTo(null); 
		    //afficher la fenêtre 
			FMenagerie.setVisible(true); 
		}
}
