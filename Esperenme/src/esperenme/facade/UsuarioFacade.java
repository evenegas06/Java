/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.facade;

import esperenme.dao.UsuarioDao;
import esperenme.dto.UsuarioDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dan
 */
public class UsuarioFacade {
    private Connection cnn;
    private UsuarioDao dao;
    
    public UsuarioFacade (Connection cnn){
        this.cnn=cnn;
        dao = new UsuarioDao();
    }
    public void crear (UsuarioDto dto) throws SQLException{
       dao.create(dto, cnn);
    }
    public List listar() throws SQLException{
        return dao.loadAll(cnn);
    }
    public UsuarioDto leer(UsuarioDto dto) throws SQLException{
        return dao.load(dto, cnn);
    }
     public UsuarioDto leerSesion(UsuarioDto dto) throws SQLException{
        return dao.loadSesion(dto, cnn);
    }
     
    public UsuarioDto leerSesionWP(UsuarioDto dto) throws SQLException{
        return dao.loadSesionWP(dto, cnn);
    }
     
    public void actualiza(UsuarioDto dto) throws SQLException{
        dao.update(dto, cnn);
    }
    public void elimina(UsuarioDto dto) throws SQLException{
        dao.delete(dto, cnn);
    }
}
