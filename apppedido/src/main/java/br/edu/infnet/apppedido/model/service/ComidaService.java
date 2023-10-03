package br.edu.infnet.apppedido.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apppedido.model.domain.Comida;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.repository.ComidaRepository;

@Service
public class ComidaService {
	
	@Autowired
	private ComidaRepository comidaRepository;

	public Collection<Comida> obterLista(){
		
		return (Collection<Comida>) comidaRepository.findAll();
	}
	
	public Collection<Comida> obterLista(Usuario usuario){
		
		return (Collection<Comida>) comidaRepository.obterLista(usuario.getId());
	}

	public void incluir(Comida comida) {

		comidaRepository.save(comida);
	}
	
	public void excluir(Integer id) {

		comidaRepository.deleteById(id);
	}	
}