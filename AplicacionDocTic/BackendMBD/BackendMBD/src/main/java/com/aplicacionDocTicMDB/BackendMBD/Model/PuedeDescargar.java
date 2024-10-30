package com.aplicacionDocTicMDB.BackendMBD.Model;

import java.sql.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("puedeDescargar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PuedeDescargar {
    
    private ObjectId idDescargar;

    @DBRef
    private ObjectId idUsuario;

    @DBRef
    private ObjectId idDocumento;

    private Date fecha;
        
}
