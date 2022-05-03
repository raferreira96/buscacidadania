package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tb_notificacoes")
@Data
public class Notificacoes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer not_id;

    private String not_descricao;
    private Date not_data;
    private Integer not_tpnid;
    private Integer not_cidid;
    private Integer not_usuid;
}