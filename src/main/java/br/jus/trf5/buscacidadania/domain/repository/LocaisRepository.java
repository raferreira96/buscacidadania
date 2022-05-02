package br.jus.trf5.buscacidadania.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.jus.trf5.buscacidadania.domain.model.Locais;

public interface LocaisRepository extends CrudRepository<Locais, Integer> {
    
}
