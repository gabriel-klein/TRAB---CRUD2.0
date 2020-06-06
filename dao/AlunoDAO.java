package com.poo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.poo.jdbc.ConnectionFactory;
import com.poo.model.Aluno;

public class AlunoDAO {
	
	//insere aluno no banco
	
	public String create(Aluno aluno)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp;
		
		String sql = "insert into Aluno(matricula,nome) values (?,?)";
		
		try {
			
			stmt = con.prepareStatement(sql); //instancia uma instrução sql
			stmt.setString(1, aluno.getMatricula());//primeiro parametro da query
			stmt.setString(2, aluno.getNome());//Segundo parametro
			
			stmt.executeUpdate();
			
			resp = "Aluno criado com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			resp = "Aluno não criado com sucesso";
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return resp;
	}
	
	public List<Aluno> readAll()
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select matricula, nome from Aluno";
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getString("Matricula"));
				aluno.setNome(rs.getString("Nome"));
				
				alunos.add(aluno);
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler a tabela Aluno");
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return alunos;
	}
	
	public String teste (String mat){
	
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select matricula from Aluno where matricula = (?)";
		
		try {
			
			stmt = con.prepareStatement(sql); //instancia uma instrução sql
			stmt.setString(1, mat);//primeiro parametro da query
			
			rs = stmt.executeQuery();
			
			if(!rs.next())
			{
				mat = null;
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return mat;
		
	}
	
	public String update(Aluno aluno, String mat)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp = null;
		
		String sql = "update Aluno set matricula = (?), nome = (?) where matricula = (?) ";
		
		try {
			
			stmt = con.prepareStatement(sql); //instancia uma instrução sql
			stmt.setString(1, aluno.getMatricula());//primeiro parametro da query
			stmt.setString(2, aluno.getNome());//Segundo parametro
			stmt.setString(3, mat);//Terceiro parametro
			
			stmt.executeUpdate();
			
			resp = "Aluno atualizado com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			resp = "Aluno não atualizado";
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		return resp;
	}
	
	public String delete(String mat)
	{
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String resp;
		
		String sql = "delete from Aluno where matricula = (?)";
		
		try {
			
			stmt = con.prepareStatement(sql); //instancia uma instrução sql
			stmt.setString(1, mat);//primeiro parametro da query
			
			stmt.executeUpdate();
			
			resp = "Aluno excluido com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			resp = "Aluno não excluido com sucesso";
		}
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
		
		return resp;
	}
}

