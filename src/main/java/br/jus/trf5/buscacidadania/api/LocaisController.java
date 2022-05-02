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

import br.jus.trf5.buscacidadania.domain.model.Locais;
import br.jus.trf5.buscacidadania.domain.service.LocaisService;

@RestController
@RequestMapping("/api/v1/locais")
public class LocaisController {
    
    @Autowired
    private LocaisService service;

    @GetMapping
    public Iterable<Locais> get() {
        return service.getLocais();
    }

    @GetMapping("/{loc_id}")
    public Optional<Locais> getLocaisById(@PathVariable("loc_id") Integer loc_id) {
        return service.getLocaisById(loc_id);
    }

    @PostMapping
    public String post(@RequestBody Locais locais) {
        Locais l = service.insert(locais);

        return "Local salvo com sucesso: " + l.getLoc_id();
    }

    @PutMapping("/{loc_id}")
    public String put(@PathVariable("loc_id") Integer loc_id, @RequestBody Locais locais) {
        Locais l = service.update(locais, loc_id);

        return "Local atualizado com sucesso: " + l.getLoc_id();
    }

    @DeleteMapping("/{loc_id}")
    public String delete(@PathVariable("loc_id") Integer loc_id) {
        service.delete(loc_id);

        return "Local removido com sucesso.";
    }

}
