package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_notificacoes")
public class Notificacoes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer not_id;

    private String not_descricao;
    private Date not_data;
    private Integer not_tpnid;
    private Integer not_cidid;
    private Integer not_usuid;

    public Notificacoes() {
        
    }

    public Integer getNot_id() {
        return not_id;
    }

    public void setNot_id(Integer not_id) {
        this.not_id = not_id;
    }

    public String getNot_descricao() {
        return not_descricao;
    }

    public void setNot_descricao(String not_descricao) {
        this.not_descricao = not_descricao;
    }

    public Date getNot_data() {
        return not_data;
    }

    public void setNot_data(Date not_data) {
        this.not_data = not_data;
    }

    public Integer getNot_tpnid() {
        return not_tpnid;
    }

    public void setNot_tpnid(Integer not_tpnid) {
        this.not_tpnid = not_tpnid;
    }

    public Integer getNot_cidid() {
        return not_cidid;
    }

    public void setNot_cidid(Integer not_cidid) {
        this.not_cidid = not_cidid;
    }

    public Integer getNot_usuid() {
        return not_usuid;
    }

    public void setNot_usuid(Integer not_usuid) {
        this.not_usuid = not_usuid;
    }
}
