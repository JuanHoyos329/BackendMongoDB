package com.aplicacionDocTicMDB.BackendMBD.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aplicacionDocTicMDB.BackendMBD.Model.UsuariosModel;

public interface UsuariosRepository extends MongoRepository<UsuariosModel, ObjectId> {
    //Agregaciones
}
