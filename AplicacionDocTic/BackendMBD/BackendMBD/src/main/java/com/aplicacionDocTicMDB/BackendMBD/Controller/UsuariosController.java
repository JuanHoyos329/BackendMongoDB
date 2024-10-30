package com.aplicacionDocTicMDB.BackendMBD.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacionDocTicMDB.BackendMBD.Model.UsuariosModel;
import com.aplicacionDocTicMDB.BackendMBD.Service.IUsuariosServices;

@RestController
@RequestMapping("/Doctic/apiweb/usuarios")
public class UsuariosController {
    @Autowired
    IUsuariosServices usuariosServices;
    
    @PostMapping("/guardar")
    public ResponseEntity<String> guardarUsuario(@RequestBody UsuariosModel usuario){
        return new ResponseEntity<String>(usuariosServices.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> buscarUsuario(@PathVariable ObjectId idUsuario){
        try {
            UsuariosModel usuario = usuariosServices.buscarUsuario(idUsuario);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/actualizar/{idUsuario}")
    public ResponseEntity<String>actualizarUsuario(@PathVariable ObjectId idUsuario, @RequestBody UsuariosModel usuario){
        try {
            return new ResponseEntity<>(usuariosServices.actualizarUsuario(idUsuario, usuario), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<String>eliminarUsuario(@PathVariable("idUsuario") ObjectId idUsuarios){
        return new ResponseEntity<>(usuariosServices.eliminarUsuario(idUsuarios), HttpStatus.OK);
    }
}
