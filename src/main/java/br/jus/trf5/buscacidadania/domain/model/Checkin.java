package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Entity(name = "tb_registros")
@Data
public class Checkin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reg_id;

    private Date reg_data;
    private Integer reg_cidid;
    private Integer reg_locid;
    private Integer reg_usuid;

    public static Checkin create(Checkin c) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(c, Checkin.class);
    }
}
