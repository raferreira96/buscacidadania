package br.jus.trf5.buscacidadania.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.jus.trf5.buscacidadania.domain.model.Cidadaos;
import br.jus.trf5.buscacidadania.domain.service.CidadaosService;

@RestController
@RequestMapping("/api/v1/cidadaos")
public class CidadaosController {
    
    @Autowired
    private CidadaosService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getCidadaos());
    }

    @GetMapping("/{cid_id}")
    public ResponseEntity getCidadaosById(@PathVariable("cid_id") Integer cid_id) {
        Optional<Cidadaos> cidadaos = service.getCidadaoById(cid_id);
        if(cidadaos.isPresent()) {
            return ResponseEntity.ok(cidadaos.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Secured({"ROLE_ADMIN","ROLE_ASSISTENTE"})
    public ResponseEntity post(@RequestBody Cidadaos cidadaos) {
        try {
            Cidadaos c = service.insert(cidadaos);
            URI location = getUri(c.getCid_id());
            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Integer cid_id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{cid_id}").buildAndExpand(cid_id).toUri();
    }

    @PutMapping("/{cid_id}")
    @Secured({"ROLE_ADMIN","ROLE_ASSISTENTE"})
    public ResponseEntity put(@PathVariable("cid_id") Integer cid_id, @RequestBody Cidadaos cidadaos) {
        cidadaos.setCid_id(cid_id);

        Cidadaos c = service.update(cidadaos, cid_id);
        
        return c != null ?
            ResponseEntity.ok(c): 
            ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cid_id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity delete(@PathVariable("cid_id") Integer cid_id) {
        boolean ok = service.delete(cid_id);

        return ok ?
            ResponseEntity.ok().build():
            ResponseEntity.notFound().build();
    }
}
