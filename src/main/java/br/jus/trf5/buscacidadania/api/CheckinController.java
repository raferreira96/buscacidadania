package br.jus.trf5.buscacidadania.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.jus.trf5.buscacidadania.domain.model.Checkin;
import br.jus.trf5.buscacidadania.domain.service.CheckinService;

@RestController
@RequestMapping("/api/v1/checkin")
public class CheckinController {
    
    @Autowired
    private CheckinService service;

    @GetMapping
    public ResponseEntity get() {
        return ResponseEntity.ok(service.getCheckins());
    }

    @GetMapping("/{reg_id}")
    public ResponseEntity getCheckinsById(@PathVariable("reg_id") Integer reg_id) {
        Optional<Checkin> checkin = service.getCheckinById(reg_id);
        if(checkin.isPresent()) {
            return ResponseEntity.ok(checkin.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Checkin checkin) {
        try {
            Checkin c = service.insert(checkin);
            URI location = getUri(c.getReg_id());
            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Integer reg_id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{reg_id}").buildAndExpand(reg_id).toUri();
    }
}
