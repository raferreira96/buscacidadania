package br.jus.trf5.buscacidadania.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.trf5.buscacidadania.domain.model.Cidadaos;

public interface CidadaosRepository extends JpaRepository<Cidadaos, Integer> {
    
}
