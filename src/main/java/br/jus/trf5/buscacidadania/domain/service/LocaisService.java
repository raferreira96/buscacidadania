package br.jus.trf5.buscacidadania.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Locais> getLocais() {
        List<Locais> locais = rep.findAll();

        List<Locais> list = locais.stream().map(Locais::create).collect(Collectors.toList());
        return list;
    }

    //Listar local baseado pelo Id
    public Optional<Locais> getLocalById(Integer loc_id) {
        return rep.findById(loc_id).map(Locais::create);
    }

    //Inserir um novo local
    public Locais insert(Locais locais) {
        return Locais.create(rep.save(locais));
    }

    //Atualizar um local
    public Locais update(Locais locais, Integer loc_id) {
        Assert.notNull(loc_id, "Não foi possível atualizar o registro.");

        Optional<Locais> optional = getLocalById(loc_id);
        if(optional.isPresent()) {
            Locais db = optional.get();
            db.setLoc_descricao(locais.getLoc_descricao());
            db.setLoc_endereco(locais.getLoc_endereco());
            db.setLoc_tplid(locais.getLoc_tplid());
            System.out.println("Id Local: " + db.getLoc_id());

            rep.save(db);
            return Locais.create(db);
        } else {
            return null;
        }
    }

    //Remover um local
    public boolean delete(Integer loc_id) {
        if(getLocalById(loc_id).isPresent()) {
            rep.deleteById(loc_id);
            return true;
        } else {
            return false;
        }
    }
}
