package com.poo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[89px][85px][89px][89px]", "[23px][][][]"));
		
		JButton btnCriar = new JButton("Criar Aluno       ");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Criar criar = new Criar();
			}
		});
		contentPane.add(btnCriar, "cell 0 0,alignx left,aligny top");
		
		JLabel label = new JLabel("");
		contentPane.add(label, "cell 1 0,alignx left,aligny center");
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1, "cell 2 0,alignx left,aligny center");
		
		JButton btnListar = new JButton("Listar Aluno      ");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Listar listar = new Listar();
			}
		});
		contentPane.add(btnListar, "cell 0 1,alignx left,aligny top");
		
		JButton btnAtualizar = new JButton("Atualizar Aluno");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Atualizar atualizar = new Atualizar();
			}
		});
		contentPane.add(btnAtualizar, "cell 0 2,alignx left,aligny top");
		
		JButton btnDeletar = new JButton("Deletar Aluno   ");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Deletar deletar = new Deletar();
			}
		});
		contentPane.add(btnDeletar, "cell 0 3,alignx left,aligny top");
	}

}
