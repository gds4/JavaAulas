package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class addSearch {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addSearch window = new addSearch();
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
	public addSearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(33, 58, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero: ");
		lblNewLabel_1.setBounds(33, 100, 66, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(107, 55, 276, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 97, 276, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String formated_str = textField.getText() + "-" + textField_1.getText();
				
				//cria uma instancia do componente que permite navegar pelos arquivos
				JFileChooser escolherArquivo = new JFileChooser();
				
				//define um filtro de tipo de arquivo a ser utilizado na busca de arquivos
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Selecione um arquivo TXT", "txt");
				
				//aplica o filtro
				escolherArquivo.setFileFilter(filtro);
				
				//abre a janela para a seleção de arquivos, o null indica que é para abrir no centro da tela
				int retorno = escolherArquivo.showOpenDialog(null);
				
				//verifica se o arquivo selecionado é do formato correto
				if(retorno == JFileChooser.APPROVE_OPTION) {
					
					
					File arquivo_txt = escolherArquivo.getSelectedFile();
					
					try {
						PrintWriter writer = new PrintWriter(new FileWriter(arquivo_txt, true));
						writer.println(formated_str);
						writer.close();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(100, 176, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_buscado = textField.getText();
				
				
				
				JFileChooser escolherArquivo = new JFileChooser();
				
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Selecione um arquivo TXT", "txt");
				
				escolherArquivo.setFileFilter(filtro);
				
				int retorno = escolherArquivo.showOpenDialog(null);
				
				File arquivo_txt = escolherArquivo.getSelectedFile();
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(arquivo_txt));
					String linha_do_arquivo;
					int numero_linha = 1;
					
					//verifica linha por linha do arquivo
					while((linha_do_arquivo = reader.readLine()) != null) {
						//divide as linhas em dois a partir do "-"
						String[] partes = linha_do_arquivo.split("-");
						if(partes[0].equals(nome_buscado)) {
							JOptionPane.showMessageDialog(frame, "Nome: " + nome_buscado + " Encontrado.\nLinha: " + numero_linha); 
							break;
						}
						numero_linha++;
						
					}
					if(linha_do_arquivo == null) {
						JOptionPane.showMessageDialog(frame, "Nome: " + nome_buscado + " não encontrado.");
					}
					
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(262, 176, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
