package br.jus.trf5.buscacidadania.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.jus.trf5.buscacidadania.domain.model.Locais;
import br.jus.trf5.buscacidadania.domain.service.LocaisService;

@RestController
@RequestMapping("/api/v1/locais")
public class LocaisController {
    
    @Autowired
    private LocaisService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getLocais());
    }

    @GetMapping("/{loc_id}")
    public ResponseEntity getLocaisById(@PathVariable("loc_id") Integer loc_id) {
        Optional<Locais> locais = service.getLocalById(loc_id);
        if(locais.isPresent()) {
            return ResponseEntity.ok(locais.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Locais locais) {
        try {
            Locais l = service.insert(locais);
            URI location = getUri(l.getLoc_id());
            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Integer loc_id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{loc_id}").buildAndExpand(loc_id).toUri();
    }

    @PutMapping("/{loc_id}")
    public ResponseEntity put(@PathVariable("loc_id") Integer loc_id, @RequestBody Locais locais) {
        locais.setLoc_id(loc_id);

        Locais l = service.update(locais, loc_id);

        return l != null ?
            ResponseEntity.ok(l) :
            ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{loc_id}")
    public ResponseEntity delete(@PathVariable("loc_id") Integer loc_id) {
        boolean ok = service.delete(loc_id);

        return ok ?
            ResponseEntity.ok().build() :
            ResponseEntity.notFound().build();
    }
}
