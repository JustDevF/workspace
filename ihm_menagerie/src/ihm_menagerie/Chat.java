package ihm_menagerie;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class Chat extends JFrame implements ActionListener{
	private JPanel monPanel;
	
	private JPanel monPanelBtn;
	private JLabel lblNom;
	private JTextField jtfNom;
	private JLabel lblRace;
	private JTextField jtfRace;
	private JLabel lblAge;
	private JTextField jtfAge;
	private JButton btnValider;
	private JButton btnAnnuler;
	private AbstractButton jtfEspece;

	
 public Chat(Menagerie uneMenagerie) {
		this.setTitle("Ajouter un chat");
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		monPanel = new JPanel();
		monPanelBtn = new JPanel();
		
		lblNom = new JLabel("Nom :");
		jtfNom = new JTextField(16);
		lblRace = new JLabel("Race :");
		jtfRace = new JTextField(16);
	
		
		lblAge = new JLabel("Age :");
		jtfAge = new JTextField(16);
		btnValider = new JButton("OK");
		btnValider.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { 
				int age = Integer.parseInt(jtfAge.getText());
				String nom = jtfNom. getText();
				String espece = jtfEspece. getText();
				Chat unChat = new Chat (nom,espece);
				uneMenagerie.arriver(unChat);
				dispose();		
				Menu fenetre = new Menu(uneMenagerie);
			}
		});
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				dispose();		
				TypeAnimal fenetre = new TypeAnimal(uneMenagerie);
			}
		});
		

		
		monPanel.add(lblNom);
		monPanel.add(jtfNom);
		monPanel.add(lblRace);
		monPanel.add(jtfRace);
		monPanel.add(lblAge);
		monPanel.add(jtfAge); 
		
		monPanelBtn.add(btnValider);
		monPanelBtn.add(btnAnnuler);
		
		
		//btnValider.addActionListener(this);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(monPanel);
		this.add(monPanel, BorderLayout.NORTH);
		
		this.add(monPanelBtn, BorderLayout.SOUTH);
		
		monPanel.setLayout(new GridLayout(0, 1));
		

		this.setLayout(new GridLayout(2, 2));

		setVisible(true);
		
 	}
 	
	

public Chat(String nom, String espece) {
	// TODO Auto-generated constructor stub
}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
		
}

}