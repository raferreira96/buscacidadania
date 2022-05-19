package br.jus.trf5.buscacidadania.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.trf5.buscacidadania.domain.model.Locais;

public interface LocaisRepository extends JpaRepository<Locais, Integer> {
    
}
