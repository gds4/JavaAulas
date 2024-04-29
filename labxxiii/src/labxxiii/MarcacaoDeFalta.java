package labxxiii;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MarcacaoDeFalta {

	private JFrame frmMarcaoDeFalta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcacaoDeFalta window = new MarcacaoDeFalta();
					window.frmMarcaoDeFalta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarcacaoDeFalta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMarcaoDeFalta = new JFrame();
		frmMarcaoDeFalta.setTitle("Marcação de Faltas");
		frmMarcaoDeFalta.setBounds(100, 100, 576, 300);
		frmMarcaoDeFalta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMarcaoDeFalta.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero: ");
		lblNewLabel.setBounds(27, 36, 46, 14);
		frmMarcaoDeFalta.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setBounds(27, 84, 46, 14);
		frmMarcaoDeFalta.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Regime: ");
		lblNewLabel_2.setBounds(27, 125, 46, 14);
		frmMarcaoDeFalta.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de Faltas:");
		lblNewLabel_3.setBounds(27, 165, 101, 14);
		frmMarcaoDeFalta.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Primeiro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(27, 202, 89, 23);
		frmMarcaoDeFalta.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Anterior");
		btnNewButton_1.setBounds(129, 202, 89, 23);
		frmMarcaoDeFalta.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Seguinte");
		btnNewButton_2.setBounds(228, 202, 89, 23);
		frmMarcaoDeFalta.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ultimo");
		btnNewButton_3.setBounds(327, 202, 89, 23);
		frmMarcaoDeFalta.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Novo");
		btnNewButton_4.setBounds(439, 202, 89, 23);
		frmMarcaoDeFalta.getContentPane().add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setBounds(83, 33, 135, 20);
		frmMarcaoDeFalta.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 81, 443, 20);
		frmMarcaoDeFalta.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(138, 162, 160, 20);
		frmMarcaoDeFalta.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Diurno");
		rdbtnNewRadioButton.setToolTipText("");
		rdbtnNewRadioButton.setBounds(79, 121, 75, 23);
		frmMarcaoDeFalta.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Noturno");
		rdbtnNewRadioButton_1.setBounds(156, 121, 109, 23);
		frmMarcaoDeFalta.getContentPane().add(rdbtnNewRadioButton_1);
		
		//adiciona os dois botoes criados em um grupo que evita que ambos os botoes sejam acionados ao mesmo tempo
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton);
	}
}
