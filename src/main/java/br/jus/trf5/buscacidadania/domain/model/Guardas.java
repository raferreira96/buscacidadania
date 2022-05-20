package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Entity(name = "tb_guardas")
@Data
public class Guardas {
    
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
        return modelMapper.map(g, Guardas.class);
    }
}
