package com.aplicacionDocTicMDB.BackendMBD.Model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aplicacionDocTicMDB.BackendMBD.Model.Enum.Visibilidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("documentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentosModel {
    
    private ObjectId idDocumento;

    @DBRef
    private CategoriasModel categoria;

    private String descripcion;
    private String url;
    private Visibilidad visibilidad;
    private Double valoracionPromedio;
    private int historialDescargas;
    private int historialVisualizaciones;
    private int totalComentarios;
}
