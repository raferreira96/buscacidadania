package br.jus.trf5.buscacidadania.domain.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.jus.trf5.buscacidadania.api.UsuariosController;
import lombok.Data;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Entity(name = "tb_usuarios")
@Data
public class Usuarios extends RepresentationModel<Usuarios> implements UserDetails {

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_usutpu",
                joinColumns = @JoinColumn(name = "utu_usuid", referencedColumnName = "usu_id"),
                inverseJoinColumns = @JoinColumn(name = "utu_tpuid", referencedColumnName = "tpu_id"))
    private List<TipoUsuario> usu_tpuid;

    @ManyToOne
    @JoinColumn(name = "usu_locid", referencedColumnName = "loc_id")
    private Locais usu_locid;

    public static Usuarios create(Usuarios u) {
        ModelMapper modelMapper = new ModelMapper();
        u.add(linkTo(UsuariosController.class).slash(u.getUsu_id()).withSelfRel());
        u.add(linkTo(UsuariosController.class).withRel("allUsuarios"));
        return modelMapper.map(u, Usuarios.class);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return usu_tpuid;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}