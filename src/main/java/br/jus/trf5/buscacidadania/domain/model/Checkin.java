package br.jus.trf5.buscacidadania.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_registros")
public class Checkin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reg_id;

    private Date reg_data;
    private Integer reg_cidid;
    private Integer reg_locid;
    private Integer reg_usuid;

    public Checkin() {
        
    }

    public Integer getReg_id() {
        return reg_id;
    }

    public void setReg_id(Integer reg_id) {
        this.reg_id = reg_id;
    }

    public Date getReg_data() {
        return reg_data;
    }

    public void setReg_data(Date reg_data) {
        this.reg_data = reg_data;
    }

    public Integer getReg_cidid() {
        return reg_cidid;
    }

    public void setReg_cidid(Integer reg_cidid) {
        this.reg_cidid = reg_cidid;
    }

    public Integer getReg_locid() {
        return reg_locid;
    }

    public void setReg_locid(Integer reg_locid) {
        this.reg_locid = reg_locid;
    }

    public Integer getReg_usuid() {
        return reg_usuid;
    }

    public void setReg_usuid(Integer reg_usuid) {
        this.reg_usuid = reg_usuid;
    }
}
