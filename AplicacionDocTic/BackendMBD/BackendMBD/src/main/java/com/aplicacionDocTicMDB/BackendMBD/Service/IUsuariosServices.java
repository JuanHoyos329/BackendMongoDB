package com.aplicacionDocTicMDB.BackendMBD.Service;

import org.bson.types.ObjectId;

import com.aplicacionDocTicMDB.BackendMBD.Model.UsuariosModel;

public interface IUsuariosServices {

    String guardarUsuario(UsuariosModel usuario);
    String eliminarUsuario(ObjectId idUsuario);
    String actualizarUsuario(ObjectId idUsuario, UsuariosModel usuario);
    UsuariosModel buscarUsuario(ObjectId idUsuario);
} 

