package br.jus.trf5.buscacidadania.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.jus.trf5.buscacidadania.domain.model.Notificacoes;
import br.jus.trf5.buscacidadania.domain.service.NotificacoesService;

@RestController
@RequestMapping("/api/v1/notificacoes")
public class NotificacoesController {
    
    @Autowired
    private NotificacoesService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getNotificacoes());
    }

    @GetMapping("/{not_id}")
    public ResponseEntity getNotificacoesById(@PathVariable("not_id") Integer not_id) {
        Optional<Notificacoes> notificacoes = service.getNotificacaoById(not_id);
        if(notificacoes.isPresent()) {
            return ResponseEntity.ok(notificacoes.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Secured({"ROLE_ADMIN","ROLE_JUSTICA"})
    public ResponseEntity post(@RequestBody Notificacoes notificacoes) {
        try {
            Notificacoes n = service.insert(notificacoes);
            URI location = getUri(n.getNot_id());
            return ResponseEntity.created(location).build();
        } catch(Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Integer not_id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{not_id}").buildAndExpand(not_id).toUri();
    }
}
