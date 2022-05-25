package br.jus.trf5.buscacidadania.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Usuarios> getUsuarios() {
        List<Usuarios> usuarios = rep.findAll();
        List<Usuarios> list = usuarios.stream().map(Usuarios::create).collect(Collectors.toList());
        return list;
    }

    //Listar Usuário baseado no Id
    public Optional<Usuarios> getUsuarioById(Integer usu_id) {
        return rep.findById(usu_id).map(Usuarios::create);
    }

    //Inserir um novo usuário
    public Usuarios insert(Usuarios usuarios) {
        return Usuarios.create(rep.save(usuarios));
    }

    //Atualizar um usuário
    public Usuarios update(Usuarios usuarios, Integer usu_id) {
        Assert.notNull(usu_id, "Não foi possível atualizar o registro.");

        Optional<Usuarios> optional = getUsuarioById(usu_id);
        if(optional.isPresent()) {
            Usuarios db = optional.get();
            db.setUsername(usuarios.getUsername());
            db.setPassword(usuarios.getPassword());
            db.setUsu_nome(usuarios.getUsu_nome());
            db.setUsu_cpf(usuarios.getUsu_cpf());
            db.setUsu_email(usuarios.getUsu_email());
            db.setUsu_tpuid(usuarios.getUsu_tpuid());
            db.setUsu_locid(usuarios.getUsu_locid());
            System.out.println("Id Usuário: " + db.getUsu_id());

            rep.save(db);
            return Usuarios.create(db);
        } else {
            return null;
        }
    }

    //Remover um usuário
    public boolean delete(Integer usu_id) {
        if(getUsuarioById(usu_id).isPresent()) {
            rep.deleteById(usu_id);
            return true;
        } else {
            return false;
        }
    }
}
