package br.jus.trf5.buscacidadania.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jus.trf5.buscacidadania.domain.model.Guardas;
import br.jus.trf5.buscacidadania.domain.repository.GuardasRepository;

@Service
public class GuardasService {

    @Autowired
    private GuardasRepository rep;

    //Listar todas as Guardas
    public Iterable<Guardas> getGuardas() {
        return rep.findAll();
    }

    //Listar guardas pelo Id
    public Optional<Guardas> getGuardasById(Integer gua_id) {
        return rep.findById(gua_id);
    }

    //Inserir nova guarda
    public Guardas insert(Guardas guardas) {
        return rep.save(guardas);
    }

    //Remover uma guarda
    public void delete(Integer gua_id) {
        Optional<Guardas> guardas = getGuardasById(gua_id);
        if(guardas.isPresent()) {
            rep.deleteById(gua_id);
        }
    }
    
}
