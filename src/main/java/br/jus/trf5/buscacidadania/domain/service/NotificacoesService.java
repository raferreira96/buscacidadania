package br.jus.trf5.buscacidadania.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trf5.buscacidadania.domain.model.Notificacoes;
import br.jus.trf5.buscacidadania.domain.repository.NotificacoesRepository;

@Service
public class NotificacoesService {
    
    @Autowired
    private NotificacoesRepository rep;

    //Listar todas as notificações
    public List<Notificacoes> getNotificacoes() {
        List<Notificacoes> notificacoes = rep.findAll();

        List<Notificacoes> list = notificacoes.stream().map(Notificacoes::create).collect(Collectors.toList());
        return list;
    }

    //Listar notificações pelo Id
    public Optional<Notificacoes> getNotificacaoById(Integer not_id) {
        return rep.findById(not_id).map(Notificacoes::create);
    }

    //Inserir nova notificação
    public Notificacoes insert(Notificacoes notificacoes) {
        return Notificacoes.create(rep.save(notificacoes));
    }
}
