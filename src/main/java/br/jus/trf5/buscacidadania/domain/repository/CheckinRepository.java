package br.jus.trf5.buscacidadania.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.trf5.buscacidadania.domain.model.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Integer> {
    
}
