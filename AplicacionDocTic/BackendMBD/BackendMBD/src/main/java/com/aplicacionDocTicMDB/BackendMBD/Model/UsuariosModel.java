package com.aplicacionDocTicMDB.BackendMBD.Model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModel {
    
    private ObjectId idUsuario;

    private String nombre;
    private String email;
    private String nickname;
    private String ciudad;
    private String departamento;  
}
