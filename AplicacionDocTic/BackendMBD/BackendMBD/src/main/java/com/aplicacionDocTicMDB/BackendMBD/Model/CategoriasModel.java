package com.aplicacionDocTicMDB.BackendMBD.Model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriasModel {
    
    private ObjectId idCategoria;
    private String nombre;

    @DBRef
    private CategoriasModel SubIdCategoria;
}
