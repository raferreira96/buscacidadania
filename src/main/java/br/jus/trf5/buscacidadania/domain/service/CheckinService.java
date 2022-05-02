package br.jus.trf5.buscacidadania.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trf5.buscacidadania.domain.model.Checkin;
import br.jus.trf5.buscacidadania.domain.repository.CheckinRepository;

@Service
public class CheckinService {
    
    @Autowired
    private CheckinRepository rep;

    //Listar todos os checkins
    public Iterable<Checkin> getCheckins() {
        return rep.findAll();
    }

    //Listar checkin por Id
    public Optional<Checkin> getCheckinsById(Integer reg_id) {
        return rep.findById(reg_id);
    }

    //Inserir novo checkin
    public Checkin insert(Checkin checkin) {
        return rep.save(checkin);
    }
}
