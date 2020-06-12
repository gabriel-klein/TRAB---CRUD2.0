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

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Atualizar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atualizar frame = new Atualizar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Atualizar() {
		setTitle("Atualizar Aluno");
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Matricula atual");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1,alignx left");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nova Matricula");
		contentPane.add(lblNewLabel_1, "cell 0 3");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 0 4,alignx left");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Novo Nome");
		contentPane.add(lblNewLabel_2, "cell 0 5");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 0 6,alignx left");
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String mat;
				String resp;
				Aluno aluno = new Aluno();
				AlunoController controller = new AlunoController();
				
				mat = textField.getText();
				
				mat = controller.teste(mat);
				
				if(mat != null)
				{
					aluno.setMatricula(textField_1.getText());
					aluno.setNome(textField_2.getText());
					
					resp = controller.update(aluno,mat);
					
					lblNewLabel_3.setText(resp);
				}
				else
				{
					lblNewLabel_3.setText("Matricula Atual Inválida");
				}
			}
		});
		contentPane.add(btnNewButton, "cell 0 8,growx");
		
		lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3, "cell 0 9,alignx center");
	}

}
