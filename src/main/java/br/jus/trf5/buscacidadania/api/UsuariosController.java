package br.jus.trf5.buscacidadania.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trf5.buscacidadania.domain.model.Usuarios;
import br.jus.trf5.buscacidadania.domain.service.UsuariosService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosService service;

    @GetMapping
    public Iterable<Usuarios> get() {
        return service.getUsuarios();
    }

    @GetMapping("/{usu_id}")
    public Optional<Usuarios> getUsuariosById(@PathVariable("usu_id") Integer usu_id) {
        return service.getUsuariosById(usu_id);
    }

    @PostMapping
    public String post(@RequestBody Usuarios usuarios) {
        Usuarios u = service.insert(usuarios);

        return "Usuário salvo com sucesso: " + u.getUsu_id();
    }

    @PutMapping("/{usu_id}")
    public String put(@PathVariable("usu_id") Integer usu_id, @RequestBody Usuarios usuarios) {
        Usuarios u = service.update(usuarios, usu_id);

        return "Usuário atualizado com sucesso: " + u.getUsu_id();
    }

    @DeleteMapping("/{usu_id}")
    public String delete(@PathVariable("usu_id") Integer usu_id) {
        service.delete(usu_id);

        return "Usuário removido com sucesso.";
    }
 }
