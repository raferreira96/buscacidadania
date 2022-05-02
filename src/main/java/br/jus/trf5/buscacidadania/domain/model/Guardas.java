package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_guardas")
public class Guardas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gua_id;

    private Integer gua_usuid;
    private Integer gua_cidid;

    public Guardas() {
        
    }

    public Integer getGua_id() {
        return gua_id;
    }

    public void setGua_id(Integer gua_id) {
        this.gua_id = gua_id;
    }

    public Integer getGua_usuid() {
        return gua_usuid;
    }

    public void setGua_usuid(Integer gua_usuid) {
        this.gua_usuid = gua_usuid;
    }

    public Integer getGua_cidid() {
        return gua_cidid;
    }

    public void setGua_cidid(Integer gua_cidid) {
        this.gua_cidid = gua_cidid;
    }
}
