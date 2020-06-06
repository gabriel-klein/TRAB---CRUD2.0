package com.poo.controller;

import java.util.ArrayList;
import java.util.List;

import com.poo.dao.AlunoDAO;
import com.poo.model.Aluno;

public class AlunoController {
	
	public String create(Aluno aluno)
	{
		String resp = null;
		try {
			AlunoDAO dao = new AlunoDAO();
			
			resp = dao.create(aluno);
		}catch (Exception e) {
			//System.out.println("Erro no Controller");
			resp = "Erro no Controller";
		}
		finally {
			//System.out.println("Fim inserção");
		}
		return resp;
	}
	
	public List<Aluno> readAll()
	{
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			AlunoDAO dao = new AlunoDAO();
			alunos = dao.readAll();
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return alunos;
	}
	
	public String teste(String mat)
	{
		try {
			AlunoDAO dao = new AlunoDAO();
			
			mat = dao.teste(mat);
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return mat;
	}
	
	public String update(Aluno aluno, String mat)
	{
		String resp = null;
		try {
			AlunoDAO dao = new AlunoDAO();
			String teste;
			
			teste = aluno.getMatricula();
			teste = dao.teste(teste);
			
			if(teste != null && !teste.equals(mat))
			{
				resp = "Matricula nova inválida";
			}
			else
			{
				resp = dao.update(aluno,mat);
			}
			
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
		return resp;
	}
	
	public String delete(String mat)
	{
		String resp = null;
		try {
			AlunoDAO dao = new AlunoDAO();
			
			mat = dao.teste(mat);
			
			if(mat == null)
			{
				resp = "Matricula inválida";
			}
			else
			{
				resp = dao.delete(mat);
			}
			
			return resp;
		}
		finally {
			//System.out.println("Fim da leitura");
		}
		
	}
}
