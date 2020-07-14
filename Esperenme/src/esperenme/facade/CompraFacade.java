/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esperenme.facade;

import esperenme.dao.CompraDao;
import esperenme.dto.CompraDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dan
 */
public class CompraFacade {

    private Connection cnn;
    private CompraDao dao;

    public CompraFacade(Connection cnn) {
        this.cnn = cnn;
        dao = new CompraDao();
    }

    public void crear(CompraDto dto) throws SQLException {
        dao.create(dto, cnn);
    }

    public List listar() throws SQLException {
        return dao.loadAll(cnn);
    }

    /**
     * 
     */
  /*  public List comprasUsuario(CompraDto dto) throws SQLException {
        return dao.comprasPorUsuario(dto,cnn);
    }*/

    public CompraDto leer(CompraDto dto) throws SQLException {
        return dao.load(dto, cnn);
    }

    public void actualiza(CompraDto dto) throws SQLException {
        dao.update(dto, cnn);
    }

    public void elimina(CompraDto dto) throws SQLException {
        dao.delete(dto, cnn);
    }
    
    public CompraDto selecciona(CompraDto dto) throws SQLException {
       return dao.select(dto, cnn);
    }
}
