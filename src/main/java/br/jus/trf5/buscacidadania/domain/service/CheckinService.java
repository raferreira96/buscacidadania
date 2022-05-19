package br.jus.trf5.buscacidadania.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trf5.buscacidadania.domain.model.Checkin;
import br.jus.trf5.buscacidadania.domain.repository.CheckinRepository;

@Service
public class CheckinService {
    
    @Autowired
    private CheckinRepository rep;

    //Listar todos os checkins
    public List<Checkin> getCheckins() {
        List<Checkin> checkins = rep.findAll();

        List<Checkin> list = checkins.stream().map(Checkin::create).collect(Collectors.toList());

        return list;
    }

    //Listar checkin por Id
    public Optional<Checkin> getCheckinById(Integer reg_id) {
        return rep.findById(reg_id).map(Checkin::create);
    }

    //Inserir novo checkin
    public Checkin insert(Checkin checkin) {
        return Checkin.create(rep.save(checkin));
    }
}
