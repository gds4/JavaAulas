package cadastroFuncionarios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class InterfaceCadastro {

	private JFrame frame;
	private JTextField nomeFuncionarioTF;
	private JComboBox<String> nomeFuncionarioCB;
	private JComboBox<String> tipoConsultaCB;
	private JButton consultarBtn;
	private JComboBox<String> superiorCB;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCadastro window = new InterfaceCadastro();
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
	public InterfaceCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Empresa empresa = new Empresa(new Chefe("Antonio Carlos Pereira", null,true, true));
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 383, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 347, 295);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro de Funcionário", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Empregado:");
		lblNewLabel.setBounds(10, 25, 97, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Superior:");
		lblNewLabel_1.setBounds(10, 80, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Grau de Instrução:");
		lblNewLabel_2.setBounds(10, 137, 97, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setBounds(10, 213, 46, 14);
		panel.add(lblNewLabel_3);
		
		nomeFuncionarioTF = new JTextField();
		nomeFuncionarioTF.setBounds(105, 22, 210, 20);
		panel.add(nomeFuncionarioTF);
		nomeFuncionarioTF.setColumns(10);
		
		String[] listaSuperiores = empresa.listaChefes();
		superiorCB = new JComboBox<String>(listaSuperiores);
		superiorCB.setBounds(105, 76, 116, 22);
		panel.add(superiorCB);
		
		JCheckBox grau2CheckBox = new JCheckBox("2º grau");
		grau2CheckBox.setBounds(125, 133, 71, 23);
		panel.add(grau2CheckBox);
		
		JCheckBox superiorCheckBox = new JCheckBox("Superior");
		superiorCheckBox.setBounds(204, 133, 97, 23);
		panel.add(superiorCheckBox);
		
		String[] tipoFuncionario = {"Empregado", "Chefe"};
		JComboBox<String> tipoCB = new JComboBox<String>(tipoFuncionario);
		tipoCB.setBounds(105, 209, 86, 22);
		panel.add(tipoCB);
		
		JButton cadastrarBtn = new JButton("Cadastrar");
		cadastrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa novoFuncionario;
				String nomeNovoFunc = nomeFuncionarioTF.getText();
				boolean grauSuperior = superiorCheckBox.isSelected();
				boolean grau2 = grau2CheckBox.isSelected();
				Pessoa superior = empresa.findFuncionario((String)superiorCB.getSelectedItem());
				
				if(((String)tipoCB.getSelectedItem()).equals("Empregado")) {
					novoFuncionario = new Empregado(nomeNovoFunc,superior,grau2,grauSuperior);
					((Chefe)superior).addEmpregado(novoFuncionario);
					nomeFuncionarioCB.addItem(novoFuncionario.getNome());
					
				}else if(((String)tipoCB.getSelectedItem()).equals("Chefe")) {
					novoFuncionario = new Chefe(nomeNovoFunc,superior,grau2,grauSuperior);
					((Chefe)superior).addEmpregado(novoFuncionario);
					nomeFuncionarioCB.addItem(novoFuncionario.getNome());
					superiorCB.addItem(novoFuncionario.getNome());
				}
				
				
			}
		});
		cadastrarBtn.setBounds(226, 209, 89, 23);
		panel.add(cadastrarBtn);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nome Funcionário:");
		lblNewLabel_4.setBounds(10, 27, 89, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo Consulta:");
		lblNewLabel_5.setBounds(10, 69, 89, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Lista:");
		lblNewLabel_6.setBounds(10, 108, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		JEditorPane listaEditorPane = new JEditorPane();
		listaEditorPane.setBounds(10, 133, 322, 85);
		panel_1.add(listaEditorPane);
		
		String[] listaFuncionarios = empresa.listaFuncionarios();
		nomeFuncionarioCB = new JComboBox<String>(listaFuncionarios);
		nomeFuncionarioCB.setBounds(109, 23, 195, 22);
		panel_1.add(nomeFuncionarioCB);
		
		String[] tipoConsulta = {"Subordinados", "Superiores"};
		tipoConsultaCB = new JComboBox<String>(tipoConsulta);
		tipoConsultaCB.setBounds(109, 65, 195, 22);
		panel_1.add(tipoConsultaCB);
		
		consultarBtn = new JButton("Consultar");
		consultarBtn.addActionListener((e) -> {
				
				Pessoa p = empresa.findFuncionario((String)nomeFuncionarioCB.getSelectedItem());
				
				StringBuilder lista = new StringBuilder();
				
				if(((String)tipoConsultaCB.getSelectedItem()).equals("Superiores")) {
					
					ArrayList<String> listaDeSuperiores = new ArrayList<String>();
					p.listSuperiores(listaDeSuperiores);
					
					listaDeSuperiores.stream().forEach(q -> lista.append(q).append("\n"));
					 
					 listaEditorPane.setText(lista.toString());
				}
				if (((String)tipoConsultaCB.getSelectedItem()).equals("Subordinados")) {
					if(p instanceof Chefe) {
						ArrayList<String> listaSubordinados = new ArrayList<String>();
						p.listSubordinados(listaSubordinados);
						
						String listaStream = listaSubordinados.stream()
								.collect(Collectors.joining("\n"));
						
						listaEditorPane.setText(listaStream);
						
						
						/*
						Forma 1 
						listaSubordinados.stream()
							.forEach(q ->  lista.append(q).append("\n"));
						listaEditorPane.setText(lista.toString());
						*/
						
						
						/*
						Forma 2
						for(String q : listaSubordinados){
							lista.append(q).append("\n");
						}
						listaEditorPane.setText(lista.toString());
						*/
						
						
					}else listaEditorPane.setText(null);
				}
				
				
				
				
			
		});
		consultarBtn.setBounds(117, 233, 89, 23);
		panel_1.add(consultarBtn);
	}
}
