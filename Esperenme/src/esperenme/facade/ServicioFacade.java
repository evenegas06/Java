/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.facade;

import esperenme.dao.ServicioDao;
import esperenme.dto.ServicioDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dan
 */
public class ServicioFacade {
    private Connection cnn;
    private ServicioDao dao;
    
    public ServicioFacade (Connection cnn){
        this.cnn=cnn;
        dao = new ServicioDao();
    }
    public void crear (ServicioDto dto) throws SQLException{
       dao.create(dto, cnn);
    }
    public List listar() throws SQLException{
        return dao.loadAll(cnn);
    }
    public ServicioDto leer(ServicioDto dto) throws SQLException{
        return dao.load(dto, cnn);
    }
    public void actualiza(ServicioDto dto) throws SQLException{
        dao.update(dto, cnn);
    }
    public void elimina(ServicioDto dto) throws SQLException{
        dao.delete(dto, cnn);
    }
}
