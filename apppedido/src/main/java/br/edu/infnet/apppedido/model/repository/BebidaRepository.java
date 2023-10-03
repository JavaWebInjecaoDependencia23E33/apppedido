package br.edu.infnet.apppedido.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apppedido.model.domain.Bebida;

@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Integer> {

	@Query("from Bebida b where b.usuario.id = :userid")
	public List<Bebida> obterLista(Integer userid);
}