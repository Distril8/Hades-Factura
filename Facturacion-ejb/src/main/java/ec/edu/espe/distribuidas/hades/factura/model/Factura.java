/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.hades.factura.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author toshiba
 */
@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CODIGO")
    private Integer codigo;
    
    @Column(name = "RUC", nullable=false, length=13)
    private String ruc;
    
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "SUB_TOTAL", nullable=false, precision = 9, scale = 2)
    private BigDecimal subTotal;
    
    @Column(name = "TOTAL_IMPUESTOS", nullable=false, precision = 9, scale = 2)
    private BigDecimal totalImpuestos;
    
    @Column(name = "DESCUENTO",nullable=false, precision = 9, scale = 2)
    private BigDecimal descuento;
   
    @Column(name = "TOTAL",nullable=false, precision = 9, scale = 2)
    private BigDecimal total;
   
    @Column(name = "ESTADO", nullable = false, length=3)
    private String estado;
    
    /*@OneToMany(mappedBy = "codigo")
    private List<FacturaDetalle> facturaDetalleList;
    @OneToMany(mappedBy = "codigo")
    private List<ImpuestoDescuento> impuestoDescuentoList;*/

    public Factura() {
    }

    public Factura(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(BigDecimal totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "codigo=" + codigo + ", ruc=" + ruc + ", fechaCreacion=" + fechaCreacion + ", fecha=" + fecha + ", subTotal=" + subTotal + ", totalImpuestos=" + totalImpuestos + ", descuento=" + descuento + ", total=" + total + ", estado=" + estado + '}';
    }

    
    
}
