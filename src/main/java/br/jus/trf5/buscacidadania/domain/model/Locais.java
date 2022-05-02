package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_locais")
public class Locais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loc_id;

    private String loc_descricao;
    private String loc_endereco;
    private Integer loc_tplid;

    public Locais() {

    }

    public Locais(Integer loc_id, String loc_descricao, String loc_endereco, Integer loc_tplid) {
        this.loc_id = loc_id;
        this.loc_descricao = loc_descricao;
        this.loc_endereco = loc_endereco;
        this.loc_tplid = loc_tplid;
    }

    public Integer getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(Integer loc_id) {
        this.loc_id = loc_id;
    }

    public String getLoc_descricao() {
        return loc_descricao;
    }

    public void setLoc_descricao(String loc_descricao) {
        this.loc_descricao = loc_descricao;
    }

    public String getLoc_endereco() {
        return loc_endereco;
    }

    public void setLoc_endereco(String loc_endereco) {
        this.loc_endereco = loc_endereco;
    }

    public Integer getLoc_tplid() {
        return loc_tplid;
    }

    public void setLoc_tplid(Integer loc_tplid) {
        this.loc_tplid = loc_tplid;
    }
    
}
