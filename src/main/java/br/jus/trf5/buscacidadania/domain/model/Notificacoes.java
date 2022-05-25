package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import br.jus.trf5.buscacidadania.api.NotificacoesController;
import lombok.Data;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Entity(name = "tb_notificacoes")
@Data
public class Notificacoes extends RepresentationModel<Notificacoes> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer not_id;

    private String not_descricao;
    private Date not_data;

    @ManyToOne
    @JoinColumn(name = "not_tpnid", referencedColumnName = "tpn_id")
    private TipoNotificacao not_tpnid;

    @ManyToOne
    @JoinColumn(name = "not_cidid", referencedColumnName = "cid_id")
    private Cidadaos not_cidid;

    @ManyToOne
    @JoinColumn(name = "not_usuid", referencedColumnName = "usu_id")
    private Usuarios not_usuid;

    public static Notificacoes create(Notificacoes n) {
        ModelMapper modelMapper = new ModelMapper();
        n.add(linkTo(NotificacoesController.class).slash(n.getNot_id()).withSelfRel());
        n.add(linkTo(NotificacoesController.class).withRel("allNotificacoes"));
        return modelMapper.map(n, Notificacoes.class);
    }
}