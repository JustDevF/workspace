package ihm_menagerie;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Afficher extends JFrame implements ActionListener{
	private JPanel monPanel;
	private JPanel monPanel3;
	private JLabel lblNom;
	

	private JButton btnAnnuler;
	
 public Afficher(Menagerie uneMenagerie) {
		
		this.setTitle("Afficher");
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		monPanel = new JPanel();
		monPanel3 = new JPanel();
		if(uneMenagerie.getNombreAnimaux()==0) {
			lblNom = new JLabel("La ménagerie est vide" );
		}
		else {
			lblNom = new JLabel(uneMenagerie.presenter());
		}
		btnAnnuler = new JButton("Retour");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				dispose();					}
		});
		

		
		monPanel.add(lblNom);

		
	
		monPanel3.add(btnAnnuler);
		
		
		//btnValider.addActionListener(this);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(monPanel);
		this.add(monPanel, BorderLayout.NORTH);
		
		this.add(monPanel3, BorderLayout.CENTER);
		
		monPanel.setLayout(new GridLayout(0, 1));
		

		this.setLayout(new GridLayout(2, 2));

		setVisible(true);
		
 	}
 	
	

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
		
}

}
