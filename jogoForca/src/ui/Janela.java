package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jogoForca.Forca;
import jogoForca.Jogo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Janela {

	private JFrame frame;
	private JTextField letraEscolhidaTF;
	private Jogo jogo = new Jogo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela window = new Janela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Janela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 654, 369);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Início", null, panel_1, null);
		panel_1.setLayout(null);
			
		ButtonGroup categorias = new ButtonGroup();
		
		JRadioButton filmesRbtn = new JRadioButton("Filmes");
		filmesRbtn.setBounds(290, 87, 109, 23);
		panel_1.add(filmesRbtn);
		
		JRadioButton novelasRbtn = new JRadioButton("Novelas");
		novelasRbtn.setBounds(290, 123, 109, 23);
		panel_1.add(novelasRbtn);
		
		JRadioButton carrosRbtn = new JRadioButton("Carros");
		carrosRbtn.setBounds(290, 164, 109, 23);
		panel_1.add(carrosRbtn);
		
		categorias.add(filmesRbtn);
		categorias.add(novelasRbtn);
		categorias.add(carrosRbtn);
		
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Jogo", null, panel, null);
		panel.setLayout(null);
		
		Forca forcaPanel = new Forca();
		forcaPanel.setBounds(10, 10, 250, 250);
		panel.add(forcaPanel);
		
		JLabel lblNewLabel = new JLabel("Letra:");
		lblNewLabel.setBounds(376, 86, 46, 14);
		panel.add(lblNewLabel);
		
		letraEscolhidaTF = new JTextField();
		letraEscolhidaTF.setBounds(441, 83, 161, 20);
		panel.add(letraEscolhidaTF);
		letraEscolhidaTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Já foram sorteadas:");
		lblNewLabel_1.setBounds(376, 136, 174, 14);
		panel.add(lblNewLabel_1);
		

		JLabel textoEscondidoLabel = new JLabel("");
		textoEscondidoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		textoEscondidoLabel.setBounds(10, 287, 250, 14);
		panel.add(textoEscondidoLabel);
		
		JLabel letrasEscolhidasLabel = new JLabel("");
		letrasEscolhidasLabel.setBounds(376, 161, 226, 52);
		panel.add(letrasEscolhidasLabel);
		
		JButton btnNewButton = new JButton("INICIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String categoriaSelecionada = null;
				
				try {
					if(filmesRbtn.isSelected()) {
						categoriaSelecionada = "Filmes";
					}else if(novelasRbtn.isSelected()) {
						categoriaSelecionada = "Novelas";
					}else if(carrosRbtn.isSelected()) {
						categoriaSelecionada = "Carros";
					}
						
					jogo.setItemSelecionado(categoriaSelecionada);
						
					textoEscondidoLabel.setText(jogo.getPalavraEscondida());
					
				}catch(NullPointerException e3) {
					JOptionPane.showMessageDialog(null,"Você deve escolher uma opção");
				}
			
			}
		});
		btnNewButton.setBounds(239, 209, 160, 40);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("JOGAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					jogo.setLetraEscolhida(letraEscolhidaTF.getText());
					letrasEscolhidasLabel.setText(jogo.getLetrasEscolhidas());
					
					
					if(jogo.temLetra(letraEscolhidaTF.getText())) {
						textoEscondidoLabel.setText(jogo.getPalavraEscondida());
					}else {
						//desenhar na forca
					}
					
				}catch(Exception e9){
					JOptionPane.showMessageDialog(null,"Você deve escolher uma letra");
				}
				
				
			}
		});
		btnNewButton_1.setBounds(321, 238, 328, 23);
		panel.add(btnNewButton_1);
		
	}
}
