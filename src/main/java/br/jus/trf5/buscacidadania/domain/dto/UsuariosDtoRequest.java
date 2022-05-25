package br.jus.trf5.buscacidadania.domain.dto;

import org.modelmapper.ModelMapper;

import br.jus.trf5.buscacidadania.domain.model.Usuarios;
import lombok.Data;

@Data
public class UsuariosDtoRequest {
    
    public String username;
    public String password;

    public static UsuariosDtoRequest create(Usuarios u) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(u, UsuariosDtoRequest.class);
    }
}
