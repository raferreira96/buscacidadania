package br.jus.trf5.buscacidadania.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trf5.buscacidadania.domain.model.Notificacoes;
import br.jus.trf5.buscacidadania.domain.repository.NotificacoesRepository;

@Service
public class NotificacoesService {
    
    @Autowired
    private NotificacoesRepository rep;

    //Listar todas as notificações
    public Iterable<Notificacoes> getNotificacoes() {
        return rep.findAll();
    }

    //Listar notificações pelo Id
    public Optional<Notificacoes> getNotificacoesById(Integer not_id) {
        return rep.findById(not_id);
    }

    //Inserir nova notificação
    public Notificacoes insert(Notificacoes notificacoes) {
        return rep.save(notificacoes);
    }
}
