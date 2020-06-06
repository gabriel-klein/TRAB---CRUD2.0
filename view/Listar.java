package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.poo.controller.AlunoController;
import com.poo.model.Aluno;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Listar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Listar() {
		setTitle("Listagem de Alunos");
		setVisible(true);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		AlunoController controller = new AlunoController();
		
		for(Aluno aluno:controller.readAll())
		{
			JLabel txtMatricula = new JLabel("Matricula");
			contentPane.add(txtMatricula, "flowy,cell 0 0");
			
			JTextField textField = new JTextField();
			contentPane.add(textField, "cell 0 0,alignx left,aligny top");
			textField.setColumns(10);
			textField.setText(aluno.getMatricula());
			
			JLabel txtNome = new JLabel("Nome");
			contentPane.add(txtNome, "cell 0 1");
			
			JTextField textField_1 = new JTextField();
			contentPane.add(textField_1, "cell 0 2,alignx right \n");
			textField_1.setColumns(10);
			textField_1.setText(aluno.getNome());
		
		}

	}
}
