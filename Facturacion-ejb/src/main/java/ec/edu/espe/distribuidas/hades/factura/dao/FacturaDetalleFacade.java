/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.factura.dao;

import ec.edu.espe.distribuidas.hades.factura.model.FacturaDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author toshiba
 */
@Stateless
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle> {

    @PersistenceContext(unitName = "punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaDetalleFacade() {
        super(FacturaDetalle.class);
    }
    
}
