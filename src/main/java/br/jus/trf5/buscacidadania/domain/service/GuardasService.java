package br.jus.trf5.buscacidadania.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trf5.buscacidadania.domain.model.Guardas;
import br.jus.trf5.buscacidadania.domain.repository.GuardasRepository;

@Service
public class GuardasService {

    @Autowired
    private GuardasRepository rep;

    //Listar todas as Guardas
    public List<Guardas> getGuardas() {
        List<Guardas> guardas = rep.findAll();

        List<Guardas> list = guardas.stream().map(Guardas::create).collect(Collectors.toList());
        return list;
    }

    //Listar guardas pelo Id
    public Optional<Guardas> getGuardaById(Integer gua_id) {
        return rep.findById(gua_id).map(Guardas::create);
    }

    //Inserir nova guarda
    public Guardas insert(Guardas guardas) {
        return Guardas.create(rep.save(guardas));
    }

    //Remover uma guarda
    public boolean delete(Integer gua_id) {
        if(getGuardaById(gua_id).isPresent()) {
            rep.deleteById(gua_id);
            return true;
        } else {
            return false;
        }
    }
    
}
