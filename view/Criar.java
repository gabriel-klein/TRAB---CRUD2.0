package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.controller.AlunoController;
import com.poo.model.Aluno;

import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Criar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Criar() {
		setTitle("Criar Aluno");
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px,grow]", "[20px][][][][][][][][]"));
		
		JLabel txtMatricula = new JLabel("Matricula");
		contentPane.add(txtMatricula, "flowy,cell 0 0");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 0,alignx left,aligny top");
		textField.setColumns(10);
		
		JLabel txtNome = new JLabel("Nome");
		contentPane.add(txtNome, "cell 0 1");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 0 2,alignx left");
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno aluno = new Aluno();
				AlunoController controller = new AlunoController();
				String resp;
				
				
				aluno.setMatricula(textField.getText());
				aluno.setNome(textField_1.getText());
				
				resp = controller.create(aluno);
				
				lblNewLabel.setText(resp);

			}
		});
		contentPane.add(btnNewButton, "cell 0 4,growx");
		
		lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel, "cell 0 7,alignx center");
	}

}
