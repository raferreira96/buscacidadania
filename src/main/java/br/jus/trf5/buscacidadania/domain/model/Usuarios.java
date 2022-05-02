package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usu_id;

    private String usu_username;
    private String usu_password;
    private String usu_nome;
    private String usu_cpf;
    private String usu_email;
    private Integer usu_tpuid;
    private Integer usu_locid;

    public Usuarios() {
        
    }

    public Integer getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Integer usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_username() {
        return usu_username;
    }

    public void setUsu_username(String usu_username) {
        this.usu_username = usu_username;
    }

    public String getUsu_password() {
        return usu_password;
    }

    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_cpf() {
        return usu_cpf;
    }

    public void setUsu_cpf(String usu_cpf) {
        this.usu_cpf = usu_cpf;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public Integer getUsu_tpuid() {
        return usu_tpuid;
    }

    public void setUsu_tpuid(Integer usu_tpuid) {
        this.usu_tpuid = usu_tpuid;
    }

    public Integer getUsu_locid() {
        return usu_locid;
    }

    public void setUsu_locid(Integer usu_locid) {
        this.usu_locid = usu_locid;
    }
    
}
