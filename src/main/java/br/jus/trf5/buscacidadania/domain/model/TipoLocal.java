package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tb_tipolocal")
@Data
public class TipoLocal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpl_id;

    private String tpl_descricao;
}
