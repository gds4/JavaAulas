package labxxv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class TextEditor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextEditor window = new TextEditor();
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
	public TextEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 11, 414, 196);
		frame.getContentPane().add(editorPane);
		
		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione um arquivo TXT", "txt");
				chooser.setFileFilter(filter);
				
				
				int retorno = chooser.showOpenDialog(null);
				
				if(retorno == JFileChooser.APPROVE_OPTION) {
					File archive_txt = chooser.getSelectedFile();
					StringBuilder archive_str = new StringBuilder();
					try {
						BufferedReader reader = new BufferedReader(new FileReader(archive_txt));
						String linha_do_arquivo;
						while((linha_do_arquivo = reader.readLine()) != null) {
							archive_str.append(linha_do_arquivo).append("\n");
						}
						reader.close();
						editorPane.setText(archive_str.toString());
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
					
			}
		});
		btnNewButton.setBounds(91, 218, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione um arquivo TXT", "txt");
				chooser.setFileFilter(filter);
				int retorno = chooser.showSaveDialog(null);
				File archive = chooser.getSelectedFile();
				
				if(retorno == JFileChooser.APPROVE_OPTION) {
					try {
						PrintWriter writer = new PrintWriter(new FileWriter(archive));
						writer.write(editorPane.getText());
						writer.close();
						
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					
					
				}
				
				
			}
		});
		btnNewButton_1.setBounds(220, 218, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
