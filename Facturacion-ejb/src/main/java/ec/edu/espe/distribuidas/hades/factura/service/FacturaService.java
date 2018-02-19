/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.factura.service;

import ec.edu.espe.distribuidas.hades.factura.dao.FacturaFacade;
import ec.edu.espe.distribuidas.hades.factura.model.Cliente;
import ec.edu.espe.distribuidas.hades.factura.model.Factura;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author toshiba
 */
@Stateless
public class FacturaService {

    @EJB
    private FacturaFacade facturaFacade;
    
    public List<Factura> obtenerTodos() {
        return this.facturaFacade.findAll();
    }
    
    public Factura obtenerPorCodigo(Integer codigo) {
        return this.facturaFacade.find(codigo);
    }
    
    public void crear(Factura factura) {
        this.facturaFacade.create(factura);
    }
    
    public void modificar(Factura factura) {
        this.facturaFacade.edit(factura);
    }
    
    public void eliminar(String codigo) {
        Factura cliente = this.facturaFacade.find(codigo);
        this.facturaFacade.remove(cliente);
    }
    
    public void verificarEdad(Cliente cliente, Factura factura) {
       
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse((CharSequence)cliente.getFechaNacimiento(),fmt);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual); 
        if (periodo.getYears() >65)
        {
           factura.setTotalImpuestos(BigDecimal.ZERO);
           factura.setDescuento(BigDecimal.valueOf(0.15));
        }
    }
}
