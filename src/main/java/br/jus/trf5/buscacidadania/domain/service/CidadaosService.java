package br.jus.trf5.buscacidadania.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Cidadaos> getCidadaos() {
        List<Cidadaos> cidadaos = rep.findAll();

        List<Cidadaos> list = cidadaos.stream().map(Cidadaos::create).collect(Collectors.toList());

        return list;
    }

    //Listar cidadão baseado pelo Id
    public Optional<Cidadaos> getCidadaoById(Integer cid_id) {
        return rep.findById(cid_id).map(Cidadaos::create);
    }

    //Inserir novo usuário
    public Cidadaos insert(Cidadaos cidadaos) {
        return Cidadaos.create(rep.save(cidadaos));
    }

    //Atualizar um usuário
    public Cidadaos update(Cidadaos cidadaos, Integer cid_id) {
        Assert.notNull(cid_id, "Não foi possível atualizar o registro.");

        Optional<Cidadaos> optional = rep.findById(cid_id);
        if(optional.isPresent()) {
            Cidadaos db = optional.get();
            //Copiar propriedades
            db.setCid_bio(cidadaos.getCid_bio());
            db.setCid_nome(cidadaos.getCid_nome());
            db.setCid_datanasc(cidadaos.getCid_datanasc());
            db.setCid_foto(cidadaos.getCid_foto());
            System.out.println("Cidadão Id: " + db.getCid_id());
            //Atualizar o Cidadão
            rep.save(db);
            return Cidadaos.create(db);
        } else {
            return null;
        }
    }

    //Remover um cidadão
    public boolean delete(Integer cid_id) {
        if(getCidadaoById(cid_id).isPresent()) {
            rep.deleteById(cid_id);
            return true;
        } else {
            return false;
        }
    }
}
