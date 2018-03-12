package br.usjt.arqsw.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author Allan Samey Cordeiro Ramos - RA:201516605 - Turma:SIN3AN-MCA
 *
 */


public class ChamadoService {
	ChamadoDAO dao;
	
	public ChamadoService(){
		dao = new ChamadoDAO();
	}
	
	public int novoChamado(Chamado chamado) throws IOException{
		chamado.setDataAbertura(new Date());
		chamado.setDataFechamento(null);
		chamado.setStatus(Chamado.ABERTO);
		
		return dao.inserirChamado(chamado);
	}
	
	public ArrayList<Chamado> listarChamadosAbertos(Fila fila) throws IOException{
		return dao.listarChamadosAbertos(fila);
	}
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException{
		return dao.listarChamados(fila);
	}

	public void fecharChamados(ArrayList<Integer> lista) throws IOException {
		dao.fecharChamados(lista);
	}

}
