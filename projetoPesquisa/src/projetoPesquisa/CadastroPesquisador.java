package projetoPesquisa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroPesquisador {

	private JFrame frame;
	private JTextField nomePesquisadorTF;
	private JTextField QtdPesquisadoresTF;
	private JTextField valorPagoTF;
	private JComboBox<String> tipoPesquisadorCB;
	private JComboBox<String> coordenadorCB;
	private JComboBox<String> nomePesquisadorCB;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPesquisador window = new CadastroPesquisador();
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
	public CadastroPesquisador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ProjetoPesquisa projeto = new ProjetoPesquisa();
		Coordenador lider = new Coordenador("Mara Andrade", null);
		projeto.setLider(lider);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(21, 28, 380, 300);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastrar Funcionario", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Pesquisador: ");
		lblNewLabel.setBounds(24, 46, 95, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setBounds(24, 100, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Coordenador");
		lblNewLabel_2.setBounds(24, 159, 67, 14);
		panel.add(lblNewLabel_2);
		
		JButton CadastrarButton = new JButton("Cadastrar");
		CadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomePesquisador = nomePesquisadorTF.getText();
				String tipoPesquisador = (String) tipoPesquisadorCB.getSelectedItem();
				String coordenadorStr = (String)coordenadorCB.getSelectedItem();
				Pesquisador novoPesquisador;

				
				try {
					Coordenador coordenador = (Coordenador) projeto.lider.findPesquisador(coordenadorStr);
					
					if(tipoPesquisador.equals("Professor")) {
						novoPesquisador = new Professor(nomePesquisador,(Pesquisador) coordenador);
						projeto.cadastrarPesquisador(novoPesquisador, coordenador);
						nomePesquisadorCB.addItem(novoPesquisador.getNome());
					}else if(tipoPesquisador.equals("Coordenador")) {
						novoPesquisador = new Coordenador(nomePesquisador,(Pesquisador) coordenador);
						projeto.cadastrarPesquisador(novoPesquisador, coordenador);
						coordenadorCB.addItem(novoPesquisador.getNome());
						nomePesquisadorCB.addItem(novoPesquisador.getNome());
					}
					JOptionPane.showMessageDialog(null, "Pesquisador cadastrado com sucesso");
					
				}catch(ClassCastException e1) {
					JOptionPane.showMessageDialog(null, "O pesquisador selecionado não é um coordenador");
				}
				
				
				
				
			}
		});
		CadastrarButton.setBounds(24, 213, 89, 23);
		panel.add(CadastrarButton);
		
		nomePesquisadorTF = new JTextField();
		nomePesquisadorTF.setBounds(129, 43, 209, 20);
		panel.add(nomePesquisadorTF);
		nomePesquisadorTF.setColumns(10);
		
		
		String[] tiposPesquisador = {"Professor", "Coordenador"};
		tipoPesquisadorCB = new JComboBox<String>(tiposPesquisador);
		tipoPesquisadorCB.setBounds(129, 96, 209, 22);
		panel.add(tipoPesquisadorCB);
		
		
		
		coordenadorCB = new JComboBox<String>(projeto.listcoordenadores());
		coordenadorCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		coordenadorCB.setToolTipText("");
		coordenadorCB.setBounds(129, 155, 209, 22);
		panel.add(coordenadorCB);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consultas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nome Pesquisador: ");
		lblNewLabel_3.setBounds(24, 46, 101, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Qtd de Pesquisadores: ");
		lblNewLabel_4.setBounds(24, 166, 127, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Valor Pago:");
		lblNewLabel_5.setBounds(24, 206, 78, 14);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Consulta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisador p = projeto.lider.findPesquisador((String)nomePesquisadorCB.getSelectedItem());

				valorPagoTF.setText(String.format("%.1f", p.getValorPago()));
				QtdPesquisadoresTF.setText(String.valueOf(p.getQtdSubordinados()));
			}
		});
		btnNewButton.setBounds(24, 100, 89, 23);
		panel_1.add(btnNewButton);
		
		nomePesquisadorCB = new JComboBox<String>(projeto.listPesquisadores());
		nomePesquisadorCB.setBounds(161, 42, 159, 22);
		panel_1.add(nomePesquisadorCB);
		
		QtdPesquisadoresTF = new JTextField();
		QtdPesquisadoresTF.setBounds(161, 163, 159, 20);
		panel_1.add(QtdPesquisadoresTF);
		QtdPesquisadoresTF.setColumns(10);
		
		valorPagoTF = new JTextField();
		valorPagoTF.setBounds(161, 203, 159, 20);
		panel_1.add(valorPagoTF);
		valorPagoTF.setColumns(10);
	}
}
