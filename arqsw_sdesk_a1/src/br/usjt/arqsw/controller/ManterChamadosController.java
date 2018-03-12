package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;
import br.usjt.arqsw.dao.ChamadoDAO;


/**
 * 
 * @author Allan Samey Cordeiro Ramos - RA:201516605 - Turma:SIN3AN-MCA
 *
 */
@Controller
public class ManterChamadosController {
	private FilaService filaService;

	public ManterChamadosController() {
		filaService = new FilaService();
	}

	
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private List<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	/**
	 * 
	 * @param model Acesso a  request http
	 * @return JSP de Listar Chamados
	 */
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(Fila fila, Model model) {
		try {
			FilaService fService = new FilaService();
			fila = fService.carregar(fila.getId());
			model.addAttribute("fila", fila);

			ChamadoService service = new ChamadoService();
			ArrayList<Chamado> chamados = service.listarChamados(fila);
			model.addAttribute("chamados", chamados);

			return "ChamadoListarExibir";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

}
