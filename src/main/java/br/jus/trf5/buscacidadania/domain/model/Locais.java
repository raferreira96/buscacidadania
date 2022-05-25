package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import br.jus.trf5.buscacidadania.api.LocaisController;
import lombok.Data;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Entity(name = "tb_locais")
@Data
public class Locais extends RepresentationModel<Locais> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loc_id;

    private String loc_descricao;
    private String loc_endereco;

    @ManyToOne
    @JoinColumn(name = "loc_tplid", referencedColumnName = "tpl_id")
    private TipoLocal loc_tplid;

    public static Locais create(Locais l) {
        ModelMapper modelMapper = new ModelMapper();
        l.add(linkTo(LocaisController.class).slash(l.getLoc_id()).withSelfRel());
        l.add(linkTo(LocaisController.class).withRel("allLocais"));
        return modelMapper.map(l, Locais.class);
    }
}
