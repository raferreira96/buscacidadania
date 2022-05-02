package br.jus.trf5.buscacidadania.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trf5.buscacidadania.domain.model.Cidadaos;
import br.jus.trf5.buscacidadania.domain.service.CidadaosService;

@RestController
@RequestMapping("/api/v1/cidadaos")
public class CidadaosController {
    
    @Autowired
    private CidadaosService service;

    @GetMapping
    public Iterable<Cidadaos> get() {
        return service.getCidadaos();
    }

    @GetMapping("/{cid_id}")
    public Optional<Cidadaos> getCidadaosById(@PathVariable("cid_id") Integer cid_id) {
        return service.getCidadaosById(cid_id);
    }

    @PostMapping
    public String post(@RequestBody Cidadaos cidadaos) {
        Cidadaos c = service.insert(cidadaos);

        return "Cidadão salvo com sucesso: " + c.getCid_id();
    }

    @PutMapping("/{cid_id}")
    public String put(@PathVariable("cid_id") Integer cid_id, @RequestBody Cidadaos cidadaos) {
        Cidadaos c = service.update(cidadaos, cid_id);

        return "Cidadão atualizado com sucesso: " + c.getCid_id();
    }

    @DeleteMapping("/{cid_id}")
    public String delete(@PathVariable("cid_id") Integer cid_id) {
        service.delete(cid_id);

        return "Cidadão removido com sucesso.";
    }
}
