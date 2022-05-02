package br.jus.trf5.buscacidadania.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.jus.trf5.buscacidadania.domain.model.Cidadaos;
import br.jus.trf5.buscacidadania.domain.repository.CidadaosRepository;

@Service
public class CidadaosService {

    @Autowired
    private CidadaosRepository rep;

    //Listar todos os cidadãos
    public Iterable<Cidadaos> getCidadaos() {
        return rep.findAll();
    }

    //Listar cidadão baseado pelo Id
    public Optional<Cidadaos> getCidadaosById(Integer cid_id) {
        return rep.findById(cid_id);
    }

    //Inserir novo usuário
    public Cidadaos insert(Cidadaos cidadaos) {
        return rep.save(cidadaos);
    }

    //Atualizar um usuário
    public Cidadaos update(Cidadaos cidadaos, Integer cid_id) {
        Assert.notNull(cid_id, "Não foi possível atualizar o registro.");

        Optional<Cidadaos> optional = getCidadaosById(cid_id);
        if(optional.isPresent()) {
            Cidadaos db = optional.get();
            db.setCid_bio(cidadaos.getCid_bio());
            db.setCid_nome(cidadaos.getCid_nome());
            db.setCid_datanasc(cidadaos.getCid_datanasc());
            db.setCid_foto(cidadaos.getCid_foto());
            System.out.println("Id Cidadão: " + db.getCid_id());

            rep.save(db);
            return db;
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro.");
        }
    }

    //Remover um cidadão
    public void delete(Integer cid_id) {
        Optional<Cidadaos> cidadaos = getCidadaosById(cid_id);
        if(cidadaos.isPresent()) {
            rep.deleteById(cid_id);
        }
    }
    
}
