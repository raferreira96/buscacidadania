package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_cidadaos")
public class Cidadaos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid_id;

    private String cid_bio;
    private String cid_nome;
    private Date cid_datanasc;
    private String cid_foto;

    public Cidadaos() {

    }

    public Integer getCid_id() {
        return cid_id;
    }

    public void setCid_id(Integer cid_id) {
        this.cid_id = cid_id;
    }

    public String getCid_bio() {
        return cid_bio;
    }

    public void setCid_bio(String cid_bio) {
        this.cid_bio = cid_bio;
    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    public Date getCid_datanasc() {
        return cid_datanasc;
    }

    public void setCid_datanasc(Date cid_datanasc) {
        this.cid_datanasc = cid_datanasc;
    }

    public String getCid_foto() {
        return cid_foto;
    }

    public void setCid_foto(String cid_foto) {
        this.cid_foto = cid_foto;
    }
    
}
