package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import arvoreGenealogica.Filho;
import arvoreGenealogica.Pessoa;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class arvoreInterface {

	private JFrame frame;
	private JTextField descendenteField;
	private char generoSelecionado;
	private String nomeSelecionadoComboBox;
	private JComboBox<String> comboBox;
	private JEditorPane editorPane;
	private Filho joao = new Filho("Joao", null);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					arvoreInterface window = new arvoreInterface();
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
	public arvoreInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add(joao.getNome());
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Familiares: ");
		lblNewLabel.setBounds(19, 54, 70, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		String[] nomesFamilia = nomes.toArray(new String[nomes.size()]);
		
		comboBox = new JComboBox<>(nomesFamilia);
		comboBox.setBounds(80, 50, 107, 22);
		comboBox.addActionListener((e) -> {
				
			ArrayList<String> ascendentes = new ArrayList<String>();
			Pessoa p = joao.findByName((String)comboBox.getSelectedItem());
			
			if(p != null) {
				p.ListarAscendentes(ascendentes);
				String ascendentesStr = ascendentes.stream()
					.collect(Collectors.joining("\n"));
				
				editorPane.setText(ascendentesStr);
				/*
				Sem utilizar Stream:
				
				StringBuilder strEditorPane = new StringBuilder();
				for(String ascendente : ascendentes) {
					strEditorPane.append(ascendentes).append("\n");
				}
				editorPane.setText(strEditorPane.toString());
				*/

			}
				
		});

		
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Descendente: ");
		lblNewLabel_1.setBounds(209, 54, 76, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		descendenteField = new JTextField();
		descendenteField.setBounds(295, 51, 107, 20);
		frame.getContentPane().add(descendenteField);
		descendenteField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Genero: ");
		lblNewLabel_2.setBounds(19, 106, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton masculinoButton = new JRadioButton("Masculino");
		masculinoButton.setBounds(97, 102, 90, 23);
		frame.getContentPane().add(masculinoButton);
		
		JRadioButton femininoButton = new JRadioButton("Feminino");
		femininoButton.setBounds(189, 102, 109, 23);
		frame.getContentPane().add(femininoButton);
		
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(femininoButton);
		grupoGenero.add(masculinoButton);
		
		masculinoButton.addActionListener(e -> {
            if (masculinoButton.isSelected()) {
                generoSelecionado = 'M';
                
            }
        });

        femininoButton.addActionListener(e -> {
            if (femininoButton.isSelected()) {
                generoSelecionado = 'F';
                
            }
        });
		
		JButton criarDescendenteButton = new JButton("Criar descendente");
		criarDescendenteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeDescendente = descendenteField.getText();
				nomeSelecionadoComboBox = (String) comboBox.getSelectedItem();
				
				Pessoa p = joao.findByName(nomeSelecionadoComboBox);
				if(p != null){
					
					Pessoa d;
					try {
						d = p.cadastrarFilho(nomeDescendente, generoSelecionado);
						
						if(d != null) {
							comboBox.addItem(d.getNome());
						}
						
					} catch (Exception e1) {
						
						JOptionPane.showMessageDialog(null, "Natimortos não podem cadastrar filhos.");
					}
					
			
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Parente não encontrado");
				}
				
				
			}
		});
		
		
		
		criarDescendenteButton.setBounds(139, 150, 159, 23);
		frame.getContentPane().add(criarDescendenteButton);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(19, 194, 389, 91);
		frame.getContentPane().add(editorPane);
	}
}
