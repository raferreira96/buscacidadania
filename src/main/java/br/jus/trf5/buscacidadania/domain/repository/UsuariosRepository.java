package br.jus.trf5.buscacidadania.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jus.trf5.buscacidadania.domain.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    
    Usuarios findByUsername(String username);
}
