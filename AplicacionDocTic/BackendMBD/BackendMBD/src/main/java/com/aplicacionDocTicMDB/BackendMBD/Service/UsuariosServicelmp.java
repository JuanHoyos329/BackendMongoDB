package com.aplicacionDocTicMDB.BackendMBD.Service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacionDocTicMDB.BackendMBD.Model.UsuariosModel;
import com.aplicacionDocTicMDB.BackendMBD.Repository.UsuariosRepository;

@Service
public class UsuariosServicelmp implements IUsuariosServices {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public String guardarUsuario(UsuariosModel usuario) {
        usuariosRepository.save(usuario);
        return "El usuario " + usuario.getNombre() + " se a creado con exito.";
    }
    
    @Override
    @Transactional
    public String eliminarUsuario(ObjectId idUsuario) {
        if (usuariosRepository.existsById(idUsuario)){
            usuariosRepository.deleteById(idUsuario);
            return "El usuario con id " + idUsuario + " se ha eliminado con exito.";
        } else {
            return "El usuario " + idUsuario + " no se ha encontrado o no existe en la BD.";
        }
    }

    @Override
    public UsuariosModel buscarUsuario(ObjectId idUsuario) {
    return usuariosRepository.findById(idUsuario)
            .orElseThrow(() -> new RuntimeException("El usuario con id " + idUsuario + " no se ha encontrado o no existe en la BD."));
    }

    @Override
    public String actualizarUsuario(ObjectId idUsuario, UsuariosModel usuario) {
        UsuariosModel usuarioActualizado = buscarUsuario(idUsuario);
        if (usuarioActualizado!=null) {
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setEmail(usuario.getEmail());
            usuarioActualizado.setNickname(usuario.getNickname());
            usuarioActualizado.setCiudad(usuario.getCiudad());
            usuarioActualizado.setDepartamento(usuario.getDepartamento());
            usuarioActualizado.setIdUsuario(idUsuario); // Asegura que el ID sea el mismo.
            usuariosRepository.save(usuarioActualizado);
            
            return "El usuario con id " + idUsuario + " se ha actualizado con exito.";
        }
        else {
            return "El usuario con id " + idUsuario + " no existe.";
        }
       
    }
}
