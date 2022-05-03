package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tb_cidadaos")
@Data
public class Cidadaos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid_id;

    private String cid_bio;
    private String cid_nome;
    private Date cid_datanasc;
    private String cid_foto;
}
