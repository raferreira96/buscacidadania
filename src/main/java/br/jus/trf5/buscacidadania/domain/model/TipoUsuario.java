package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity(name = "tb_tipousuario")
@Data
public class TipoUsuario implements GrantedAuthority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpu_id;

    private String tpu_descricao;

    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return tpu_descricao;
    }
}
