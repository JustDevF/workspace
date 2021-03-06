package tp_ihm_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Fenetre2 extends JFrame implements ActionListener{
	private JPanel monPanel;
	private JPanel pannelHaut1;
	private JPanel pannelHaut;
	private JPanel pannelBas;
	private JButton btnRouge;
	private JButton btnVert;
	private JButton btnBleu;
	private JButton btnJaune;
	private JLabel accueilMenagerie;
	private Menagerie MaMenagerie;
	
	
	//constructeur
	public Fenetre2(Menagerie MaMenagerie) {
		this.MaMenagerie = MaMenagerie;
		
        //Titre
        this.setTitle("Fenetre exercice 2"); 
        
        //Localisation de la fenêtre (null = milieu)
        this.setLocationRelativeTo(null);
        
        //Arrêt du programme quand la croix "fermer" est cliquée
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Taille
        this.setSize(800, 600);
        this.setResizable(true); //<---Redimension de la taille de la fenêtre possible
        
        monPanel = new JPanel ( ) ;
        pannelHaut = new JPanel ( ) ;
        pannelHaut1 = new JPanel ( ) ;
        pannelBas = new JPanel ( ) ;
        
        monPanel.setLayout(new BorderLayout());
        
        pannelHaut.setLayout(new FlowLayout());
        pannelHaut.setBackground(Color.white);
        
        pannelHaut1.setLayout(new FlowLayout());
        pannelHaut1.setBackground(Color.gray);
        //1.Nom 
        accueilMenagerie = new JLabel("\"**Bienvenue au M?nagerie**\"");
        pannelHaut1.add(accueilMenagerie);
        
        pannelBas.setBackground(Color.red);
        
        //les boutons
        btnRouge = new JButton("Rouge");
        btnVert = new JButton("Vert");
        btnBleu = new JButton("Bleu");
        btnJaune = new JButton("Jaune");
        
        btnRouge.addActionListener(this);
        btnVert.addActionListener(this);
        btnBleu.addActionListener(this);
        btnJaune.addActionListener(this);
        
        pannelHaut.add(btnRouge);
        pannelHaut.add(btnVert);
        pannelHaut.add(btnBleu);
        pannelHaut.add(btnJaune);
        monPanel.add(pannelHaut, BorderLayout.NORTH);
        monPanel.add(pannelBas, BorderLayout.CENTER);
        
        this.setAlwaysOnTop(true);
        this.getContentPane().add(monPanel); // UN SEUL PANNEL DANS LE GET CONTENT
        this.getContentPane().add(pannelHaut);
        this.getContentPane().add(pannelHaut1);
        this.setVisible(true);
	}
    public void actionPerformed ( ActionEvent evenement) {
    	if(evenement.getSource() == btnRouge) {
    		pannelBas.setBackground(Color.red);
    		btnRouge.setEnabled(false);
    		btnVert.setEnabled(true);
    		btnBleu.setEnabled(true);
    		btnJaune.setEnabled(true);
    	
    	}
    	else {
    		if(evenement.getSource() == btnVert){
    			pannelBas.setBackground(Color.green);
    			btnRouge.setEnabled(true);
        		btnVert.setEnabled(false);
        		btnBleu.setEnabled(true);
        		btnJaune.setEnabled(true);
    			
        
    		}
    		else {
    			if(evenement.getSource() == btnBleu) {
    				pannelBas.setBackground(Color.blue);
    				btnRouge.setEnabled(true);
            		btnVert.setEnabled(true);
            		btnBleu.setEnabled(false);
            		btnJaune.setEnabled(true);
    	  
    			}
    			else {
    				pannelBas.setBackground(Color.yellow);
    				pannelBas.setBackground(Color.yellow);
    				btnRouge.setEnabled(true);
            		btnVert.setEnabled(true);
            		btnBleu.setEnabled(true);
            		btnJaune.setEnabled(false);
   
    			}
    			
    		}
    		
    	}
    }

}
