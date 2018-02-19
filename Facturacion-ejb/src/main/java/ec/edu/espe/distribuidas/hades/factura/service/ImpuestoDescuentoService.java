/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.factura.service;

import ec.edu.espe.distribuidas.hades.factura.dao.ImpuestoDescuentoFacade;
import ec.edu.espe.distribuidas.hades.factura.model.ImpuestoDescuento;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author toshiba
 */
@Stateless
public class ImpuestoDescuentoService {
    
    @EJB
    private ImpuestoDescuentoFacade impuestoDescuentoFacade;
    
    public List<ImpuestoDescuento> obtenerTodos() {
        return this.impuestoDescuentoFacade.findAll();
    }
    
    public ImpuestoDescuento obtenerPorCodigo(Integer codigo) {
        return this.impuestoDescuentoFacade.find(codigo);
    }
    
    public void crear(ImpuestoDescuento impDescuento) {
        this.impuestoDescuentoFacade.create(impDescuento);
    }
    
    public void modificar(ImpuestoDescuento impDescuento) {
        this.impuestoDescuentoFacade.edit(impDescuento);
    }
    
    public void eliminar(String codigo) {
        ImpuestoDescuento cliente = this.impuestoDescuentoFacade.find(codigo);
        this.impuestoDescuentoFacade.remove(cliente);
    }
    
}
