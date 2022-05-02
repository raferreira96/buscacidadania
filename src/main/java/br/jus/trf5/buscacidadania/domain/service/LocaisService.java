package br.jus.trf5.buscacidadania.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.jus.trf5.buscacidadania.domain.model.Locais;
import br.jus.trf5.buscacidadania.domain.repository.LocaisRepository;

@Service
public class LocaisService {
    
    @Autowired
    private LocaisRepository rep;

    //Listar todos os Locais
    public Iterable<Locais> getLocais() {
        return rep.findAll();
    }

    //Listar local baseado pelo Id
    public Optional<Locais> getLocaisById(Integer loc_id) {
        return rep.findById(loc_id);
    }

    //Inserir um novo local
    public Locais insert(Locais locais) {
        return rep.save(locais);
    }

    //Atualizar um local
    public Locais update(Locais locais, Integer loc_id) {
        Assert.notNull(loc_id, "Não foi possível atualizar o registro.");

        Optional<Locais> optional = getLocaisById(loc_id);
        if(optional.isPresent()) {
            Locais db = optional.get();
            db.setLoc_descricao(locais.getLoc_descricao());
            db.setLoc_endereco(locais.getLoc_endereco());
            db.setLoc_tplid(locais.getLoc_tplid());
            System.out.println("Id Local: " + db.getLoc_id());

            rep.save(db);
            return db;
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro.");
        }
    }

    //Remover um local
    public void delete(Integer loc_id) {
        Optional<Locais> locais = getLocaisById(loc_id);
        if(locais.isPresent()) {
            rep.deleteById(loc_id);
        }
    }
}
