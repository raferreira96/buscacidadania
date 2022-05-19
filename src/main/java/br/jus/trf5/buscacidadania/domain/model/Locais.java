package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Entity(name = "tb_locais")
@Data
public class Locais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loc_id;

    private String loc_descricao;
    private String loc_endereco;
    private Integer loc_tplid;

    public static Locais create(Locais l) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(l, Locais.class);
    }
}
