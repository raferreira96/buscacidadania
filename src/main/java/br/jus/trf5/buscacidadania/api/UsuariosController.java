package br.jus.trf5.buscacidadania.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.jus.trf5.buscacidadania.domain.model.Usuarios;
import br.jus.trf5.buscacidadania.domain.service.UsuariosService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getUsuarios());
    }

    @GetMapping("/{usu_id}")
    public ResponseEntity getUsuariosById(@PathVariable("usu_id") Integer usu_id) {
        Optional<Usuarios> usuarios = service.getUsuarioById(usu_id);
        if(usuarios.isPresent()) {
            return ResponseEntity.ok(usuarios.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @PostMapping
    // public ResponseEntity post(@RequestBody Usuarios usuarios) {
    //     try {
    //         Usuarios u = service.insert(usuarios);
    //         URI location = getUri(u.getUsu_id());
    //         return ResponseEntity.created(location).build();
    //     } catch (Exception ex) {
    //         return ResponseEntity.badRequest().build();
    //     }

    private URI getUri(Integer usu_id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{usu_id}").buildAndExpand(usu_id).toUri();
    }

    @PutMapping("/{usu_id}")
    public ResponseEntity put(@PathVariable("usu_id") Integer usu_id, @RequestBody Usuarios usuarios) {
        usuarios.setUsu_id(usu_id);

        Usuarios u = service.update(usuarios, usu_id);

        return u != null ?
            ResponseEntity.ok(u) :
            ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{usu_id}")
    public ResponseEntity delete(@PathVariable("usu_id") Integer usu_id) {
        boolean ok = service.delete(usu_id);

        return ok ?
            ResponseEntity.ok().build():
            ResponseEntity.notFound().build();
    }
 }
