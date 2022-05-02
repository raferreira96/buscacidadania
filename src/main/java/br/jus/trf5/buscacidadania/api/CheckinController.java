package br.jus.trf5.buscacidadania.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trf5.buscacidadania.domain.model.Checkin;
import br.jus.trf5.buscacidadania.domain.service.CheckinService;

@RestController
@RequestMapping("/api/v1/checkin")
public class CheckinController {
    
    @Autowired
    private CheckinService service;

    @GetMapping
    public Iterable<Checkin> get() {
        return service.getCheckins();
    }

    @GetMapping("/{reg_id}")
    public Optional<Checkin> getCheckinsById(@PathVariable("reg_id") Integer reg_id) {
        return service.getCheckinsById(reg_id);
    }

    @PostMapping
    public String post(@RequestBody Checkin checkin) {
        Checkin c = service.insert(checkin);

        return "Checkin feito com sucesso: " + c.getReg_id();
    }
}
