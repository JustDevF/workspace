package ihm_menagerie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener{
	private JPanel monPanel;
	private JPanel monPanel1;
	private JLabel lblMessage;
	
	
	public Menu(Menagerie uneMenagerie) {
		
		
		this.setTitle("Fenetre Menu");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(new Dimension(2000,400)); 
		
		// Barre Menu
		JMenuBar menu = new JMenuBar();
				
		// Partie Ajout de animal
		JMenu menuAn = new JMenu("Ajouter un Animal");
				
		//Element de l'ajout
		JMenuItem chat = new JMenuItem("Chat");
		menuAn.add(chat);
		chat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				//	dispose();	
					Chat fenetre = new Chat(uneMenagerie); 
			} 
		});
				
		JMenuItem chien = new JMenuItem("Chien");
		menuAn.add(chien);
		chien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
					dispose();	
					Chien fenetre = new Chien(uneMenagerie); 
			} 
		});
				
				
		menu.add(menuAn);
		
		// Partie Affichage de vetement
		JMenu menuAffichage = new JMenu("Menagerie");
		
		// Element de l'affichage
		JMenuItem afficheMenagerie = new JMenuItem("Les animaux présents");
		menuAffichage.add(afficheMenagerie);
		afficheMenagerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				 dispose();	
				 Afficher fenetre = new Afficher(uneMenagerie); 
			} 
		});
		
		//quitter.addActionListener(new());
		JMenuItem nbAnimaux= new JMenuItem("Nombre d'animaux");
		menuAffichage.add(nbAnimaux);
		nbAnimaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				 dispose();	
				 NombreAnimaux fenetre = new NombreAnimaux(uneMenagerie); 
			} 
		});
		
		menu.add(menuAffichage);
		
		// Partie Suppression
		JMenu menuSupprimer = new JMenu("Supprimer");
		
		// Element de Suppression
		JMenuItem suppAnimal = new JMenuItem("Supprimer un Animal");
		menuSupprimer.add(suppAnimal);
		suppAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				 dispose();	
				 SupprimerAnimal fenetre = new SupprimerAnimal(uneMenagerie); 
			} 
		});
		
		menu.add(menuSupprimer);
		
		// Partie Recherche
		JMenu menuRechercher = new JMenu("Rechercher");
		
		// Element de Recherche
		JMenuItem rechercheAnimal = new JMenuItem("Rechercher un animal");
		menuRechercher.add(rechercheAnimal);
		rechercheAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				 dispose();	
				 RechercherAnimal fenetre = new RechercherAnimal(uneMenagerie); 
			} 
		});
		
		menu.add(menuRechercher);
		
		
		this.setJMenuBar(menu);
		lblMessage = new JLabel("Bienvenue dans le Menu Menagerie:");
		
		

		
		monPanel1 = new JPanel();
		
		
		monPanel1.add(lblMessage);
		
		
		//monPanel.setLayout(new GridLayout(0, 1));
		this.getContentPane().add(monPanel1);
		
		
		this.add(monPanel1, BorderLayout.NORTH);
		
		
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}