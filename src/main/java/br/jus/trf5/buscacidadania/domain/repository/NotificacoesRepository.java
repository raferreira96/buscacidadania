package br.jus.trf5.buscacidadania.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.trf5.buscacidadania.domain.model.Notificacoes;

public interface NotificacoesRepository extends JpaRepository<Notificacoes, Integer> {
    
}
