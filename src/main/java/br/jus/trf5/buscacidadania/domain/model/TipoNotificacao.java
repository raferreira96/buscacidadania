package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tb_tiponotificacao")
@Data
public class TipoNotificacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpn_id;

    private String tpn_descricao;
}
