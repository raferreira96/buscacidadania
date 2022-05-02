package br.jus.trf5.buscacidadania.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trf5.buscacidadania.domain.model.Notificacoes;
import br.jus.trf5.buscacidadania.domain.service.NotificacoesService;

@RestController
@RequestMapping("/api/v1/notificacoes")
public class NotificacoesController {
    
    @Autowired
    private NotificacoesService service;

    @GetMapping
    public Iterable<Notificacoes> get() {
        return service.getNotificacoes();
    }

    @GetMapping("/{not_id}")
    public Optional<Notificacoes> getNotificacoesById(@PathVariable("not_id") Integer not_id) {
        return service.getNotificacoesById(not_id);
    }

    @PostMapping
    public String post(@RequestBody Notificacoes notificacoes) {
        Notificacoes n = service.insert(notificacoes);

        return "Notificação enviada com sucesso: " + n.getNot_id();
    }
}
