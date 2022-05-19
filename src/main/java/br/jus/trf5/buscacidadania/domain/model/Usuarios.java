package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Entity(name = "tb_usuarios")
@Data
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

    public static Usuarios create(Usuarios u) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(u, Usuarios.class);
    }
}
