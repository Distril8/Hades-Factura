/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.factura.service;

import ec.edu.espe.distribuidas.hades.factura.dao.ClienteFacade;
import ec.edu.espe.distribuidas.hades.factura.model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author toshiba
 */
@Stateless
@LocalBean
public class ClienteService  {

    @EJB
    private ClienteFacade clienteFacade;
    
    public List<Cliente> obtenerTodos() {
        return this.clienteFacade.findAll();
    }
    
    public Cliente obtenerPorIdentificacion(String identificacion) {
        return this.clienteFacade.find(identificacion);
    }
    
    public void crear(Cliente cliente) {
        this.clienteFacade.create(cliente);
    }
    
    public void modificar(Cliente cliente) {
        this.clienteFacade.edit(cliente);
    }
    
    public void eliminar(String codigo) {
        Cliente cliente = this.clienteFacade.find(codigo);
        this.clienteFacade.remove(cliente);
    }

}
