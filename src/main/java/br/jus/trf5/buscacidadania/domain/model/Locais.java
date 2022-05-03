package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
