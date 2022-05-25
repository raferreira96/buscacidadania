package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import br.jus.trf5.buscacidadania.api.CidadaosController;
import lombok.Data;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Entity(name = "tb_cidadaos")
@Data
public class Cidadaos extends RepresentationModel<Cidadaos> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid_id;

    private String cid_bio;
    private String cid_nome;
    private Date cid_datanasc;
    private String cid_foto;

    public static Cidadaos create(Cidadaos c) {
        ModelMapper modelMapper = new ModelMapper();
        c.add(linkTo(CidadaosController.class).slash(c.getCid_id()).withSelfRel());
        c.add(linkTo(CidadaosController.class).withRel("allCidadaos"));
        return modelMapper.map(c, Cidadaos.class);
    }

    // public Cidadaos() {
    //     this.add(linkTo(CidadaosController.class).slash().withSelfRel());
    //     this.add(linkTo(CidadaosController.class).withRel("allCidadaos"));
    // }
}
