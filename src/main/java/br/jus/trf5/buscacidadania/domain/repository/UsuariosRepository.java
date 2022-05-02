package br.jus.trf5.buscacidadania.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.jus.trf5.buscacidadania.domain.model.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Integer> {
    
}
