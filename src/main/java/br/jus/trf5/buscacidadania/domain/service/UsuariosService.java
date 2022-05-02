package br.jus.trf5.buscacidadania.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.jus.trf5.buscacidadania.domain.model.Usuarios;
import br.jus.trf5.buscacidadania.domain.repository.UsuariosRepository;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository rep;

    //Listar todos os Usuários
    public Iterable<Usuarios> getUsuarios() {
        return rep.findAll();
    }

    //Listar Usuário baseado no Id
    public Optional<Usuarios> getUsuariosById(Integer usu_id) {
        return rep.findById(usu_id);
    }

    //Inserir um novo usuário
    public Usuarios insert(Usuarios usuarios) {
        return rep.save(usuarios);
    }

    //Atualizar um usuário
    public Usuarios update(Usuarios usuarios, Integer usu_id) {
        Assert.notNull(usu_id, "Não foi possível atualizar o registro.");

        Optional<Usuarios> optional = getUsuariosById(usu_id);
        if(optional.isPresent()) {
            Usuarios db = optional.get();
            db.setUsu_username(usuarios.getUsu_username());
            db.setUsu_password(usuarios.getUsu_password());
            db.setUsu_nome(usuarios.getUsu_nome());
            db.setUsu_cpf(usuarios.getUsu_cpf());
            db.setUsu_email(usuarios.getUsu_email());
            db.setUsu_tpuid(usuarios.getUsu_tpuid());
            db.setUsu_locid(usuarios.getUsu_locid());
            System.out.println("Id Usuário: " + db.getUsu_id());

            rep.save(db);
            return db;
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro.");
        }
    }

    //Remover um usuário
    public void delete(Integer usu_id) {
        Optional<Usuarios> usuarios = getUsuariosById(usu_id);
        if(usuarios.isPresent()) {
            rep.deleteById(usu_id);
        }
    }
}
