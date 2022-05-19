package br.jus.trf5.buscacidadania.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.jus.trf5.buscacidadania.domain.model.Guardas;
import br.jus.trf5.buscacidadania.domain.service.GuardasService;

@RestController
@RequestMapping("/api/v1/guardas")
public class GuardasController {

    @Autowired
    private GuardasService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getGuardas());
    }
    
    @GetMapping("/{gua_id}")
    public ResponseEntity getGuardasById(@PathVariable("gua_id") Integer gua_id) {
        Optional<Guardas> guardas = service.getGuardaById(gua_id);
        if (guardas.isPresent()) {
            return ResponseEntity.ok(guardas.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Guardas guardas) {
        try {
            Guardas g = service.insert(guardas);
            URI location = getUri(g.getGua_id());
            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Integer gua_id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{gua_id}").buildAndExpand(gua_id).toUri();
    }

    @DeleteMapping("/{gua_id}")
    public ResponseEntity delete(@PathVariable("gua_id") Integer gua_id) {
        boolean ok = service.delete(gua_id);

        return ok ?
            ResponseEntity.ok().build() :
            ResponseEntity.notFound().build();
    }
}
