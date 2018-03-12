package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Allan Samey Cordeiro Ramos - RA:201516605 Turma:201516605
 *
 */
public class FilaService {
	private FilaDAO dao;
	
	public FilaService() {
		dao = new FilaDAO();
	}
	public ArrayList<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}
	public Fila carregar(int id) throws IOException{
		// TODO Auto-generated method stub
		return dao.carregar(id);
	}
}
