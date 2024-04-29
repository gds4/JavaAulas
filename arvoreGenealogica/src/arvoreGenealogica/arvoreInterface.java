package arvoreGenealogica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class arvoreInterface {

	private JFrame frame;
	private JTextField descendenteField;
	private char generoSelecionado;
	private String nomeSelecionadoComboBox;
	private JComboBox<String> comboBox;
	private JEditorPane editorPane;
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
		Filho anciao = new Filho("anciao", null);
		anciao.cadastrarFilho("Joao", 'M');
		ArrayList<String> nomes = new ArrayList<String>();
		anciao.ListarDescendentes(nomes);
		
		
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
		comboBox.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<String> descendentes = new ArrayList<String>();
				anciao.findDescendente((String)comboBox.getSelectedItem()).ListarDescendentes(descendentes);
				StringBuilder strEditorPane = new StringBuilder();
				for(String descendente : descendentes) {
					strEditorPane.append(descendente).append("\n");
				}
				editorPane.setText(strEditorPane.toString());
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
				System.out.println(generoSelecionado);
				System.out.println(nomeSelecionadoComboBox);
				
				Pessoa p = anciao.findDescendente(nomeSelecionadoComboBox);
				if(p != null){
					
					Pessoa d = p.cadastrarFilho(nomeDescendente, generoSelecionado);
					if(d != null) {
						comboBox.addItem(d.getNome());
					}
			
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Erro");
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
