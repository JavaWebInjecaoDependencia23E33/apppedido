package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Sobremesa;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.SobremesaService;

@Controller
public class SobremesaController {

	@Autowired
	private SobremesaService sobremesaService;

	@GetMapping(value = "/sobremesa/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("listaSobremesa", sobremesaService.obterLista(usuario));
		
		return "sobremesa/lista";
	}

	@GetMapping(value = "/sobremesa/cadastro")
	public String telaCadastro() {

		return "sobremesa/cadastro";
	}

	@PostMapping(value = "/sobremesa/incluir")
	public String incluir(Sobremesa sobremesa, @SessionAttribute("user") Usuario usuario) {
		
		sobremesa.setUsuario(usuario);
		
		sobremesaService.incluir(sobremesa);
		
		return "redirect:/sobremesa/lista";
	}

	@GetMapping(value = "/sobremesa/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		sobremesaService.excluir(id);

		return "redirect:/sobremesa/lista";
	}
}