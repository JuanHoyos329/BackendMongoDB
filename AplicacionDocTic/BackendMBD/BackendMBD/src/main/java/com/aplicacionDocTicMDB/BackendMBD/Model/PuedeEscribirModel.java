package com.aplicacionDocTicMDB.BackendMBD.Model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aplicacionDocTicMDB.BackendMBD.Model.Enum.Rol;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("puedeEscribir")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuedeEscribirModel {
    
    private ObjectId idEscribir;

    @DBRef
    private ObjectId idUsuario;

    @DBRef
    private ObjectId idDocumento;
    private Rol rol;
    

    //Metodos propios para IdUsuario y IdDocumento
    
    @JsonProperty("idUsuario")
    public String getIdUsuarioString() {
        return idUsuario != null ? idUsuario.toHexString() : null;
    }

    @JsonProperty("idUsuario")
    public String getIdDocumentoString() {
        return idDocumento != null ? idDocumento.toHexString() : null;
    }

}
