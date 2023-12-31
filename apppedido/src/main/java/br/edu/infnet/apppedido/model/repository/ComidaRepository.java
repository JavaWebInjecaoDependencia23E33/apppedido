package br.edu.infnet.apppedido.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppedido.model.domain.Comida;

@Repository
public interface ComidaRepository extends CrudRepository<Comida, Integer> {

	@Query("from Comida c where c.usuario.id = :userid")
	public List<Comida> obterLista(Integer userid);
}