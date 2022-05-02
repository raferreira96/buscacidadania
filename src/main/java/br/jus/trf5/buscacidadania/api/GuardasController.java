package br.jus.trf5.buscacidadania.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.trf5.buscacidadania.domain.model.Guardas;
import br.jus.trf5.buscacidadania.domain.service.GuardasService;

@RestController
@RequestMapping("/api/v1/guardas")
public class GuardasController {

    @Autowired
    private GuardasService service;

    @GetMapping
    public Iterable<Guardas> get() {
        return service.getGuardas();
    }
    
    @GetMapping("/{gua_id}")
    public Optional<Guardas> getGuardasById(@PathVariable("gua_id") Integer gua_id) {
        return service.getGuardasById(gua_id);
    }

    @PostMapping
    public String post(@RequestBody Guardas guardas) {
        Guardas g = service.insert(guardas);

        return "Guarda inserida com sucesso: " + g.getGua_id();
    }

    @DeleteMapping("/{gua_id}")
    public String delete(@PathVariable("gua_id") Integer gua_id) {
        service.delete(gua_id);

        return "Guarda removida com sucesso.";
    }
}
