package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import br.jus.trf5.buscacidadania.api.GuardasController;
import lombok.Data;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Entity(name = "tb_guardas")
@Data
public class Guardas extends RepresentationModel<Guardas> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gua_id;

    @ManyToOne
    @JoinColumn(name = "gua_usuid", referencedColumnName = "usu_id")
    private Usuarios gua_usuid;

    @ManyToOne
    @JoinColumn(name = "gua_cidid", referencedColumnName = "cid_id")
    private Cidadaos gua_cidid;

    public static Guardas create(Guardas g) {
        ModelMapper modelMapper = new ModelMapper();
        g.add(linkTo(GuardasController.class).slash(g.getGua_id()).withSelfRel());
        g.add(linkTo(GuardasController.class).withRel("allGuardas"));
        return modelMapper.map(g, Guardas.class);
    }
}
