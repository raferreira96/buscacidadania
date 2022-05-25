package br.jus.trf5.buscacidadania.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.jus.trf5.buscacidadania.domain.model.Usuarios;
import br.jus.trf5.buscacidadania.domain.repository.UsuariosRepository;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UsuariosRepository usuarioRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuarios usuario = usuarioRep.findByUsername(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("user not found");
        }
        
        return usuario;
    }
}
