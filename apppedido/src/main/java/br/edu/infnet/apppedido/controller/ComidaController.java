package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.ComidaService;

@Controller
public class ComidaController {
	
	@Autowired
	private ComidaService comidaService;

	@GetMapping(value = "/comida/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("listaComida", comidaService.obterLista(usuario));
		
		return "comida/lista";
	}

	@GetMapping(value = "/comida/cadastro")
	public String telaCadastro() {

		return "comida/cadastro";
	}

	@PostMapping(value = "/comida/incluir")
	public String incluir(Comida comida, @SessionAttribute("user") Usuario usuario) {
		
		comida.setUsuario(usuario);
		
		comidaService.incluir(comida);
		
		return "redirect:/comida/lista";
	}

	@GetMapping(value = "/comida/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		comidaService.excluir(id);

		return "redirect:/comida/lista";
	}
}