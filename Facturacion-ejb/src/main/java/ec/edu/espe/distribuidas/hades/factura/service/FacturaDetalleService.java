/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.factura.service;

import ec.edu.espe.distribuidas.hades.factura.dao.FacturaDetalleFacade;
import ec.edu.espe.distribuidas.hades.factura.model.FacturaDetalle;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author toshiba
 */
@Stateless
public class FacturaDetalleService  {

    @EJB
    private FacturaDetalleFacade facturaDetalleFacade;
    
    public List<FacturaDetalle> obtenerTodos() {
        return this.facturaDetalleFacade.findAll();
    }
    
    public FacturaDetalle obtenerPorCodigo(Integer codigo) {
        return this.facturaDetalleFacade.find(codigo);
    }
    
    public void crear(FacturaDetalle facturaDetalle) {
        this.facturaDetalleFacade.create(facturaDetalle);
    }
    
    public void modificar(FacturaDetalle facturaDetalle) {
        this.facturaDetalleFacade.edit(facturaDetalle);
    }
    
    public void eliminar(String codigo) {
        FacturaDetalle cliente = this.facturaDetalleFacade.find(codigo);
        this.facturaDetalleFacade.remove(cliente);
    }
}
