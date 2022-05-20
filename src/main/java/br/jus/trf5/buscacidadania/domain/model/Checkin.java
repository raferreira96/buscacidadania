package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Entity(name = "tb_registros")
@Data
public class Checkin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reg_id;

    private Date reg_data;

    @ManyToOne
    @JoinColumn(name = "reg_cidid", referencedColumnName = "cid_id")
    private Cidadaos reg_cidid;

    @ManyToOne
    @JoinColumn(name = "reg_locid", referencedColumnName = "loc_id")
    private Locais reg_locid;

    @ManyToOne
    @JoinColumn(name = "reg_usuid", referencedColumnName = "usu_id")
    private Usuarios reg_usuid;

    public static Checkin create(Checkin c) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(c, Checkin.class);
    }
}
