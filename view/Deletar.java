package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.controller.AlunoController;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Deletar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Deletar() {
		setTitle("Deletar Aluno");
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Matricula");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1,alignx left");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Deletar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String mat;
				String resp;
				AlunoController controller = new AlunoController();
				
				mat = textField.getText();
				
				resp = controller.delete(mat);
				
				lblNewLabel_1.setText(resp);
			}
		});
		contentPane.add(btnNewButton, "cell 0 3,growx");
		
		lblNewLabel_1 = new JLabel("");
		contentPane.add(lblNewLabel_1, "cell 0 4,alignx center");
	}

}
