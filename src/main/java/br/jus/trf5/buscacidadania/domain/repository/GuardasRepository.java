package br.jus.trf5.buscacidadania.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.trf5.buscacidadania.domain.model.Guardas;

public interface GuardasRepository extends JpaRepository<Guardas, Integer> {
    
}
