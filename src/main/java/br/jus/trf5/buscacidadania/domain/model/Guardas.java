package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tb_guardas")
@Data
public class Guardas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gua_id;

    private Integer gua_usuid;
    private Integer gua_cidid;
}
