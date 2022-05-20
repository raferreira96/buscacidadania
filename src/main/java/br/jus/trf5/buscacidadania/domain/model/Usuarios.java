package br.jus.trf5.buscacidadania.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Entity(name = "tb_usuarios")
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usu_id;

    @Column(name = "usu_username")
    public String username;

    @Column(name = "usu_password")
    public String password;

    private String usu_nome;
    private String usu_cpf;
    private String usu_email;

    @ManyToOne
    @JoinColumn(name = "usu_tpuid", referencedColumnName = "tpu_id")
    private TipoUsuario usu_tpuid;

    @ManyToOne
    @JoinColumn(name = "usu_locid", referencedColumnName = "loc_id")
    private Locais usu_locid;

    public static Usuarios create(Usuarios u) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(u, Usuarios.class);
    }
}
