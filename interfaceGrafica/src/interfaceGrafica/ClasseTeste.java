package interfaceGrafica;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ClasseTeste {
	public static void main(String[] args) {
		
		JFrame j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton bS = new JButton("botão sul");
		JButton bN = new JButton("botão norte");
		JButton bL = new JButton("botão leste");
		JButton bO = new JButton("botão oeste");
		j.setLayout(new BorderLayout());
		j.add(bS,BorderLayout.SOUTH);
		j.add(bN,BorderLayout.NORTH);
		j.add(bL,BorderLayout.EAST);
		j.add(bO,BorderLayout.WEST);
		
		
		
		j.setTitle("Janela de Teste");
		j.setSize(600,480);
		j.setVisible(true);
		j.setLocationRelativeTo(null);
		
		
		
		
	}
}
